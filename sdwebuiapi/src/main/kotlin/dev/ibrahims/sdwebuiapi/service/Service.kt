package dev.ibrahims.sdwebuiapi.service

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
        client.get {
            url("$baseUrl/$path")
            contentType(ContentType.Application.Json)
        }.body()
    }

    protected suspend inline fun <reified T> postRequest(
        path: String,
        body: Any? = null,
    ): Result<T> = runCatching {
        client.post {
            url("$baseUrl/$path")
            contentType(ContentType.Application.Json)
            if (body != null) setBody(body)
        }.body()
    }
}
