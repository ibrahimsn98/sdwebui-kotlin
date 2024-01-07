package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.extension.ControlNet.Companion.controlNet
import dev.ibrahims.sdwebuiapi.extension.ControlNet.Companion.controlNetUnit
import dev.ibrahims.sdwebuiapi.payload.Text2ImagePayload
import dev.ibrahims.sdwebuiapi.payload.script.ControlNetScriptArgs
import dev.ibrahims.sdwebuiapi.process.Process.Companion.runText2Image

suspend fun runControlNet(api: WebUiApi) {
    val unit = controlNetUnit {
        inputImage(loadImage("input-1.jpg"))
        module("canny")
        model("control_canny-fp16 [e3fe7712]")
    }

    val controlNet = controlNet {
        addUnit(unit)
    }

    val result = api.runText2Image {
        prompt("spiderman")
        samplerName("Euler a")
        steps(20)
        controlNet(controlNet)
    }
    if (result.isFailure) {
        return println(result.exceptionOrNull())
    }
    result.getOrNull()?.images.orEmpty().forEach { imageBase64 ->
        saveImage(imageBase64)
    }
}
