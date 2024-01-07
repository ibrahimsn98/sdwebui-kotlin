package dev.ibrahims.sdwebui

import dev.ibrahims.sdwebui.process.Process.Companion.runText2Image

suspend fun runText2Image(api: SdWebUi) {
    val result = api.runText2Image {
        prompt("cute dog, high quality")
        negativePrompt("worst quality")
        samplerName("DPM++ 2M Karras")
        steps(25)
    }
    if (result.isFailure) {
        return println(result.exceptionOrNull())
    }
    result.getOrNull()?.images.orEmpty().forEach { imageBase64 ->
        saveImage(imageBase64)
    }
}
