package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.process.Process.Companion.image2Image

suspend fun runImage2Image(api: WebUiApi) {
    val response = api.image2Image()
        .initImages(listOf(loadImage("input-1.jpg")))
        .prompt("masterpiece")
        .samplerName("Euler a")
        .steps(20)
        .build()
        .run()

    if (response.isFailure) {
        return println(response.exceptionOrNull())
    }
    response.getOrNull()?.images.orEmpty().forEach { imageBase64 ->
        saveImage(imageBase64)
    }
}
