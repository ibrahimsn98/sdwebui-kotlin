package dev.ibrahims.sdwebuiapi.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReActorUpscalersResponse(
    @SerialName("upscalers") val upscalers: List<String>,
)
