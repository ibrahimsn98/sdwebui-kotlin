package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.process.Process.Companion.text2Image

suspend fun runText2Image(api: WebUiApi) {
    val response = api.text2Image()
        .prompt("spiderman")
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
