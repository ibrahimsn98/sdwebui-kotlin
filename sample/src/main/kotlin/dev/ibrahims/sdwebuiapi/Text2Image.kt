package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.process.Process.Companion.runText2Image


suspend fun runText2Image(api: WebUiApi) {
    val response = api.runText2Image {
        prompt("spiderman")
        samplerName("Euler a")
        steps(20)
    }
    if (response.isFailure) {
        return println(response.exceptionOrNull())
    }
    response.getOrNull()?.images.orEmpty().forEach { imageBase64 ->
        saveImage(imageBase64)
    }
}
