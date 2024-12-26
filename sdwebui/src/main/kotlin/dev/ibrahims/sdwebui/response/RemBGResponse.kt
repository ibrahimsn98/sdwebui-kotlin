package dev.ibrahims.sdwebui.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemBGResponse(
    @SerialName("image") val image: String,
)