package dev.ibrahims.sdwebuiapi.process

import dev.ibrahims.sdwebuiapi.payload.Image2ImagePayload
import dev.ibrahims.sdwebuiapi.payload.script.ScriptPayload
import dev.ibrahims.sdwebuiapi.response.ProcessResponse
import dev.ibrahims.sdwebuiapi.service.StableDiffusionService

class Image2Image private constructor(
    private val stableDiffusionService: StableDiffusionService,
    private val payload: Image2ImagePayload,
) : Process {

    suspend fun run(): Result<ProcessResponse> {
        return stableDiffusionService.image2Image(payload)
    }

    class Builder internal constructor(
        private val stableDiffusionService: StableDiffusionService,
    ) {

        private var initImages: List<String> = emptyList()
        private var prompt: String = ""
        private var negativePrompt: String = ""
        private var resizeMode: Int = 0
        private var denoisingStrength: Float = 0.75f
        private var mask: String? = null
        private var maskBlur: Int = 4
        private var inpaintingFill: Int = 0
        private var inpaintFullRes: Boolean = true
        private var inpaintFullResPadding: Int = 0
        private var inpaintingMaskInvert: Int = 0
        private var initialNoiseMultiplier: Int = 1
        private var styles: List<String> = emptyList()
        private var seed: Int = -1
        private var subseed: Int = -1
        private var subseedStrength: Int = 0
        private var seedResizeFromH: Int = 0
        private var seedResizeFromW: Int = 0
        private var batchSize: Int = 1
        private var nIter: Int = 1
        private var steps: Int = 20
        private var cfgScale: Float = 7.0f
        private var imageCfgScale: Float = 1.5f
        private var width: Int = 512
        private var height: Int = 512
        private var restoreFaces: Boolean = false
        private var tiling: Boolean = false
        private var doNotSaveSamples: Boolean = false
        private var eta: Float = 1.0f
        private var sChurn: Int = 0
        private var sTmax: Int = 0
        private var sTmin: Int = 0
        private var sNoise: Int = 1
        private var overrideSettings: Map<String, String> = emptyMap()
        private var overrideSettingsRestoreAfterwards: Boolean = true
        private var samplerName: String = ""
        private var samplerIndex: String = ""
        private var includeInitImages: Boolean = false
        private var scriptName: String? = null
        private var scriptArgs: List<String> = emptyList()
        private var sendImages: Boolean = true
        private var saveImages: Boolean = false
        private var alwaysonScripts: MutableMap<String, ScriptPayload> = mutableMapOf()

        fun initImages(initImages: List<String>) = apply { this.initImages = initImages }
        fun prompt(prompt: String) = apply { this.prompt = prompt }
        fun negativePrompt(negativePrompt: String) = apply { this.negativePrompt = negativePrompt }
        fun resizeMode(resizeMode: Int) = apply { this.resizeMode = resizeMode }
        fun denoisingStrength(denoisingStrength: Float) = apply { this.denoisingStrength = denoisingStrength }
        fun mask(mask: String?) = apply { this.mask = mask }
        fun maskBlur(maskBlur: Int) = apply { this.maskBlur = maskBlur }
        fun inpaintingFill(inpaintingFill: Int) = apply { this.inpaintingFill = inpaintingFill }
        fun inpaintFullRes(inpaintFullRes: Boolean) = apply { this.inpaintFullRes = inpaintFullRes }
        fun inpaintFullResPadding(inpaintFullResPadding: Int) = apply { this.inpaintFullResPadding = inpaintFullResPadding }
        fun inpaintingMaskInvert(inpaintingMaskInvert: Int) = apply { this.inpaintingMaskInvert = inpaintingMaskInvert }
        fun initialNoiseMultiplier(initialNoiseMultiplier: Int) = apply { this.initialNoiseMultiplier = initialNoiseMultiplier }
        fun styles(styles: List<String>) = apply { this.styles = styles }
        fun seed(seed: Int) = apply { this.seed = seed }
        fun subseed(subseed: Int) = apply { this.subseed = subseed }
        fun subseedStrength(subseedStrength: Int) = apply { this.subseedStrength = subseedStrength }
        fun seedResizeFromH(seedResizeFromH: Int) = apply { this.seedResizeFromH = seedResizeFromH }
        fun seedResizeFromW(seedResizeFromW: Int) = apply { this.seedResizeFromW = seedResizeFromW }
        fun batchSize(batchSize: Int) = apply { this.batchSize = batchSize }
        fun nIter(nIter: Int) = apply { this.nIter = nIter }
        fun steps(steps: Int) = apply { this.steps = steps }
        fun cfgScale(cfgScale: Float) = apply { this.cfgScale = cfgScale }
        fun imageCfgScale(imageCfgScale: Float) = apply { this.imageCfgScale = imageCfgScale }
        fun width(width: Int) = apply { this.width = width }
        fun height(height: Int) = apply { this.height = height }
        fun restoreFaces(restoreFaces: Boolean) = apply { this.restoreFaces = restoreFaces }
        fun tiling(tiling: Boolean) = apply { this.tiling = tiling }
        fun doNotSaveSamples(doNotSaveSamples: Boolean) = apply { this.doNotSaveSamples = doNotSaveSamples }
        fun eta(eta: Float) = apply { this.eta = eta }
        fun sChurn(sChurn: Int) = apply { this.sChurn = sChurn }
        fun sTmax(sTmax: Int) = apply { this.sTmax = sTmax }
        fun sTmin(sTmin: Int) = apply { this.sTmin = sTmin }
        fun sNoise(sNoise: Int) = apply { this.sNoise = sNoise }
        fun overrideSettings(overrideSettings: Map<String, String>) = apply { this.overrideSettings = overrideSettings }
        fun overrideSettingsRestoreAfterwards(overrideSettingsRestoreAfterwards: Boolean) = apply {
            this.overrideSettingsRestoreAfterwards = overrideSettingsRestoreAfterwards
        }
        fun samplerName(samplerName: String) = apply { this.samplerName = samplerName }
        fun samplerIndex(samplerIndex: String) = apply { this.samplerIndex = samplerIndex }
        fun includeInitImages(includeInitImages: Boolean) = apply { this.includeInitImages = includeInitImages }
        fun scriptName(scriptName: String) = apply { this.scriptName = scriptName }
        fun scriptArgs(scriptArgs: List<String>) = apply { this.scriptArgs = scriptArgs }
        fun sendImages(sendImages: Boolean) = apply { this.sendImages = sendImages }
        fun saveImages(saveImages: Boolean) = apply { this.saveImages = saveImages }

        fun alwaysonScripts(alwaysonScripts: Map<String, ScriptPayload>) = apply {
            this.alwaysonScripts.clear()
            this.alwaysonScripts.putAll(alwaysonScripts)
        }

        fun addAlwaysonScripts(alwaysonScripts: Map<String, ScriptPayload>) = apply {
            this.alwaysonScripts.putAll(alwaysonScripts)
        }

        fun build(): Image2Image = Image2Image(
            stableDiffusionService = stableDiffusionService,
            payload = Image2ImagePayload(
                initImages = initImages,
                prompt = prompt,
                negativePrompt = negativePrompt,
                resizeMode = resizeMode,
                denoisingStrength = denoisingStrength,
                mask = mask,
                maskBlur = maskBlur,
                inpaintingFill = inpaintingFill,
                inpaintFullRes = inpaintFullRes,
                inpaintFullResPadding = inpaintFullResPadding,
                inpaintingMaskInvert = inpaintingMaskInvert,
                initialNoiseMultiplier = initialNoiseMultiplier,
                styles = styles,
                seed = seed,
                subseed = subseed,
                subseedStrength = subseedStrength,
                seedResizeFromH = seedResizeFromH,
                seedResizeFromW = seedResizeFromW,
                batchSize = batchSize,
                nIter = nIter,
                steps = steps,
                cfgScale = cfgScale,
                imageCfgScale = imageCfgScale,
                width = width,
                height = height,
                restoreFaces = restoreFaces,
                tiling = tiling,
                doNotSaveSamples = doNotSaveSamples,
                eta = eta,
                sChurn = sChurn,
                sTmax = sTmax,
                sTmin = sTmin,
                sNoise = sNoise,
                overrideSettings = overrideSettings,
                overrideSettingsRestoreAfterwards = overrideSettingsRestoreAfterwards,
                samplerName = samplerName,
                samplerIndex = samplerIndex,
                includeInitImages = includeInitImages,
                scriptName = scriptName,
                scriptArgs = scriptArgs,
                sendImages = sendImages,
                saveImages = saveImages,
                alwaysonScripts = alwaysonScripts,
            )
        )
    }
}
