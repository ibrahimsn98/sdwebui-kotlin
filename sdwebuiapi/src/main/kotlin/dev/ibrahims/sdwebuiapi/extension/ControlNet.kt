package dev.ibrahims.sdwebuiapi.extension

import dev.ibrahims.sdwebuiapi.process.Text2Image
import dev.ibrahims.sdwebuiapi.payload.ControlNetUnitPayload
import dev.ibrahims.sdwebuiapi.payload.ScriptPayload

class ControlNet private constructor(
    internal val units: List<Unit>,
) : Extension {

    class Unit private constructor(
        internal val payload: ControlNetUnitPayload,
    ) {

        class Builder {

            private var inputImage: String? = null

            private var module: String = ""

            private var model: String = ""

            fun inputImage(inputImage: String) = apply { this.inputImage = inputImage }

            fun module(module: String) = apply { this.module = module }

            fun model(model: String) = apply { this.model = model }

            fun build(): Unit = Unit(
                payload = ControlNetUnitPayload(
                    inputImage = inputImage,
                    module = module,
                    model = model,
                ),
            )
        }
    }

    class Builder {

        private val units = mutableListOf<Unit>()

        fun addUnit(vararg unit: Unit) = apply { units.addAll(unit) }

        fun build(): ControlNet = ControlNet(units)
    }

    companion object {

        fun Text2Image.Builder.controlNet(controlNet: ControlNet) = apply {
            addAlwaysonScripts(
                mapOf("ControlNet" to ScriptPayload(args = controlNet.units.map { unit -> unit.payload }))
            )
        }
    }
}
