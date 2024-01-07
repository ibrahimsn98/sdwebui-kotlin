package dev.ibrahims.sdwebui.payload.script

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ControlNetScriptArgs(
    @SerialName("input_image") val inputImage: String?,
    @SerialName("module") val module: String,
    @SerialName("model") val model: String,
    @SerialName("weight") val weight: Float,
    @SerialName("resize_mode") val resizeMode: String,
    @SerialName("lowvram") val lowVRam: Boolean,
    @SerialName("mask") val mask: String?,
    @SerialName("processor_res") val processorRes: Int,
    @SerialName("threshold_a") val thresholdA: Float,
    @SerialName("threshold_b") val thresholdB: Float,
    @SerialName("guidance") val guidance: Float,
    @SerialName("guidance_start") val guidanceStart: Float ,
    @SerialName("guidance_end") val guidanceEnd: Float ,
    @SerialName("control_mode") val controlMode: Int,
    @SerialName("pixel_perfect") val pixelPerfect: Boolean,
) : ScriptArgs
