package dev.ibrahims.sdwebuiapi.service

import dev.ibrahims.sdwebuiapi.response.ReActorModelsResponse
import dev.ibrahims.sdwebuiapi.response.ReActorUpscalersResponse

interface ReActorService {

    suspend fun getModels(): Result<ReActorModelsResponse>

    suspend fun getUpscalers(): Result<ReActorUpscalersResponse>
}
