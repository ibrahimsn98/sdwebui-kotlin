package dev.ibrahims.sdwebui.service

import dev.ibrahims.sdwebui.client.Client
import kotlinx.serialization.json.Json

abstract class Service {

    abstract val baseUrl: String

    abstract val client: Client

    abstract val json: Json
}
