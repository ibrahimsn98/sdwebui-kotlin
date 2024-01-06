package dev.ibrahims.sdwebuiapi.extension

import dev.ibrahims.sdwebuiapi.payload.script.ReActorScriptArgs
import dev.ibrahims.sdwebuiapi.payload.script.ScriptPayload
import dev.ibrahims.sdwebuiapi.process.Image2Image

class ReActor private constructor(
    internal val payload: ReActorScriptArgs,
) : Extension {

    class Builder {

        private var image: String? = null
        private var enable: String = ""
        private var sourceFacesIndex: String = ""
        private var facesIndex: String = ""
        private var model: String = ""
        private var faceRestorerName: String = ""
        private var faceRestorerVisibility: String = ""
        private var restoreFirst: String = ""
        private var upscalerName: String = ""
        private var upscalerScale: String = ""
        private var upscalerVisibility: String = ""
        private var swapInSource: String = ""
        private var swapInGenerated: String = ""
        private var consoleLoggingLevel: String = ""
        private var genderSource: String = ""
        private var saveOriginal: String = ""
        private var codeFormerWeight: String = ""
        private var sourceHashCheck: String = ""
        private var targetHashCheck: String = ""
        private var device: String = ""
        private var maskFace: String = ""
        private var selectSource: String = ""
        private var faceModel: String = ""

        fun image(image: String?) = apply { this.image = image }
        fun enable(enable: String) = apply { this.enable = enable }
        fun sourceFacesIndex(sourceFacesIndex: String) = apply { this.sourceFacesIndex = sourceFacesIndex }
        fun facesIndex(facesIndex: String) = apply { this.facesIndex = facesIndex }
        fun model(model: String) = apply { this.model = model }
        fun faceRestorerName(faceRestorerName: String) = apply { this.faceRestorerName = faceRestorerName }
        fun faceRestorerVisibility(faceRestorerVisibility: String) = apply {
            this.faceRestorerVisibility = faceRestorerVisibility
        }
        fun restoreFirst(restoreFirst: String) = apply { this.restoreFirst = restoreFirst }
        fun upscalerName(upscalerName: String) = apply { this.upscalerName = upscalerName }
        fun upscalerScale(upscalerScale: String) = apply { this.upscalerScale = upscalerScale }
        fun upscalerVisibility(upscalerVisibility: String) = apply { this.upscalerVisibility = upscalerVisibility }
        fun swapInSource(swapInSource: String) = apply { this.swapInSource = swapInSource }
        fun swapInGenerated(swapInGenerated: String) = apply { this.swapInGenerated = swapInGenerated }
        fun consoleLoggingLevel(consoleLoggingLevel: String) = apply { this.consoleLoggingLevel = consoleLoggingLevel }
        fun genderSource(genderSource: String) = apply { this.genderSource = genderSource }
        fun saveOriginal(saveOriginal: String) = apply { this.saveOriginal = saveOriginal }
        fun codeFormerWeight(codeFormerWeight: String) = apply { this.codeFormerWeight = codeFormerWeight }
        fun sourceHashCheck(sourceHashCheck: String) = apply { this.sourceHashCheck = sourceHashCheck }
        fun targetHashCheck(targetHashCheck: String) = apply { this.targetHashCheck = targetHashCheck }
        fun device(device: String) = apply { this.device = device }
        fun maskFace(maskFace: String) = apply { this.maskFace = maskFace }
        fun selectSource(selectSource: String) = apply { this.selectSource = selectSource }
        fun faceModel(faceModel: String) = apply { this.faceModel = faceModel }

        fun build() = ReActor(
            payload = ReActorScriptArgs(
                image = image,
                enable = enable,
                sourceFacesIndex = sourceFacesIndex,
                facesIndex = facesIndex,
                model = model,
                faceRestorerName = faceRestorerName,
                faceRestorerVisibility = faceRestorerVisibility,
                restoreFirst = restoreFirst,
                upscalerName = upscalerName,
                upscalerScale = upscalerScale,
                upscalerVisibility = upscalerVisibility,
                swapInSource = swapInSource,
                swapInGenerated = swapInGenerated,
                consoleLoggingLevel = consoleLoggingLevel,
                genderSource = genderSource,
                saveOriginal = saveOriginal,
                codeFormerWeight = codeFormerWeight,
                sourceHashCheck = sourceHashCheck,
                targetHashCheck = targetHashCheck,
                device = device,
                maskFace = maskFace,
                selectSource = selectSource,
                faceModel = faceModel,
            )
        )
    }

    companion object {

        fun Image2Image.Builder.reActor(reActor: ReActor) = apply {
            addAlwaysonScripts(
                mapOf("reactor" to ScriptPayload(args = listOf(reActor.payload)))
            )
        }
    }
}
