package dev.ibrahims.sdwebui.service

import dev.ibrahims.sdwebui.response.ControlNetControlTypesResponse
import dev.ibrahims.sdwebui.response.ControlNetModelsResponse
import dev.ibrahims.sdwebui.response.ControlNetModulesResponse
import dev.ibrahims.sdwebui.response.ControlNetVersionResponse

interface ControlNetService {

    suspend fun getVersion(): Result<ControlNetVersionResponse>

    suspend fun getModels(): Result<ControlNetModelsResponse>

    suspend fun getModules(): Result<ControlNetModulesResponse>

    suspend fun getControlTypes(): Result<ControlNetControlTypesResponse>

    suspend fun getSettings(): Result<String>
}
