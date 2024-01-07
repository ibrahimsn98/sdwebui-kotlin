package dev.ibrahims.sdwebui.process

import dev.ibrahims.sdwebui.payload.ExtraSingleImagePayload
import dev.ibrahims.sdwebui.payload.script.ScriptPayload
import dev.ibrahims.sdwebui.response.ExtraProcessResponse
import dev.ibrahims.sdwebui.service.StableDiffusionService

class ExtraSingleImage private constructor(
    private val stableDiffusionService: StableDiffusionService,
    private val payload: ExtraSingleImagePayload,
) : Process {

    suspend fun run(): Result<ExtraProcessResponse> {
        return stableDiffusionService.extraSingleImage(payload)
    }

    class Builder internal constructor(
        private val stableDiffusionService: StableDiffusionService,
    ) : Process.Builder {

        private var resizeMode: Int = 0
        private var showExtrasResults: Boolean = true
        private var gfpganVisibility: Int = 0
        private var codeformerVisibility: Int = 0
        private var codeformerWeight: Int = 0
        private var upscalingResize: Int = 2
        private var upscalingResizeW: Int = 512
        private var upscalingResizeH: Int = 512
        private var upscalingCrop: Boolean = true
        private var upscaler1: String = "None"
        private var upscaler2: String = "None"
        private var extrasUpscaler2Visibility: Int = 0
        private var upscaleFirst: Boolean = false
        private var image: String = ""

        fun resizeMode(resizeMode: Int) = apply {
            this.resizeMode = resizeMode
        }

        fun showExtrasResults(showExtrasResults: Boolean) = apply {
            this.showExtrasResults = showExtrasResults
        }

        fun gfpganVisibility(gfpganVisibility: Int) = apply {
            this.gfpganVisibility = gfpganVisibility
        }

        fun codeformerVisibility(codeformerVisibility: Int) = apply {
            this.codeformerVisibility = codeformerVisibility
        }

        fun codeformerWeight(codeformerWeight: Int) = apply {
            this.codeformerWeight = codeformerWeight
        }

        fun upscalingResize(upscalingResize: Int) = apply {
            this.upscalingResize = upscalingResize
        }

        fun upscalingResizeW(upscalingResizeW: Int) = apply {
            this.upscalingResizeW = upscalingResizeW
        }

        fun upscalingResizeH(upscalingResizeH: Int) = apply {
            this.upscalingResizeH = upscalingResizeH
        }

        fun upscalingCrop(upscalingCrop: Boolean) = apply {
            this.upscalingCrop = upscalingCrop
        }

        fun upscaler1(upscaler1: String) = apply {
            this.upscaler1 = upscaler1
        }

        fun upscaler2(upscaler2: String) = apply {
            this.upscaler2 = upscaler2
        }

        fun extrasUpscaler2Visibility(extrasUpscaler2Visibility: Int) = apply {
            this.extrasUpscaler2Visibility = extrasUpscaler2Visibility
        }

        fun upscaleFirst(upscaleFirst: Boolean) = apply {
            this.upscaleFirst = upscaleFirst
        }

        fun image(image: String) = apply {
            this.image = image }

        override fun addAlwaysonScript(key: String, payload: ScriptPayload) {
            // Do nothing
        }

        fun build(): ExtraSingleImage = ExtraSingleImage(
            stableDiffusionService = stableDiffusionService,
            payload = ExtraSingleImagePayload(
                resizeMode = resizeMode,
                showExtrasResults = showExtrasResults,
                gfpganVisibility = gfpganVisibility,
                codeformerVisibility = codeformerVisibility,
                codeformerWeight = codeformerWeight,
                upscalingResize = upscalingResize,
                upscalingResizeW = upscalingResizeW,
                upscalingResizeH = upscalingResizeH,
                upscalingCrop = upscalingCrop,
                upscaler1 = upscaler1,
                upscaler2 = upscaler2,
                extrasUpscaler2Visibility = extrasUpscaler2Visibility,
                upscaleFirst = upscaleFirst,
                image = image,
            )
        )
    }
}
