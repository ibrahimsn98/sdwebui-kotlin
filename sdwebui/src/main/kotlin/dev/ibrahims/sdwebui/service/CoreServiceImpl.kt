package dev.ibrahims.sdwebui.service

import dev.ibrahims.sdwebui.client.Client
import dev.ibrahims.sdwebui.client.Client.Companion.get
import dev.ibrahims.sdwebui.response.QueueResponse
import kotlinx.serialization.json.Json

class CoreServiceImpl(
    override val baseUrl: String,
    override val client: Client,
    override val json: Json,
) : Service(), CoreService {

    override suspend fun getQueue(): Result<QueueResponse> {
        return client.get(json, baseUrl, "queue/status")
    }
}
