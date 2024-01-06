package dev.ibrahims.sdwebuiapi.payload

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ControlNetUnitPayload(
    @SerialName("input_image") val inputImage: String?,
    @SerialName("module") val module: String,
    @SerialName("model") val model: String,
    @SerialName("weight") val weight: Float = 1f,
    @SerialName("resize_mode") val resizeMode: String = "Resize and Fill",
    @SerialName("lowvram") val lowVRam: Boolean = false,
    @SerialName("mask") val mask: String? = null,
    @SerialName("processor_res") val processorRes: Int = 512,
    @SerialName("threshold_a") val thresholdA: Float = 64f,
    @SerialName("threshold_b") val thresholdB: Float = 64f,
    @SerialName("guidance") val guidance: Float = 1f,
    @SerialName("guidance_start") val guidanceStart: Float = 0f,
    @SerialName("guidance_end") val guidanceEnd: Float = 1f,
    @SerialName("control_mode") val controlMode: Int = 0,
    @SerialName("pixel_perfect") val pixelPerfect: Boolean = false,
) : ScriptArgs
