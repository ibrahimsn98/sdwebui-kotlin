package dev.ibrahims.sdwebui.process

import dev.ibrahims.sdwebui.SdWebUi
import dev.ibrahims.sdwebui.payload.script.ScriptPayload
import dev.ibrahims.sdwebui.response.ExtraProcessResponse
import dev.ibrahims.sdwebui.response.GenerateProcessResponse

interface Process {

    interface Builder {

        fun addAlwaysonScript(key: String, payload: ScriptPayload)
    }

    companion object {

        suspend fun SdWebUi.runText2Image(
            init: Text2Image.Builder.() -> Unit,
        ): Result<GenerateProcessResponse> {
            val builder = Text2Image.Builder(stableDiffusion)
            builder.init()
            return builder.build().run()
        }

        suspend fun SdWebUi.runImage2Image(
            init: Image2Image.Builder.() -> Unit,
        ): Result<GenerateProcessResponse> {
            val builder = Image2Image.Builder(stableDiffusion)
            builder.init()
            return builder.build().run()
        }

        suspend fun SdWebUi.runExtraSingleImage(
            init: ExtraSingleImage.Builder.() -> Unit,
        ): Result<ExtraProcessResponse> {
            val builder = ExtraSingleImage.Builder(stableDiffusion)
            builder.init()
            return builder.build().run()
        }

        fun SdWebUi.text2Image() = Text2Image.Builder(stableDiffusion)

        fun SdWebUi.image2Image() = Image2Image.Builder(stableDiffusion)

        fun SdWebUi.extraSingleImage() = ExtraSingleImage.Builder(stableDiffusion)
    }
}
