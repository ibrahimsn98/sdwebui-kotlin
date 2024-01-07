package dev.ibrahims.sdwebuiapi.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VaeResponse(
    @SerialName("model_name") val modelName: String,
    @SerialName("filename") val filename: String,
)
