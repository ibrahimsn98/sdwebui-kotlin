package dev.ibrahims.sdwebui.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReActorModelsResponse(
    @SerialName("models") val models: List<String>,
)
