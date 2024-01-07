package dev.ibrahims.sdwebui

import dev.ibrahims.sdwebui.extension.ReActor.Companion.reActor
import dev.ibrahims.sdwebui.process.Process.Companion.runText2Image

suspend fun runReActor(api: SdWebUi) {
    val reActor = reActor {
        image(loadImage("input-3.png"))
        upscalerName("None")
    }

    val result = api.runText2Image {
        prompt("woman, wizard, portrait, high quality")
        negativePrompt("worst quality")
        samplerName("DPM++ 2M Karras")
        steps(25)
        reActor(reActor)
    }
    if (result.isFailure) {
        return println(result.exceptionOrNull())
    }
    result.getOrNull()?.images.orEmpty().forEach { imageBase64 ->
        saveImage(imageBase64)
    }
}
