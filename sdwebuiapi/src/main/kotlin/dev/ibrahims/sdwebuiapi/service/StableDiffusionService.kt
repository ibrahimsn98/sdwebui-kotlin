package dev.ibrahims.sdwebuiapi.service

import dev.ibrahims.sdwebuiapi.payload.Image2ImagePayload
import dev.ibrahims.sdwebuiapi.payload.Text2ImagePayload
import dev.ibrahims.sdwebuiapi.response.ProcessResponse

interface StableDiffusionService {
    
    suspend fun text2Image(payload: Text2ImagePayload): Result<ProcessResponse>

    suspend fun image2Image(payload: Image2ImagePayload): Result<ProcessResponse>

    suspend fun getOptions(): Result<String>

    suspend fun setModel(model: String): Result<Unit>

    suspend fun getCmdFlags(): Result<String>

    suspend fun getProgress(): Result<String>

    suspend fun getSamplers(): Result<String>

    suspend fun getSdVae(): Result<String>

    suspend fun getUpscalers(): Result<String>

    suspend fun getLatentUpscaleModes(): Result<String>

    suspend fun getLoras(): Result<String>

    suspend fun getSdModels(): Result<String>

    suspend fun getHypernetworks(): Result<String>

    suspend fun getFaceRestorers(): Result<String>

    suspend fun getRealesrganModels(): Result<String>

    suspend fun getPromptStyles(): Result<String>

    suspend fun refreshCheckpoints(): Result<String>

    suspend fun getScripts(): Result<String>

    suspend fun getEmbeddings(): Result<String>

    suspend fun getMemory(): Result<String>
}
