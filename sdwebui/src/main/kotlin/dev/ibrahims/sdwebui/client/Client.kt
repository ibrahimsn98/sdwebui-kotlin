package dev.ibrahims.sdwebui.client

import io.ktor.util.reflect.*
import kotlinx.serialization.json.Json

abstract class Client {

    abstract suspend fun request(builder: RequestBuilder.() -> RequestBuilder): Response

    class RequestBuilder {

        private var baseUrl: String = ""

        private var path: String = ""

        private var method: Method = Method.GET

        var body: Any? = null

        var bodyType: TypeInfo? = null

        fun baseUrl(baseUrl: String) = apply {
            this.baseUrl = baseUrl
        }

        fun path(path: String) = apply {
            this.path = path
        }

        fun method(method: Method) = apply {
            this.method = method
        }

        fun build() = Request(
            baseUrl = baseUrl,
            path = path,
            method = method,
            body = body,
            bodyType = bodyType,
        )
    }

    data class Request(
        val baseUrl: String,
        val path: String,
        val method: Method,
        val body: Any?,
        val bodyType: TypeInfo?,
    )

    data class Response(
        val isSuccess: Boolean,
        val body: String,
    )

    data class Error(val body: String) : Throwable(body)

    enum class Method {
        GET,
        POST
    }

    companion object {

        suspend inline fun <reified T> Client.get(json: Json, baseUrl: String, path: String): Result<T> = request {
            baseUrl(baseUrl)
            path(path)
        }.load(json)

        suspend inline fun <reified T> Client.post(
            json: Json,
            noinline builder: RequestBuilder.() -> RequestBuilder,
        ): Result<T> = request {
            builder()
            method(Method.POST)
        }.load(json)

        inline fun <reified T> Response.load(json: Json): Result<T> {
            if (T::class == Unit::class) {
                return Result.success(Unit as T)
            }
            if (!isSuccess) {
                return Result.failure(Error(body))
            }
            return runCatching {
                json.decodeFromString(body)
            }
        }

        inline fun <reified T> RequestBuilder.body(body: T): RequestBuilder = apply {
            this.body = body
            this.bodyType = typeInfo<T>()
        }
    }
}
