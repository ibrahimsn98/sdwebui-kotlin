package dev.ibrahims.sdwebuiapi.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ControlNetControlTypesResponse(
    @SerialName("control_types") val controlTypes: Map<String, ControlType>,
) {

    @Serializable
    data class ControlType(
        @SerialName("module_list") val modules: List<String>,
        @SerialName("model_list") val models: List<String>,
        @SerialName("default_option") val defaultOption: String,
        @SerialName("default_model") val defaultModel: String
    )
}
