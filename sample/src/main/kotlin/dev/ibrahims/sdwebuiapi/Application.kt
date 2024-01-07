package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.extension.ControlNet
import dev.ibrahims.sdwebuiapi.extension.ControlNet.Companion.controlNet
import dev.ibrahims.sdwebuiapi.process.Process.Companion.text2Image
import kotlinx.coroutines.runBlocking
import java.io.File
import java.util.*

fun main() {
    val sdWebUiApi = WebUiApi.Builder()
        .host("192.168.1.62")
        .port(7860)
        //.port(5000)
        .build()

    runBlocking {
        val s4 = sdWebUiApi.reActor.getUpscalers()
        println(s4.exceptionOrNull())
        println(s4.getOrNull())
    }
}

suspend fun test(api: WebUiApi) {
    val inputImage = loadImage("input-1.jpg")

    val unit = ControlNet.Unit.Builder()
        .inputImage(inputImage)
        .module("canny")
        .model("control_canny-fp16 [e3fe7712]")
        .build()

    val controlNet = ControlNet.Builder()
        .addUnit(unit)
        .build()

    val response = api.text2Image()
        .prompt("spiderman")
        .samplerName("Euler a")
        .steps(20)
        .controlNet(controlNet)
        .build()
        .run()

    if (response.isFailure) {
        return println(response.exceptionOrNull())
    }
    response.getOrNull()?.images.orEmpty().forEach { imageBase64 ->
        saveImage(imageBase64)
    }
}

suspend fun setModel(api: WebUiApi) {
    val result = api.stableDiffusion.setModel("dreamshaper_8.safetensors [879db523c3]")
    if (result.isFailure) {
        return println(result.exceptionOrNull())
    }
    println(result.getOrNull())
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
