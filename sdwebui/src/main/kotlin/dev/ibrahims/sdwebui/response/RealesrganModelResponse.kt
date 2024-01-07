package dev.ibrahims.sdwebui.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RealesrganModelResponse(
    @SerialName("name") val name: String,
    @SerialName("path") val path: String,
    @SerialName("scale") val scale: Int,
)
