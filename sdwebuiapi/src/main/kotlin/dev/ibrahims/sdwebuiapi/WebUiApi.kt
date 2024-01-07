package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.internal.buildUrl
import dev.ibrahims.sdwebuiapi.response.ErrorResponse
import dev.ibrahims.sdwebuiapi.service.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class WebUiApi private constructor(
    private val host: String,
    private val port: Int,
    private val useHttps: Boolean,
) {

    private val baseUrl: String by lazy {
        buildUrl(host, port, useHttps)
    }

    @OptIn(ExperimentalSerializationApi::class)
    private val json by lazy {
        Json {
            isLenient = false
            ignoreUnknownKeys = true
            encodeDefaults = true
            explicitNulls = false
        }
    }

    private val client by lazy {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(json)
            }
            install(HttpTimeout) {
                requestTimeoutMillis = DEFAULT_TIMEOUT
            }
        }
    }

    val core: CoreService by lazy {
        CoreServiceImpl(baseUrl, client)
    }

    val stableDiffusion: StableDiffusionService by lazy {
        StableDiffusionServiceImpl(baseUrl, client)
    }

    val controlNet: ControlNetService by lazy {
        ControlNetServiceImpl(baseUrl, client)
    }

    val reActor: ReActorService by lazy {
        ReActorServiceImpl(baseUrl, client)
    }

    @Serializable
    data class Error(val response: ErrorResponse) : Throwable(response.errors)

    class Builder {

        private var host: String = "127.0.0.1"

        private var port: Int = 7860

        private var useHttps: Boolean = false

        fun host(host: String) = apply { this.host = host }

        fun port(port: Int) = apply { this.port = port }

        fun useHttps(useHttps: Boolean) = apply { this.useHttps = useHttps }

        fun build() = WebUiApi(
            host = host,
            port = port,
            useHttps = useHttps,
        )
    }

    companion object {

        const val DEFAULT_TIMEOUT: Long = 50 * 60 * 1000
    }
}
