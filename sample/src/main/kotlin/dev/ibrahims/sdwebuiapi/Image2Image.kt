package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.process.Process.Companion.image2Image

suspend fun runImage2Image(api: WebUiApi) {
    val inputImage = loadImage("input-1.jpg")

    val response = api.image2Image()
        .initImages(listOf(inputImage))
        .prompt("masterpiece")
        .samplerName("Euler a")
        .steps(20)
        .build()
        .run()

    if (response.isFailure) {
        return println(response.exceptionOrNull())
    }
    response.getOrNull()?.images.orEmpty().forEachIndexed { i, imageBase64 ->
        println("Saving image [$i]...")
        saveImage(imageBase64, i.toString())
    }
}
