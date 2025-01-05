package dev.ibrahims.sdwebui.payload

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class RemBGPayload(
    @SerialName("input_image") val inputImage: String,
    @SerialName("model") val model: String,
    @SerialName("return_mask") val returnMask: Boolean,
    @SerialName("alpha_matting") val alphaMatting: Boolean,
    @SerialName("alpha_matting_foreground_threshold") val alphaMattingForegroundThreshold: Int,
    @SerialName("alpha_matting_background_threshold") val alphaMattingBackgroundThreshold: Int,
    @SerialName("alpha_matting_erode_size") val alphaMattingErodeSize: Int,
)