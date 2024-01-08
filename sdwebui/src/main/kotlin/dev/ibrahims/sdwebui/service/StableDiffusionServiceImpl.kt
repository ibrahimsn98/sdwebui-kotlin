package dev.ibrahims.sdwebui.service

import dev.ibrahims.sdwebui.interceptor.Interceptor
import dev.ibrahims.sdwebui.payload.ExtraBatchImagesPayload
import dev.ibrahims.sdwebui.payload.ExtraSingleImagePayload
import dev.ibrahims.sdwebui.payload.Image2ImagePayload
import dev.ibrahims.sdwebui.payload.Text2ImagePayload
import dev.ibrahims.sdwebui.response.*
import io.ktor.client.*

class StableDiffusionServiceImpl(
    override val baseUrl: String,
    override val client: HttpClient,
    override val interceptors: List<Interceptor>,
) : Service(), StableDiffusionService {

    override suspend fun text2Image(payload: Text2ImagePayload): Result<GenerateProcessResponse> {
        return postRequest("sdapi/v1/txt2img", payload)
    }

    override suspend fun image2Image(payload: Image2ImagePayload): Result<GenerateProcessResponse> {
        return postRequest("sdapi/v1/img2img", payload)
    }

    override suspend fun extraSingleImage(payload: ExtraSingleImagePayload): Result<ExtraSingleImageResponse> {
        return postRequest("sdapi/v1/extra-single-image", payload)
    }

    override suspend fun extraBatchImages(payload: ExtraBatchImagesPayload): Result<ExtraBatchImagesResponse> {
        return postRequest("sdapi/v1/extra-batch-images", payload)
    }

    override suspend fun getModels(): Result<List<ModelResponse>> {
        return getRequest("sdapi/v1/sd-models")
    }

    override suspend fun getSamplers(): Result<String> {
        return getRequest("sdapi/v1/samplers")
    }

    override suspend fun getEmbeddings(): Result<String> {
        return getRequest("sdapi/v1/embeddings")
    }

    override suspend fun getVae(): Result<List<VaeResponse>> {
        return getRequest("sdapi/v1/sd-vae")
    }

    override suspend fun getLoras(): Result<String> {
        return getRequest("sdapi/v1/loras")
    }

    override suspend fun getOptions(): Result<String> {
        return getRequest("sdapi/v1/options")
    }

    override suspend fun getCmdFlags(): Result<String> {
        return getRequest("sdapi/v1/cmd-flags")
    }

    override suspend fun getExtensions(): Result<List<ExtensionResponse>> {
        return getRequest("sdapi/v1/extensions")
    }

    override suspend fun getHypernetworks(): Result<String> {
        return getRequest("sdapi/v1/hypernetworks")
    }

    override suspend fun getFaceRestorers(): Result<List<FaceRestorerResponse>> {
        return getRequest("sdapi/v1/face-restorers")
    }

    override suspend fun getRealesrganModels(): Result<List<RealesrganModelResponse>> {
        return getRequest("sdapi/v1/realesrgan-models")
    }

    override suspend fun getPromptStyles(): Result<String> {
        return getRequest("sdapi/v1/prompt-styles")
    }

    override suspend fun getUpscalers(): Result<List<UpscalerResponse>> {
        return getRequest("sdapi/v1/upscalers")
    }

    override suspend fun getLatentUpscaleModes(): Result<List<LatentUpscaleModeResponse>> {
        return getRequest("sdapi/v1/latent-upscale-modes")
    }

    override suspend fun getScripts(): Result<ScriptsResponse> {
        return getRequest("sdapi/v1/scripts")
    }

    override suspend fun getScriptInfo(): Result<String> {
        return getRequest("sdapi/v1/script-info")
    }

    override suspend fun getProgress(): Result<ProgressResponse> {
        return getRequest("sdapi/v1/progress")
    }

    override suspend fun getMemory(): Result<MemoryResponse> {
        return getRequest("sdapi/v1/memory")
    }

    override suspend fun setModel(model: String): Result<Unit> {
        return postRequest("sdapi/v1/options", mapOf("sd_model_checkpoint" to model))
    }

    override suspend fun refreshCheckpoints(): Result<Unit> {
        return postRequest("sdapi/v1/refresh-checkpoints")
    }
}
