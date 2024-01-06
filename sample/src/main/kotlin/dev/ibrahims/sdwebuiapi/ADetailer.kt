package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.extension.ADetailer.Companion.aDetailer
import dev.ibrahims.sdwebuiapi.process.Process.Companion.runText2Image

suspend fun runADetailer(api: WebUiApi) {
    val aDetailer = aDetailer {
        model("face_yolov8n.pt")
    }

    val response = api.runText2Image {
        prompt("spiderman")
        samplerName("Euler a")
        steps(20)
        aDetailer(aDetailer)
    }
    if (response.isFailure) {
        return println(response.exceptionOrNull())
    }
    response.getOrNull()?.images.orEmpty().forEach { imageBase64 ->
        saveImage(imageBase64)
    }
}
