package dev.ibrahims.sdwebui.extension

import dev.ibrahims.sdwebui.payload.script.ControlNetScriptArgs
import dev.ibrahims.sdwebui.payload.script.ScriptPayload
import dev.ibrahims.sdwebui.process.Process

class ControlNet private constructor(
    internal val units: List<Unit>,
) : Extension {

    class Unit private constructor(
        internal val args: ControlNetScriptArgs,
    ) {

        class Builder {

            private var inputImage: String? = null
            private var module: String = "none"
            private var model: String = "None"
            private var weight: Float = 1.0f
            private var resizeMode: String = "Resize and Fill"
            private var lowVRam: Boolean = false
            private var mask: String? = null
            private var processorRes: Int = 512
            private var thresholdA: Float = 64f
            private var thresholdB: Float = 64f
            private var guidance: Float = 1f
            private var guidanceStart: Float = 0.0f
            private var guidanceEnd: Float = 1.0f
            private var controlMode: Int = 0
            private var pixelPerfect: Boolean = false

            fun inputImage(inputImage: String?) = apply {
                this.inputImage = inputImage
            }

            fun module(module: String) = apply {
                this.module = module
            }

            fun model(model: String) = apply {
                this.model = model
            }

            fun weight(weight: Float) = apply {
                this.weight = weight
            }

            fun resizeMode(resizeMode: String) = apply {
                this.resizeMode = resizeMode
            }

            fun lowVRam(lowVRam: Boolean) = apply {
                this.lowVRam = lowVRam
            }

            fun mask(mask: String?) = apply {
                this.mask = mask
            }

            fun processorRes(processorRes: Int) = apply {
                this.processorRes = processorRes
            }

            fun thresholdA(thresholdA: Float) = apply {
                this.thresholdA = thresholdA
            }

            fun thresholdB(thresholdB: Float) = apply {
                this.thresholdB = thresholdB
            }

            fun guidance(guidance: Float) = apply {
                this.guidance = guidance
            }

            fun guidanceStart(guidanceStart: Float) = apply {
                this.guidanceStart = guidanceStart
            }

            fun guidanceEnd(guidanceEnd: Float) = apply {
                this.guidanceEnd = guidanceEnd
            }

            fun controlMode(controlMode: Int) = apply {
                this.controlMode = controlMode
            }

            fun pixelPerfect(pixelPerfect: Boolean) = apply {
                this.pixelPerfect = pixelPerfect
            }

            fun build() = Unit(
                args = ControlNetScriptArgs(
                    inputImage = inputImage,
                    module = module,
                    model = model,
                    weight = weight,
                    resizeMode = resizeMode,
                    lowVRam = lowVRam,
                    mask = mask,
                    processorRes = processorRes,
                    thresholdA = thresholdA,
                    thresholdB = thresholdB,
                    guidance = guidance,
                    guidanceStart = guidanceStart,
                    guidanceEnd = guidanceEnd,
                    controlMode = controlMode,
                    pixelPerfect = pixelPerfect,
                )
            )
        }
    }

    class Builder {

        private val units = mutableListOf<Unit>()

        fun addUnit(vararg unit: Unit) = apply { units.addAll(unit) }

        fun build(): ControlNet = ControlNet(units)
    }

    companion object {

        fun controlNetUnit(init: Unit.Builder.() -> kotlin.Unit): Unit {
            val builder = Unit.Builder()
            builder.init()
            return builder.build()
        }

        fun controlNet(init: Builder.() -> kotlin.Unit): ControlNet {
            val builder = Builder()
            builder.init()
            return builder.build()
        }

        fun <T : Process.Builder> T.controlNet(controlNet: ControlNet) = apply {
            addAlwaysonScript("ControlNet", ScriptPayload.Multiple(controlNet.units.map { unit -> unit.args }))
        }
    }
}
