package dev.ibrahims.sdwebui

import kotlinx.coroutines.runBlocking
import java.io.File
import java.util.*

fun main() {
    val sdWebUiApi = SdWebUi.Builder()
        .host("127.0.0.1")
        .port(7860)
        .build()

    runBlocking {
        sdWebUiApi.setModel("dreamshaper_8.safetensors [879db523c3]")
        runText2Image(sdWebUiApi)
        //runImage2Image(sdWebUiApi)
        //runControlNet(sdWebUiApi)
        //runADetailer(sdWebUiApi)
        //runReActor(sdWebUiApi)
        //runExtraSingleImage(sdWebUiApi)
        //runExtraBatchImages(sdWebUiApi)
        //runRemBG(sdWebUiApi)
    }
}

suspend fun SdWebUi.setModel(model: String) {
    val result = stableDiffusion.setModel(model)
    if (result.isFailure) {
        return println("An error occurred while setting model: ${result.exceptionOrNull()}")
    }
    println("Model is set to $model.")
}

fun loadImage(name: String): String {
    val bytes = File("input/$name").readBytes()
    return Base64.getEncoder().encodeToString(bytes)
}

fun saveImage(base64: String) {
    val bytes = Base64.getDecoder().decode(base64)
    val time = System.currentTimeMillis()
    println("Saving image [output-$time.jpg]...")
    val file = File("output/output-$time.jpg")
    file.writeBytes(bytes)
}
