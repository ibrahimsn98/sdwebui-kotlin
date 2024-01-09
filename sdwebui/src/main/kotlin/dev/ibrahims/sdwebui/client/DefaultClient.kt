package dev.ibrahims.sdwebui.client

import dev.ibrahims.sdwebui.SdWebUi
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class DefaultClient(private val json: Json) : Client() {

    private val httpClient: HttpClient by lazy {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(json)
            }
            install(HttpTimeout) {
                requestTimeoutMillis = SdWebUi.DEFAULT_TIMEOUT
            }
        }
    }

    override suspend fun request(builder: RequestBuilder.() -> RequestBuilder): Response {
        val request = RequestBuilder().builder().build()
        val httpResponse = httpClient.request {
            url("${request.baseUrl}/${request.path}")
            method = HttpMethod(request.method.name)
            contentType(ContentType.Application.Json)
            if (request.body != null && request.bodyType != null) {
                setBody(request.body, request.bodyType)
            }
        }
        return Response(
            isSuccess = httpResponse.status.isSuccess(),
            body = httpResponse.body(),
        )
    }
}
