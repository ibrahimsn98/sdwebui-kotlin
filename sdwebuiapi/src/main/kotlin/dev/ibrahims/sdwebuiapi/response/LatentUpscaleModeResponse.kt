package dev.ibrahims.sdwebuiapi.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LatentUpscaleModeResponse(
    @SerialName("name") val name: String,
)
