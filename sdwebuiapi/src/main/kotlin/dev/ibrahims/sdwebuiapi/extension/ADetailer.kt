package dev.ibrahims.sdwebuiapi.extension

import dev.ibrahims.sdwebuiapi.payload.script.ADetailerScriptArgs
import dev.ibrahims.sdwebuiapi.payload.script.ScriptPayload
import dev.ibrahims.sdwebuiapi.process.Process

class ADetailer private constructor(
    internal val args: ADetailerScriptArgs,
) : Extension {

    class Builder {

        private var model: String = "None"
        private var prompt: String = ""
        private var negativePrompt: String = ""
        private var confidence: Float = 0.3f
        private var maskKLargest: Float = 0.0f
        private var maskMinRatio: Float = 0.0f
        private var maskMaxRatio: Float = 1.0f
        private var dilateErode: Int = 4
        private var xOffset: Int = 0
        private var yOffset: Int = 0
        private var maskMergeInvert: String = "None"
        private var maskBlur: Int = 4
        private var denoisingStrength: Float = 0.4f
        private var inpaintOnlyMasked: Boolean = true
        private var inpaintOnlyMaskedPadding: Int = 32
        private var useInpaintWidthHeight: Boolean = false
        private var inpaintWidth: Int = 512
        private var inpaintHeight: Int = 512
        private var useSteps: Boolean = false
        private var steps: Int = 28
        private var useCfgScale: Boolean = false
        private var cfgScale: Float = 7.0f
        private var useNoiseMultiplier: Boolean = false
        private var noiseMultiplier: Float = 1.0f
        private var useClipSkip: Boolean = false
        private var clipSkip: Int = 1
        private var restoreFace: Boolean = false
        private var controlNetModel: String = "None"
        private var controlNetModule: String = "None"
        private var controlNetWeight: Float = 1.0f
        private var controlNetGuidanceStart: Float = 0.0f
        private var controlNetGuidanceEnd: Float = 1.0f

        fun model(model: String) = apply { this.model = model }
        fun prompt(prompt: String) = apply { this.prompt = prompt }
        fun negativePrompt(negativePrompt: String) = apply { this.negativePrompt = negativePrompt }
        fun confidence(confidence: Float) = apply { this.confidence = confidence }
        fun maskKLargest(maskKLargest: Float) = apply { this.maskKLargest = maskKLargest }
        fun maskMinRatio(maskMinRatio: Float) = apply { this.maskMinRatio = maskMinRatio }
        fun maskMaxRatio(maskMaxRatio: Float) = apply { this.maskMaxRatio = maskMaxRatio }
        fun dilateErode(dilateErode: Int) = apply { this.dilateErode = dilateErode }
        fun xOffset(xOffset: Int) = apply { this.xOffset = xOffset }
        fun yOffset(yOffset: Int) = apply { this.yOffset = yOffset }
        fun maskMergeInvert(maskMergeInvert: String) = apply { this.maskMergeInvert = maskMergeInvert }
        fun maskBlur(maskBlur: Int) = apply { this.maskBlur = maskBlur }
        fun denoisingStrength(denoisingStrength: Float) = apply { this.denoisingStrength = denoisingStrength }
        fun inpaintOnlyMasked(inpaintOnlyMasked: Boolean) = apply { this.inpaintOnlyMasked = inpaintOnlyMasked }
        fun inpaintOnlyMaskedPadding(inpaintOnlyMaskedPadding: Int) = apply {
            this.inpaintOnlyMaskedPadding = inpaintOnlyMaskedPadding
        }
        fun useInpaintWidthHeight(useInpaintWidthHeight: Boolean) = apply {
            this.useInpaintWidthHeight = useInpaintWidthHeight
        }
        fun inpaintWidth(inpaintWidth: Int) = apply { this.inpaintWidth = inpaintWidth }
        fun inpaintHeight(inpaintHeight: Int) = apply { this.inpaintHeight = inpaintHeight }
        fun useSteps(useSteps: Boolean) = apply { this.useSteps = useSteps }
        fun steps(steps: Int) = apply { this.steps = steps }
        fun useCfgScale(useCfgScale: Boolean) = apply { this.useCfgScale = useCfgScale }
        fun cfgScale(cfgScale: Float) = apply { this.cfgScale = cfgScale }
        fun useNoiseMultiplier(useNoiseMultiplier: Boolean) = apply { this.useNoiseMultiplier = useNoiseMultiplier }
        fun noiseMultiplier(noiseMultiplier: Float) = apply { this.noiseMultiplier = noiseMultiplier }
        fun useClipSkip(useClipSkip: Boolean) = apply { this.useClipSkip = useClipSkip }
        fun clipSkip(clipSkip: Int) = apply { this.clipSkip = clipSkip }
        fun restoreFace(restoreFace: Boolean) = apply { this.restoreFace = restoreFace }
        fun controlNetModel(controlNetModel: String) = apply { this.controlNetModel = controlNetModel }
        fun controlNetModule(controlNetModule: String) = apply { this.controlNetModule = controlNetModule }
        fun controlNetWeight(controlNetWeight: Float) = apply { this.controlNetWeight = controlNetWeight }
        fun controlNetGuidanceStart(controlNetGuidanceStart: Float) = apply {
            this.controlNetGuidanceStart = controlNetGuidanceStart
        }
        fun controlNetGuidanceEnd(controlNetGuidanceEnd: Float) = apply {
            this.controlNetGuidanceEnd = controlNetGuidanceEnd
        }

        fun build() = ADetailer(
            args = ADetailerScriptArgs(
                model = model,
                prompt = prompt,
                negativePrompt = negativePrompt,
                confidence = confidence,
                maskKLargest = maskKLargest,
                maskMinRatio = maskMinRatio,
                maskMaxRatio = maskMaxRatio,
                dilateErode = dilateErode,
                xOffset = xOffset,
                yOffset = yOffset,
                maskMergeInvert = maskMergeInvert,
                maskBlur = maskBlur,
                denoisingStrength = denoisingStrength,
                inpaintOnlyMasked = inpaintOnlyMasked,
                inpaintOnlyMaskedPadding = inpaintOnlyMaskedPadding,
                useInpaintWidthHeight = useInpaintWidthHeight,
                inpaintWidth = inpaintWidth,
                inpaintHeight = inpaintHeight,
                useSteps = useSteps,
                steps = steps,
                useCfgScale = useCfgScale,
                cfgScale = cfgScale,
                useNoiseMultiplier = useNoiseMultiplier,
                noiseMultiplier = noiseMultiplier,
                useClipSkip = useClipSkip,
                clipSkip = clipSkip,
                restoreFace = restoreFace,
                controlNetModel = controlNetModel,
                controlNetModule = controlNetModule,
                controlNetWeight = controlNetWeight,
                controlNetGuidanceStart = controlNetGuidanceStart,
                controlNetGuidanceEnd = controlNetGuidanceEnd,
            )
        )
    }

    companion object {

        fun aDetailer(init: Builder.() -> Unit): ADetailer {
            val builder = Builder()
            builder.init()
            return builder.build()
        }

        fun <T : Process.Builder> T.aDetailer(aDetailer: ADetailer) = apply {
            addAlwaysonScript("ADetailer", ScriptPayload.Single(aDetailer.args))
        }
    }
}
