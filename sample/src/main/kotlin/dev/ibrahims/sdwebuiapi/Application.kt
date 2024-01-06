package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.extension.ControlNet
import dev.ibrahims.sdwebuiapi.process.Process.Companion.image2Image
import dev.ibrahims.sdwebuiapi.process.Process.Companion.text2Image
import kotlinx.coroutines.runBlocking
import java.io.File
import java.util.*

fun main() {

    val api = WebUiApi.Builder()
        .host("192.168.1.62")
        .port(7860)
        //.port(5000)
        .build()

    runBlocking {
        runImage2Image(api)
    }
}

suspend fun runSetModel(api: WebUiApi) {
    val f = api.stableDiffusion.setModel("dreamshaper_8.safetensors [879db523c3]")
    println(f.isSuccess)
    println(f.exceptionOrNull())
}

suspend fun runText2Image(api: WebUiApi) {
    val response = api.text2Image()
        .prompt("spiderman")
        .samplerName("Euler a")
        .steps(20)
        //.controlNet(controlNet)
        .build()
        .run()

    response.getOrNull()?.images.orEmpty().forEachIndexed { i, base64 ->
        saveImage(base64, i.toString())
    }
}

suspend fun runImage2Image(api: WebUiApi) {
    val input = File("input/input-1.jpg").readBytes()
    val base64 = Base64.getEncoder().encodeToString(input)

    val response = api.image2Image()
        .initImages(listOf(base64))
        .prompt("masterpiece")
        .samplerName("Euler a")
        .steps(20)
        .build()
        .run()

    response.getOrNull()?.images.orEmpty().forEachIndexed { i, base64 ->
        saveImage(base64, i.toString())
    }
}

private suspend fun runImage2ImageControlNet(api: WebUiApi) {
    val unit = ControlNet.Unit.Builder()
        .module("canny")
        .model("control_sd15_canny [fef5e48e]")
        .build()

    val controlNet = ControlNet.Builder()
        .addUnit(unit)
        .build()
}

private fun saveImage(base64: String, id: String) {
    val pictureBytes = Base64.getDecoder().decode(base64)
    val path = File("output/output-$id.jpg")
    path.writeBytes(pictureBytes)
}
