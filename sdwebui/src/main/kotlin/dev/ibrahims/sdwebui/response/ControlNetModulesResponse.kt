package dev.ibrahims.sdwebui.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ControlNetModulesResponse(
    @SerialName("module_list") val modules: List<String>,
    @SerialName("module_detail") val details: Map<String, ModuleDetail>,
) {

    @Serializable
    data class ModuleDetail(
        @SerialName("model_free") val modelFree: Boolean,
        @SerialName("sliders") val sliders: List<Slider?>,
    )

    @Serializable
    data class Slider(
        @SerialName("name") val name: String?,
        @SerialName("value") val value: Float?,
        @SerialName("min") val min: Float?,
        @SerialName("max") val max: Float?,
    )
}
