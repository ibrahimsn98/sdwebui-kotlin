package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.extension.ControlNet
import dev.ibrahims.sdwebuiapi.extension.ControlNet.Companion.controlNet
import dev.ibrahims.sdwebuiapi.process.Process.Companion.text2Image

suspend fun runControlNet(api: WebUiApi) {
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
    response.getOrNull()?.images.orEmpty().forEachIndexed { i, imageBase64 ->
        println("Saving image [$i]...")
        saveImage(imageBase64, i.toString())
    }
}
