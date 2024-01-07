package dev.ibrahims.sdwebui

import dev.ibrahims.sdwebui.process.Process.Companion.runImage2Image

suspend fun runImage2Image(api: SdWebUi) {
    val result = api.runImage2Image {
        initImages(listOf(loadImage("input-1.png")))
        prompt("cute dog, high quality, dog clothes")
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
