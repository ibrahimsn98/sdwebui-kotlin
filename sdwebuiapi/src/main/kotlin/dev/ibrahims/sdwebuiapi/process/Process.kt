package dev.ibrahims.sdwebuiapi.process

import dev.ibrahims.sdwebuiapi.WebUiApi
import dev.ibrahims.sdwebuiapi.payload.script.ScriptPayload

interface Process {

    interface Builder {

        fun addAlwaysonScript(key: String, payload: ScriptPayload)
    }

    companion object {

        fun WebUiApi.text2Image() = Text2Image.Builder(stableDiffusion)

        fun WebUiApi.image2Image() = Image2Image.Builder(stableDiffusion)
    }
}
