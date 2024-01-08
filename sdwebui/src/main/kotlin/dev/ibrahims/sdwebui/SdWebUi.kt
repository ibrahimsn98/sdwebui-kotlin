package dev.ibrahims.sdwebui

import dev.ibrahims.sdwebui.internal.extension.buildUrl
import dev.ibrahims.sdwebui.response.ErrorResponse
import dev.ibrahims.sdwebui.service.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class SdWebUi private constructor(
    private val host: String,
    private val port: Int,
    private val useHttps: Boolean,
    private val client: HttpClient,
) {

    private val baseUrl: String by lazy {
        buildUrl(host, port, useHttps)
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

        private var host: String = DEFAULT_HOST

        private var port: Int = DEFAULT_PORT

        private var useHttps: Boolean = false

        fun host(host: String) = apply { this.host = host }

        fun port(port: Int) = apply { this.port = port }

        fun useHttps(useHttps: Boolean) = apply { this.useHttps = useHttps }

        fun build() = SdWebUi(
            host = host,
            port = port,
            useHttps = useHttps,
            client = createClient(),
        )

        private fun createClient() = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(createJson())
            }
            install(HttpTimeout) {
                requestTimeoutMillis = DEFAULT_TIMEOUT
            }
        }

        @OptIn(ExperimentalSerializationApi::class)
        private fun createJson() = Json {
            isLenient = false
            ignoreUnknownKeys = true
            encodeDefaults = true
            explicitNulls = false
        }
    }

    companion object {

        const val DEFAULT_HOST: String = "127.0.0.1"
        const val DEFAULT_PORT: Int = 7860
        const val DEFAULT_TIMEOUT: Long = 50 * 60 * 1000
    }
}
