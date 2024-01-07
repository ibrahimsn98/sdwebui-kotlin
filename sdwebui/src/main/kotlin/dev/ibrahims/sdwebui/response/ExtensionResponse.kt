package dev.ibrahims.sdwebui.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExtensionResponse(
    @SerialName("name") val name: String,
    @SerialName("remote") val remote: String?,
    @SerialName("branch") val branch: String?,
    @SerialName("commit_hash") val commitHash: String?,
    @SerialName("version") val version: String?,
    @SerialName("commit_date") val commitDate: String?,
    @SerialName("enabled") val enabled: Boolean,
)
