package dev.ibrahims.sdwebuiapi.process

import dev.ibrahims.sdwebuiapi.WebUiApi
import dev.ibrahims.sdwebuiapi.payload.script.ScriptPayload
import dev.ibrahims.sdwebuiapi.response.ProcessResponse

interface Process {

    interface Builder {

        fun addAlwaysonScript(key: String, payload: ScriptPayload)
    }

    companion object {

        suspend fun WebUiApi.runText2Image(init: Text2Image.Builder.() -> Unit): Result<ProcessResponse> {
            val builder = Text2Image.Builder(stableDiffusion)
            builder.init()
            return builder.build().run()
        }

        suspend fun WebUiApi.runImage2image(init: Image2Image.Builder.() -> Unit): Result<ProcessResponse> {
            val builder = Image2Image.Builder(stableDiffusion)
            builder.init()
            return builder.build().run()
        }

        fun WebUiApi.text2Image() = Text2Image.Builder(stableDiffusion)

        fun WebUiApi.image2Image() = Image2Image.Builder(stableDiffusion)
    }
}
