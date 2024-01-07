package dev.ibrahims.sdwebuiapi.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    @SerialName("error") val error: String,
    @SerialName("detail") val detail: String,
    @SerialName("body") val body: String,
    @SerialName("errors") val errors: String,
)
