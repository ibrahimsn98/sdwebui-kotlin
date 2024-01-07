package dev.ibrahims.sdwebuiapi.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScriptsResponse(
    @SerialName("txt2img") val txt2img: List<String>,
    @SerialName("img2img") val img2img: List<String>,
)
