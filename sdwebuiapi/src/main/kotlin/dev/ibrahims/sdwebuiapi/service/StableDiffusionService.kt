package dev.ibrahims.sdwebuiapi.service

import dev.ibrahims.sdwebuiapi.payload.Image2ImagePayload
import dev.ibrahims.sdwebuiapi.payload.Text2ImagePayload
import dev.ibrahims.sdwebuiapi.response.*
import kotlinx.serialization.json.JsonObject

interface StableDiffusionService {

    suspend fun text2Image(payload: Text2ImagePayload): Result<ProcessResponse>

    suspend fun image2Image(payload: Image2ImagePayload): Result<ProcessResponse>

    suspend fun getModels(): Result<List<ModelResponse>>

    suspend fun getSamplers(): Result<String>

    suspend fun getEmbeddings(): Result<String>

    suspend fun getVae(): Result<List<VaeResponse>>

    suspend fun getLoras(): Result<String>

    suspend fun getOptions(): Result<String>

    suspend fun getCmdFlags(): Result<String>

    suspend fun getExtensions(): Result<List<ExtensionResponse>>

    suspend fun getHypernetworks(): Result<String>

    suspend fun getFaceRestorers(): Result<List<FaceRestorerResponse>>

    suspend fun getRealesrganModels(): Result<List<RealesrganModelResponse>>

    suspend fun getPromptStyles(): Result<String>

    suspend fun getUpscalers(): Result<List<UpscalerResponse>>

    suspend fun getLatentUpscaleModes(): Result<List<LatentUpscaleModeResponse>>

    suspend fun getScripts(): Result<ScriptsResponse>

    suspend fun getScriptInfo(): Result<String>

    suspend fun getProgress(): Result<ProgressResponse>

    suspend fun getMemory(): Result<MemoryResponse>

    suspend fun setModel(model: String): Result<Unit>

    suspend fun refreshCheckpoints(): Result<Unit>
}
