package dev.ibrahims.sdwebui.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProcessResponse(
    @SerialName("images") val images: List<String>,
    @SerialName("info") val info: String,
)
