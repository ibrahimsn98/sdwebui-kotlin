package dev.ibrahims.sdwebui.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExtraSingleImageResponse(
    @SerialName("html_info") val htmlInfo: String,
    @SerialName("image") val image: String,
)
