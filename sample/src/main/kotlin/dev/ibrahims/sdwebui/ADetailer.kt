package dev.ibrahims.sdwebui

import dev.ibrahims.sdwebui.extension.ADetailer.Companion.aDetailer
import dev.ibrahims.sdwebui.process.Process.Companion.runText2Image

suspend fun runADetailer(api: SdWebUi) {
    val aDetailer = aDetailer {
        model("face_yolov8n.pt")
        prompt("woman, portrait, high quality, glasses")
    }

    val result = api.runText2Image {
        prompt("woman, portrait, high quality")
        negativePrompt("worst quality")
        samplerName("DPM++ 2M Karras")
        steps(25)
        aDetailer(aDetailer)
    }
    if (result.isFailure) {
        return println(result.exceptionOrNull())
    }
    result.getOrNull()?.images.orEmpty().forEach { imageBase64 ->
        saveImage(imageBase64)
    }
}
