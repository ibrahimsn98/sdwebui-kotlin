package dev.ibrahims.sdwebui.service

import dev.ibrahims.sdwebui.SdWebUi
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

abstract class Service {

    abstract val baseUrl: String

    abstract val client: HttpClient

    protected suspend inline fun <reified T> getRequest(
        path: String,
    ): Result<T> = runCatching {
        val response = client.get {
            url("$baseUrl/$path")
            contentType(ContentType.Application.Json)
        }
        if (response.status.isSuccess()) {
            response.body()
        } else {
            throw Throwable(response.body<String>())
        }
    }

    protected suspend inline fun <reified T> postRequest(
        path: String,
        body: Any? = null,
    ): Result<T> = runCatching {
        val response = client.post {
            url("$baseUrl/$path")
            contentType(ContentType.Application.Json)
            if (body != null) setBody(body)
        }
        if (response.status.isSuccess()) {
            response.body()
        } else {
            throw SdWebUi.Error(response.body())
        }
    }
}
