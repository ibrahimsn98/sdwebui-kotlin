package dev.ibrahims.sdwebui

import dev.ibrahims.sdwebui.client.Client
import dev.ibrahims.sdwebui.client.DefaultClient
import dev.ibrahims.sdwebui.internal.extension.buildUrl
import dev.ibrahims.sdwebui.service.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

class SdWebUi private constructor(
    private val host: String,
    private val port: Int,
    private val useHttps: Boolean,
    private val client: Client,
    private val json: Json,
) {

    private val baseUrl: String by lazy {
        buildUrl(host, port, useHttps)
    }

    val core: CoreService by lazy {
        CoreServiceImpl(baseUrl, client, json)
    }

    val stableDiffusion: StableDiffusionService by lazy {
        StableDiffusionServiceImpl(baseUrl, client, json)
    }

    val controlNet: ControlNetService by lazy {
        ControlNetServiceImpl(baseUrl, client,json)
    }

    val reActor: ReActorService by lazy {
        ReActorServiceImpl(baseUrl, client, json)
    }

    class Builder {

        private var host: String = DEFAULT_HOST

        private var port: Int = DEFAULT_PORT

        private var useHttps: Boolean = false

        private var client: Client? = null

        fun host(host: String) = apply {
            this.host = host
        }

        fun port(port: Int) = apply {
            this.port = port
        }

        fun useHttps(useHttps: Boolean) = apply {
            this.useHttps = useHttps
        }

        fun client(client: Client) = apply {
            this.client = client
        }

        fun build() = SdWebUi(
            host = host,
            port = port,
            useHttps = useHttps,
            client = client ?: DefaultClient(json),
            json = json,
        )

        @OptIn(ExperimentalSerializationApi::class)
        private val json: Json by lazy {
            Json {
                isLenient = false
                ignoreUnknownKeys = true
                encodeDefaults = true
                explicitNulls = false
            }
        }
    }

    companion object {

        const val DEFAULT_HOST: String = "127.0.0.1"
        const val DEFAULT_PORT: Int = 7860
        const val DEFAULT_TIMEOUT: Long = 50 * 60 * 1000
    }
}
