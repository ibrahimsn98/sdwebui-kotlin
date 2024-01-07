package dev.ibrahims.sdwebui

import dev.ibrahims.sdwebui.process.Process.Companion.runExtraSingleImage

suspend fun runExtraSingleImage(api: SdWebUi) {
    val result = api.runExtraSingleImage {
        image(loadImage("input-3.png"))
        upscaler1("R-ESRGAN 4x+")
        upscalingResize(2)
    }
    if (result.isFailure) {
        return println(result.exceptionOrNull())
    }
    saveImage(requireNotNull(result.getOrNull()).image)
}
