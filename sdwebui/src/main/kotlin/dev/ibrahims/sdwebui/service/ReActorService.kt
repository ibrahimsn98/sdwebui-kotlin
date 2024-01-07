package dev.ibrahims.sdwebui.service

import dev.ibrahims.sdwebui.response.ReActorModelsResponse
import dev.ibrahims.sdwebui.response.ReActorUpscalersResponse

interface ReActorService {

    suspend fun getModels(): Result<ReActorModelsResponse>

    suspend fun getUpscalers(): Result<ReActorUpscalersResponse>
}
