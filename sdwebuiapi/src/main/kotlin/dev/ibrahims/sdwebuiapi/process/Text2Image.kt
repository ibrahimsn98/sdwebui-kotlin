package dev.ibrahims.sdwebuiapi.process

import dev.ibrahims.sdwebuiapi.payload.script.ScriptPayload
import dev.ibrahims.sdwebuiapi.payload.Text2ImagePayload
import dev.ibrahims.sdwebuiapi.response.ProcessResponse
import dev.ibrahims.sdwebuiapi.service.StableDiffusionService

class Text2Image private constructor(
    private val stableDiffusionService: StableDiffusionService,
    private val payload: Text2ImagePayload,
) : Process {

    suspend fun run(): Result<ProcessResponse> {
        return stableDiffusionService.text2Image(payload)
    }

    class Builder internal constructor(
        private val stableDiffusionService: StableDiffusionService,
    ) {

        private var prompt: String = ""
        private var negativePrompt: String = ""
        private var styles: List<String> = emptyList()
        private var seed: Int = -1
        private var subseed: Int = -1
        private var subseedStrength: Int = 0
        private var seedResizeFromH: Int = 0
        private var seedResizeFromW: Int = 0
        private var samplerName: String = ""
        private var batchSize: Int = 1
        private var nIter: Int = 1
        private var steps: Int = 25
        private var cfgScale: Float = 7.0f
        private var width: Int = 512
        private var height: Int = 512
        private var restoreFaces: Boolean = false
        private var tiling: Boolean = false
        private var doNotSaveSamples: Boolean = false
        private var doNotSaveGrid: Boolean = false
        private var eta: Float = 1.0f
        private var denoisingStrength: Float = 0.7f
        private var sChurn: Int = 0
        private var sTmax: Int = 0
        private var sTmin: Int = 0
        private var sNoise: Int = 1
        private var overrideSettings: Map<String, String> = emptyMap()
        private var overrideSettingsRestoreAfterwards: Boolean = true
        private var comments: Map<String, String> = emptyMap()
        private var enableHr: Boolean = false
        private var firstphaseWidth: Int = 0
        private var firstphaseHeight: Int = 0
        private var hrScale: Int = 0
        private var hrUpscaler: String = "Latent"
        private var hrSecondPassSteps: Int = 0
        private var hrResizeX: Int = 0
        private var hrResizeY: Int = 0
        private var samplerIndex: String = ""
        private var scriptName: String? = null
        private var scriptArgs: List<String> = emptyList()
        private var sendImages: Boolean = true
        private var saveImages: Boolean = false
        private var alwaysonScripts: MutableMap<String, ScriptPayload> = mutableMapOf()

        fun prompt(prompt: String) = apply { this.prompt = prompt }
        fun negativePrompt(negativePrompt: String) = apply { this.negativePrompt = negativePrompt }
        fun styles(styles: List<String>) = apply { this.styles = styles }
        fun seed(seed: Int) = apply { this.seed = seed }
        fun subseed(subseed: Int) = apply { this.subseed = subseed }
        fun subseedStrength(subseedStrength: Int) = apply { this.subseedStrength = subseedStrength }
        fun seedResizeFromH(seedResizeFromH: Int) = apply { this.seedResizeFromH = seedResizeFromH }
        fun seedResizeFromW(seedResizeFromW: Int) = apply { this.seedResizeFromW = seedResizeFromW }
        fun samplerName(samplerName: String) = apply {
            this.samplerName = samplerName
            this.samplerIndex = samplerName
        }
        fun batchSize(batchSize: Int) = apply { this.batchSize = batchSize }
        fun nIter(nIter: Int) = apply { this.nIter = nIter }
        fun steps(steps: Int) = apply { this.steps = steps }
        fun cfgScale(cfgScale: Float) = apply { this.cfgScale = cfgScale }
        fun width(width: Int) = apply { this.width = width }
        fun height(height: Int) = apply { this.height = height }
        fun restoreFaces(restoreFaces: Boolean) = apply { this.restoreFaces = restoreFaces }
        fun tiling(tiling: Boolean) = apply { this.tiling = tiling }
        fun doNotSaveSamples(doNotSaveSamples: Boolean) = apply { this.doNotSaveSamples = doNotSaveSamples }
        fun doNotSaveGrid(doNotSaveGrid: Boolean) = apply { this.doNotSaveGrid = doNotSaveGrid }
        fun eta(eta: Float) = apply { this.eta = eta }
        fun denoisingStrength(denoisingStrength: Float) = apply { this.denoisingStrength = denoisingStrength }
        fun sChurn(sChurn: Int) = apply { this.sChurn = sChurn }
        fun sTmax(sTmax: Int) = apply { this.sTmax = sTmax }
        fun sTmin(sTmin: Int) = apply { this.sTmin = sTmin }
        fun sNoise(sNoise: Int) = apply { this.sNoise = sNoise }
        fun overrideSettings(overrideSettings: Map<String, String>) = apply { this.overrideSettings = overrideSettings }
        fun overrideSettingsRestoreAfterwards(overrideSettingsRestoreAfterwards: Boolean) = apply {
            this.overrideSettingsRestoreAfterwards = overrideSettingsRestoreAfterwards
        }
        fun comments(comments: Map<String, String>) = apply { this.comments = comments }
        fun enableHr(enableHr: Boolean) = apply { this.enableHr = enableHr }
        fun firstphaseWidth(firstphaseWidth: Int) = apply { this.firstphaseWidth = firstphaseWidth }
        fun firstphaseHeight(firstphaseHeight: Int) = apply { this.firstphaseHeight = firstphaseHeight }
        fun hrScale(hrScale: Int) = apply { this.hrScale = hrScale }
        fun hrUpscaler(hrUpscaler: String) = apply { this.hrUpscaler = hrUpscaler }
        fun hrSecondPassSteps(hrSecondPassSteps: Int) = apply { this.hrSecondPassSteps = hrSecondPassSteps }
        fun hrResizeX(hrResizeX: Int) = apply { this.hrResizeX = hrResizeX }
        fun hrResizeY(hrResizeY: Int) = apply { this.hrResizeY = hrResizeY }
        fun samplerIndex(samplerIndex: String) = apply { this.samplerIndex = samplerIndex }
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

        fun build(): Text2Image = Text2Image(
            stableDiffusionService = stableDiffusionService,
            payload = Text2ImagePayload(
                prompt = prompt,
                negativePrompt = negativePrompt,
                styles = styles,
                seed = seed,
                subseed = subseed,
                subseedStrength = subseedStrength,
                seedResizeFromH = seedResizeFromH,
                seedResizeFromW = seedResizeFromW,
                samplerName = samplerName,
                batchSize = batchSize,
                nIter = nIter,
                steps = steps,
                cfgScale = cfgScale,
                width = width,
                height = height,
                restoreFaces = restoreFaces,
                tiling = tiling,
                doNotSaveSamples = doNotSaveSamples,
                doNotSaveGrid = doNotSaveGrid,
                eta = eta,
                denoisingStrength = denoisingStrength,
                sChurn = sChurn,
                sTmax = sTmax,
                sTmin = sTmin,
                sNoise = sNoise,
                overrideSettings = overrideSettings,
                overrideSettingsRestoreAfterwards = overrideSettingsRestoreAfterwards,
                comments = comments,
                enableHr = enableHr,
                firstphaseWidth = firstphaseWidth,
                firstphaseHeight = firstphaseHeight,
                hrScale = hrScale,
                hrUpscaler = hrUpscaler,
                hrSecondPassSteps = hrSecondPassSteps,
                hrResizeX = hrResizeX,
                hrResizeY = hrResizeY,
                samplerIndex = samplerIndex,
                scriptName = scriptName,
                scriptArgs = scriptArgs,
                sendImages = sendImages,
                saveImages = saveImages,
                alwaysonScripts = alwaysonScripts,
            )
        )
    }
}
