package dev.ibrahims.sdwebui.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExtraBatchImagesResponse(
    @SerialName("html_info") val htmlInfo: String,
    @SerialName("images") val images: List<String>,
)
