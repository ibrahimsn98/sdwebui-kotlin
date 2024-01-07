package dev.ibrahims.sdwebuiapi.service

import dev.ibrahims.sdwebuiapi.response.ControlNetControlTypesResponse
import dev.ibrahims.sdwebuiapi.response.ControlNetModelsResponse
import dev.ibrahims.sdwebuiapi.response.ControlNetModulesResponse
import dev.ibrahims.sdwebuiapi.response.ControlNetVersionResponse

interface ControlNetService {

    suspend fun getVersion(): Result<ControlNetVersionResponse>

    suspend fun getModels(): Result<ControlNetModelsResponse>

    suspend fun getModules(): Result<ControlNetModulesResponse>

    suspend fun getControlTypes(): Result<ControlNetControlTypesResponse>

    suspend fun getSettings(): Result<String>
}
