package dev.ibrahims.sdwebui.service

import dev.ibrahims.sdwebui.client.Client
import dev.ibrahims.sdwebui.client.Client.Companion.get
import dev.ibrahims.sdwebui.response.ControlNetControlTypesResponse
import dev.ibrahims.sdwebui.response.ControlNetModelsResponse
import dev.ibrahims.sdwebui.response.ControlNetModulesResponse
import dev.ibrahims.sdwebui.response.ControlNetVersionResponse
import kotlinx.serialization.json.Json

class ControlNetServiceImpl(
    override val baseUrl: String,
    override val client: Client,
    override val json: Json,
) : Service(), ControlNetService {

    override suspend fun getVersion(): Result<ControlNetVersionResponse> {
        return client.get(json, baseUrl, "controlnet/version")
    }

    override suspend fun getModels(): Result<ControlNetModelsResponse> {
        return client.get(json, baseUrl, "controlnet/model_list")
    }

    override suspend fun getModules(): Result<ControlNetModulesResponse> {
        return client.get(json, baseUrl, "controlnet/module_list")
    }

    override suspend fun getControlTypes(): Result<ControlNetControlTypesResponse> {
        return client.get(json, baseUrl, "controlnet/control_types")
    }

    override suspend fun getSettings(): Result<String> {
        return client.get(json, baseUrl, "controlnet/settings")
    }
}
