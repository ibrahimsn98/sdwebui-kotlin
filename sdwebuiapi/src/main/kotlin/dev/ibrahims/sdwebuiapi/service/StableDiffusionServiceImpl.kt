package dev.ibrahims.sdwebuiapi.service

import dev.ibrahims.sdwebuiapi.payload.Image2ImagePayload
import dev.ibrahims.sdwebuiapi.payload.Text2ImagePayload
import dev.ibrahims.sdwebuiapi.response.ProcessResponse
import io.ktor.client.*

class StableDiffusionServiceImpl(
    override val baseUrl: String,
    override val client: HttpClient,
) : Service(), StableDiffusionService {

    override suspend fun text2Image(payload: Text2ImagePayload): Result<ProcessResponse> {
        return postRequest("sdapi/v1/txt2img", payload)
    }

    override suspend fun image2Image(payload: Image2ImagePayload): Result<ProcessResponse> {
        return postRequest("sdapi/v1/img2img", payload)
    }

    override suspend fun getOptions(): Result<String> {
        return getRequest("sdapi/v1/options")
    }

    override suspend fun setModel(model: String): Result<Unit> {
        return postRequest("sdapi/v1/options", mapOf("sd_model_checkpoint" to model))
    }

    override suspend fun getCmdFlags(): Result<String> {
        return getRequest("sdapi/v1/cmd-flags")
    }

    override suspend fun getProgress(): Result<String> {
        return getRequest("sdapi/v1/progress")
    }

    override suspend fun getSamplers(): Result<String> {
        return getRequest("sdapi/v1/samplers")
    }

    override suspend fun getSdVae(): Result<String> {
        return getRequest("sdapi/v1/sd-vae")
    }

    override suspend fun getUpscalers(): Result<String> {
        return getRequest("sdapi/v1/upscalers")
    }

    override suspend fun getLatentUpscaleModes(): Result<String> {
        return getRequest("sdapi/v1/latent-upscale-modes")
    }

    override suspend fun getLoras(): Result<String> {
        return getRequest("sdapi/v1/loras")
    }

    override suspend fun getSdModels(): Result<String> {
        return getRequest("sdapi/v1/sd-models")
    }

    override suspend fun getHypernetworks(): Result<String> {
        return getRequest("sdapi/v1/hypernetworks")
    }

    override suspend fun getFaceRestorers(): Result<String> {
        return getRequest("sdapi/v1/face-restorers")
    }

    override suspend fun getRealesrganModels(): Result<String> {
        return getRequest("sdapi/v1/realesrgan-models")
    }

    override suspend fun getPromptStyles(): Result<String> {
        return getRequest("sdapi/v1/prompt-styles")
    }

    override suspend fun refreshCheckpoints(): Result<String> {
        return getRequest("sdapi/v1/refresh-checkpoints")
    }

    override suspend fun getScripts(): Result<String> {
        return getRequest("sdapi/v1/scripts")
    }

    override suspend fun getEmbeddings(): Result<String> {
        return getRequest("sdapi/v1/embeddings")
    }

    override suspend fun getMemory(): Result<String> {
        return getRequest("sdapi/v1/memory")
    }
}
