package dev.ibrahims.sdwebuiapi.service

import dev.ibrahims.sdwebuiapi.response.ControlNetControlTypesResponse
import dev.ibrahims.sdwebuiapi.response.ControlNetModelsResponse
import dev.ibrahims.sdwebuiapi.response.ControlNetModulesResponse
import dev.ibrahims.sdwebuiapi.response.ControlNetVersionResponse
import io.ktor.client.*

class ControlNetServiceImpl(
    override val baseUrl: String,
    override val client: HttpClient,
) : Service(), ControlNetService {

    override suspend fun getVersion(): Result<ControlNetVersionResponse> {
        return getRequest("controlnet/version")
    }

    override suspend fun getModels(): Result<ControlNetModelsResponse> {
        return getRequest("controlnet/model_list")
    }

    override suspend fun getModules(): Result<ControlNetModulesResponse> {
        return getRequest("controlnet/module_list")
    }

    override suspend fun getControlTypes(): Result<ControlNetControlTypesResponse> {
        return getRequest("controlnet/control_types")
    }

    override suspend fun getSettings(): Result<String> {
        return getRequest("controlnet/settings")
    }
}
