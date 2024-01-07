package dev.ibrahims.sdwebui.extension

import dev.ibrahims.sdwebui.payload.script.ScriptPayload
import dev.ibrahims.sdwebui.process.Process
import kotlinx.serialization.json.JsonPrimitive

class ReActor private constructor(
    internal val args: List<JsonPrimitive>,
) : Extension {

    class Builder {

        private var image: String? = null
        private var enable: Boolean = true
        private var sourceFacesIndex: String = "0"
        private var facesIndex: String = "0"
        private var model: String = "inswapper_128.onnx"
        private var faceRestorerName: String = "CodeFormer"
        private var faceRestorerVisibility: Float = 1f
        private var restoreFirst: Boolean = true
        private var upscalerName: String = "R-ESRGAN 4x+"
        private var upscalerScale: Int = 2
        private var upscalerVisibility: Float = 1f
        private var swapInSource: Boolean = false
        private var swapInGenerated: Boolean = true
        private var consoleLoggingLevel: Int = 1
        private var genderSource: Int = 0
        private var genderTarget: Int = 0
        private var saveOriginal: Boolean = false
        private var codeFormerWeight: Float = 0.5f
        private var sourceHashCheck: Boolean = true
        private var targetHashCheck: Boolean = false
        private var device: String = "CUDA"
        private var maskFace: Boolean = true
        private var selectSource: Int = 0
        private var faceModel: String? = null

        fun image(image: String?) = apply {
            this.image = image
        }

        fun enable(enable: Boolean) = apply {
            this.enable = enable
        }

        fun sourceFacesIndex(sourceFacesIndex: String) = apply {
            this.sourceFacesIndex = sourceFacesIndex
        }

        fun facesIndex(facesIndex: String) = apply {
            this.facesIndex = facesIndex
        }

        fun model(model: String) = apply {
            this.model = model
        }

        fun faceRestorerName(faceRestorerName: String) = apply {
            this.faceRestorerName = faceRestorerName
        }

        fun faceRestorerVisibility(faceRestorerVisibility: Float) = apply {
            this.faceRestorerVisibility = faceRestorerVisibility
        }

        fun restoreFirst(restoreFirst: Boolean) = apply {
            this.restoreFirst = restoreFirst
        }

        fun upscalerName(upscalerName: String) = apply {
            this.upscalerName = upscalerName
        }

        fun upscalerScale(upscalerScale: Int) = apply {
            this.upscalerScale = upscalerScale
        }

        fun upscalerVisibility(upscalerVisibility: Float) = apply {
            this.upscalerVisibility = upscalerVisibility
        }

        fun swapInSource(swapInSource: Boolean) = apply {
            this.swapInSource = swapInSource
        }

        fun swapInGenerated(swapInGenerated: Boolean) = apply {
            this.swapInGenerated = swapInGenerated
        }

        fun consoleLoggingLevel(consoleLoggingLevel: Int) = apply {
            this.consoleLoggingLevel = consoleLoggingLevel
        }

        fun genderSource(genderSource: Int) = apply {
            this.genderSource = genderSource
        }

        fun saveOriginal(saveOriginal: Boolean) = apply {
            this.saveOriginal = saveOriginal
        }

        fun codeFormerWeight(codeFormerWeight: Float) = apply {
            this.codeFormerWeight = codeFormerWeight
        }

        fun sourceHashCheck(sourceHashCheck: Boolean) = apply {
            this.sourceHashCheck = sourceHashCheck
        }

        fun targetHashCheck(targetHashCheck: Boolean) = apply {
            this.targetHashCheck = targetHashCheck
        }

        fun device(device: String) = apply {
            this.device = device
        }

        fun maskFace(maskFace: Boolean) = apply {
            this.maskFace = maskFace
        }

        fun selectSource(selectSource: Int) = apply {
            this.selectSource = selectSource
        }

        fun faceModel(faceModel: String) = apply {
            this.faceModel = faceModel
        }

        fun build() = ReActor(
            args = listOf(
                JsonPrimitive(image),
                JsonPrimitive(enable),
                JsonPrimitive(sourceFacesIndex),
                JsonPrimitive(facesIndex),
                JsonPrimitive(model),
                JsonPrimitive(faceRestorerName),
                JsonPrimitive(faceRestorerVisibility),
                JsonPrimitive(restoreFirst),
                JsonPrimitive(upscalerName),
                JsonPrimitive(upscalerScale),
                JsonPrimitive(upscalerVisibility),
                JsonPrimitive(swapInSource),
                JsonPrimitive(swapInGenerated),
                JsonPrimitive(consoleLoggingLevel),
                JsonPrimitive(genderSource),
                JsonPrimitive(genderTarget),
                JsonPrimitive(saveOriginal),
                JsonPrimitive(codeFormerWeight),
                JsonPrimitive(sourceHashCheck),
                JsonPrimitive(targetHashCheck),
                JsonPrimitive(device),
                JsonPrimitive(maskFace),
                JsonPrimitive(selectSource),
                JsonPrimitive(faceModel),
            )
        )
    }

    companion object {

        fun reActor(init: Builder.() -> Unit): ReActor {
            val builder = Builder()
            builder.init()
            return builder.build()
        }

        fun <T : Process.Builder> T.reActor(reActor: ReActor) = apply {
            addAlwaysonScript("reactor", ScriptPayload.Array(reActor.args))
        }
    }
}
