package dev.ibrahims.sdwebui

import dev.ibrahims.sdwebui.process.Process.Companion.runRemBG

suspend fun runRemBG(api: SdWebUi) {
    val result = api.runRemBG {
        inputImage(loadImage("input-3.png"))
    }
    if(result.isFailure) {
        return println(result.exceptionOrNull())
    }
    val imageBase64 = result.getOrNull()?.image.orEmpty()
    saveImage(imageBase64)
}