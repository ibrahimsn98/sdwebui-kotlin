package dev.ibrahims.sdwebui.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ControlNetModelsResponse(
    @SerialName("model_list") val models: List<String>,
)
