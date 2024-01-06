package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.extension.ReActor.Companion.reActor
import dev.ibrahims.sdwebuiapi.process.Process.Companion.runText2Image

suspend fun runReActor(api: WebUiApi) {
    val reActor = reActor {
        image(loadImage("face-1.jpg"))
        upscalerName("None")
    }

    val response = api.runText2Image {
        prompt("beautiful princess, 1girl, princess clothes, portrait, masterpiece, high quality")
        samplerName("DPM++ 2M Karras")
        steps(25)
        reActor(reActor)
    }
    if (response.isFailure) {
        return println(response.exceptionOrNull())
    }
    response.getOrNull()?.images.orEmpty().forEach { imageBase64 ->
        saveImage(imageBase64)
    }
}
