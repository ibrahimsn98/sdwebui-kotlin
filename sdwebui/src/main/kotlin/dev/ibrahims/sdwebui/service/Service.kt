package dev.ibrahims.sdwebui.service

import dev.ibrahims.sdwebui.SdWebUi
import dev.ibrahims.sdwebui.interceptor.Interceptor
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

abstract class Service {

    abstract val baseUrl: String

    abstract val client: HttpClient

    abstract val interceptors: List<Interceptor>

    protected suspend inline fun <reified T> getRequest(
        path: String,
    ): Result<T> = runCatching {
        val url = interceptors.fold(path) { next, interceptor ->
            interceptor.interceptUrl(baseUrl, next)
        }
        val response = client.get {
            url(url)
            contentType(ContentType.Application.Json)
        }
        if (response.status.isSuccess()) {
            response.body()
        } else {
            throw SdWebUi.Error(response.body())
        }
    }

    protected suspend inline fun <reified T> postRequest(
        path: String,
        payload: Any? = null,
    ): Result<T> = runCatching {
        val url = interceptors.fold(path) { next, interceptor ->
            interceptor.interceptUrl(baseUrl, next)
        }
        val body =  interceptors.fold(payload) { next, interceptor ->
            interceptor.interceptBody(next)
        }
        val response = client.post {
            url(url)
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
