package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.service.StableDiffusionService
import dev.ibrahims.sdwebuiapi.service.StableDiffusionServiceImpl
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class WebUiApi private constructor(
    private val host: String,
    private val port: Int,
) {

    private val json by lazy {
        Json {
            isLenient = false
            ignoreUnknownKeys = true
            encodeDefaults = true
        }
    }

    private val client by lazy {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(json)
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 50 * 60 * 1000
            }
        }
    }

    val stableDiffusion: StableDiffusionService by lazy {
        StableDiffusionServiceImpl("http://$host:$port", client)
    }

    class Builder {

        private var host: String = "127.0.0.1"

        private var port: Int = 7860

        fun host(host: String) = apply { this.host = host }

        fun port(port: Int) = apply { this.port = port }

        fun build() = WebUiApi(host, port)
    }
}
