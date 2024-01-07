package dev.ibrahims.sdwebui

import dev.ibrahims.sdwebui.process.ExtraBatchImages
import dev.ibrahims.sdwebui.process.Process.Companion.runExtraBatchImages

suspend fun runExtraBatchImages(api: SdWebUi) {
    val images = listOf(
        ExtraBatchImages.Image(
            data = loadImage("input-1.png"),
            name = "input-1.png",
        ),
        ExtraBatchImages.Image(
            data = loadImage("input-3.png"),
            name = "input-3.png",
        )
    )

    val result = api.runExtraBatchImages {
        images(images)
        upscaler1("R-ESRGAN 4x+")
        upscalingResize(2)
    }
    if (result.isFailure) {
        return println(result.exceptionOrNull())
    }
    result.getOrNull()?.images.orEmpty().forEach { imageBase64 ->
        saveImage(imageBase64)
    }
}
