package dev.ibrahims.sdwebui.service

import dev.ibrahims.sdwebui.client.Client
import dev.ibrahims.sdwebui.client.Client.Companion.body
import dev.ibrahims.sdwebui.client.Client.Companion.get
import dev.ibrahims.sdwebui.client.Client.Companion.post
import dev.ibrahims.sdwebui.payload.*
import dev.ibrahims.sdwebui.response.*
import kotlinx.serialization.json.Json

class StableDiffusionServiceImpl(
    override val baseUrl: String,
    override val client: Client,
    override val json: Json,
) : Service(), StableDiffusionService {

    override suspend fun text2Image(payload: Text2ImagePayload): Result<GenerateProcessResponse> {
        return client.post(json) {
            baseUrl(baseUrl)
            path("sdapi/v1/txt2img")
            body(payload)
        }
    }

    override suspend fun image2Image(payload: Image2ImagePayload): Result<GenerateProcessResponse> {
        return client.post(json) {
            baseUrl(baseUrl)
            path("sdapi/v1/img2img")
            body(payload)
        }
    }

    override suspend fun extraSingleImage(payload: ExtraSingleImagePayload): Result<ExtraSingleImageResponse> {
        return client.post(json) {
            baseUrl(baseUrl)
            path("sdapi/v1/extra-single-image")
            body(payload)
        }
    }

    override suspend fun extraBatchImages(payload: ExtraBatchImagesPayload): Result<ExtraBatchImagesResponse> {
        return client.post(json) {
            baseUrl(baseUrl)
            path("sdapi/v1/extra-batch-images")
            body(payload)
        }
    }

    override suspend fun getModels(): Result<List<ModelResponse>> {
        return client.get(json, baseUrl, "sdapi/v1/sd-models")
    }

    override suspend fun getSamplers(): Result<String> {
        return client.get(json, baseUrl, "sdapi/v1/samplers")
    }

    override suspend fun getEmbeddings(): Result<String> {
        return client.get(json, baseUrl, "sdapi/v1/embeddings")
    }

    override suspend fun getVae(): Result<List<VaeResponse>> {
        return client.get(json, baseUrl, "sdapi/v1/sd-vae")
    }

    override suspend fun getLoras(): Result<String> {
        return client.get(json, baseUrl, "sdapi/v1/loras")
    }

    override suspend fun getOptions(): Result<String> {
        return client.get(json, baseUrl, "sdapi/v1/options")
    }

    override suspend fun getCmdFlags(): Result<String> {
        return client.get(json, baseUrl, "sdapi/v1/cmd-flags")
    }

    override suspend fun getExtensions(): Result<List<ExtensionResponse>> {
        return client.get(json, baseUrl, "sdapi/v1/extensions")
    }

    override suspend fun getHypernetworks(): Result<String> {
        return client.get(json, baseUrl, "sdapi/v1/hypernetworks")
    }

    override suspend fun getFaceRestorers(): Result<List<FaceRestorerResponse>> {
        return client.get(json, baseUrl, "sdapi/v1/face-restorers")
    }

    override suspend fun getRealesrganModels(): Result<List<RealesrganModelResponse>> {
        return client.get(json, baseUrl, "sdapi/v1/realesrgan-models")
    }

    override suspend fun getPromptStyles(): Result<String> {
        return client.get(json, baseUrl, "sdapi/v1/prompt-styles")
    }

    override suspend fun getUpscalers(): Result<List<UpscalerResponse>> {
        return client.get(json, baseUrl, "sdapi/v1/upscalers")
    }

    override suspend fun getLatentUpscaleModes(): Result<List<LatentUpscaleModeResponse>> {
        return client.get(json, baseUrl, "sdapi/v1/latent-upscale-modes")
    }

    override suspend fun getScripts(): Result<ScriptsResponse> {
        return client.get(json, baseUrl, "sdapi/v1/scripts")
    }

    override suspend fun getScriptInfo(): Result<String> {
        return client.get(json, baseUrl, "sdapi/v1/script-info")
    }

    override suspend fun getProgress(): Result<ProgressResponse> {
        return client.get(json, baseUrl, "sdapi/v1/progress")
    }

    override suspend fun getMemory(): Result<MemoryResponse> {
        return client.get(json, baseUrl, "sdapi/v1/memory")
    }

    override suspend fun setModel(model: String): Result<Unit> {
        return client.post(json) {
            baseUrl(baseUrl)
            path("sdapi/v1/options")
            body(mapOf("sd_model_checkpoint" to model))
        }
    }

    override suspend fun refreshCheckpoints(): Result<Unit> {
        return client.post(json) {
            baseUrl(baseUrl)
            path("sdapi/v1/refresh-checkpoints")
        }
    }

    override suspend fun remBG(payload: RemBGPayload): Result<RemBGResponse> {
        return client.post(json) {
            baseUrl(baseUrl)
            path("rembg")
            body(payload)
        }
    }
}
