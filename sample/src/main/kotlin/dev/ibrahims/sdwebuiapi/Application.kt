package dev.ibrahims.sdwebuiapi

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

fun saveImage(base64: String, id: String) {
    val bytes = Base64.getDecoder().decode(base64)
    val file = File("output/output-$id.jpg")
    file.writeBytes(bytes)
}
