package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.extension.ReActor
import dev.ibrahims.sdwebuiapi.extension.ReActor.Companion.reActor
import dev.ibrahims.sdwebuiapi.process.Process.Companion.text2Image

suspend fun runReActor(api: WebUiApi) {
    val reActor = ReActor.Builder()
        .image(loadImage("face-1.jpg"))
        .upscalerName("None")
        .build()

    val response = api.text2Image()
        .prompt("beautiful princess, 1girl, mountains, princess clothes, portrait, masterpiece, high quality")
        .samplerName("Euler a")
        .steps(25)
        .reActor(reActor)
        .build()
        .run()

    if (response.isFailure) {
        return println(response.exceptionOrNull())
    }
    response.getOrNull()?.images.orEmpty().forEach { imageBase64 ->
        saveImage(imageBase64)
    }
}
