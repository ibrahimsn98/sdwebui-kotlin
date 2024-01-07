package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.extension.ADetailer.Companion.aDetailer
import dev.ibrahims.sdwebuiapi.process.Process.Companion.runText2Image

suspend fun runADetailer(api: WebUiApi) {
    val aDetailer = aDetailer {
        model("face_yolov8n.pt")
    }

    val result = api.runText2Image {
        prompt("spiderman")
        samplerName("Euler a")
        steps(20)
        aDetailer(aDetailer)
    }
    if (result.isFailure) {
        return println(result.exceptionOrNull())
    }
    result.getOrNull()?.images.orEmpty().forEach { imageBase64 ->
        saveImage(imageBase64)
    }
}
