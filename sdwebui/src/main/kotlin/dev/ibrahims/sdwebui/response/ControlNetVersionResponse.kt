package dev.ibrahims.sdwebui.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ControlNetVersionResponse(
    @SerialName("version") val version: Int,
)
