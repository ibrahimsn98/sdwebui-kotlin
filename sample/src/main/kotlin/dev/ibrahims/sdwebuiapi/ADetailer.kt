package dev.ibrahims.sdwebuiapi

import dev.ibrahims.sdwebuiapi.extension.ADetailer
import dev.ibrahims.sdwebuiapi.extension.ADetailer.Companion.aDetailer
import dev.ibrahims.sdwebuiapi.process.Process.Companion.text2Image

suspend fun runADetailer(api: WebUiApi) {
    val aDetailer = ADetailer.Builder()
        .model("face_yolov8n.pt")
        .build()

    val response = api.text2Image()
        .prompt("spiderman")
        .samplerName("Euler a")
        .steps(20)
        .aDetailer(aDetailer)
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
