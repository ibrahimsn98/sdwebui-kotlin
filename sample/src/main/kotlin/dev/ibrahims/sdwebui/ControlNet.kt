package dev.ibrahims.sdwebui

import dev.ibrahims.sdwebui.extension.ControlNet.Companion.controlNet
import dev.ibrahims.sdwebui.extension.ControlNet.Companion.controlNetUnit
import dev.ibrahims.sdwebui.process.Process.Companion.runText2Image

suspend fun runControlNet(api: SdWebUi) {
    val unit = controlNetUnit {
        inputImage(loadImage("input-2.png"))
        module("canny")
        model("control_canny-fp16 [e3fe7712]")
    }

    val controlNet = controlNet {
        addUnit(unit)
    }

    val result = api.runText2Image {
        prompt("cute dog, high quality")
        negativePrompt("worst quality")
        samplerName("DPM++ 2M Karras")
        steps(25)
        controlNet(controlNet)
    }
    if (result.isFailure) {
        return println(result.exceptionOrNull())
    }
    result.getOrNull()?.images.orEmpty().forEach { imageBase64 ->
        saveImage(imageBase64)
    }
}
