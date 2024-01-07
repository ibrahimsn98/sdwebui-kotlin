package dev.ibrahims.sdwebui.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FaceRestorerResponse(
    @SerialName("name") val name: String,
    @SerialName("cmd_dir") val cmdDir: String?,
)
