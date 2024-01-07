package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.process.Process.Companion.runText2Image

suspend fun runText2Image(api: WebUiApi) {
    val result = api.runText2Image {
        prompt("spiderman")
        negativePrompt("bad quality")
        samplerName("Euler a")
        steps(20)
    }
    if (result.isFailure) {
        return println(result.exceptionOrNull())
    }
    result.getOrNull()?.images.orEmpty().forEach { imageBase64 ->
        saveImage(imageBase64)
    }
}

