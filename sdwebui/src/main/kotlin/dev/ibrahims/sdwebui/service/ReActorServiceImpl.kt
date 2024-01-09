package dev.ibrahims.sdwebui.service

import dev.ibrahims.sdwebui.client.Client
import dev.ibrahims.sdwebui.client.Client.Companion.get
import dev.ibrahims.sdwebui.response.ReActorModelsResponse
import dev.ibrahims.sdwebui.response.ReActorUpscalersResponse
import kotlinx.serialization.json.Json

class ReActorServiceImpl(
    override val baseUrl: String,
    override val client: Client,
    override val json: Json,
) : Service(), ReActorService {

    override suspend fun getModels(): Result<ReActorModelsResponse> {
        return client.get(json, baseUrl, "reactor/models")
    }

    override suspend fun getUpscalers(): Result<ReActorUpscalersResponse> {
        return client.get(json, baseUrl, "reactor/upscalers")
    }
}
