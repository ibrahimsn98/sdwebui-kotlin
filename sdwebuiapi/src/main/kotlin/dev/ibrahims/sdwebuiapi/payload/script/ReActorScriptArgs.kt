package dev.ibrahims.sdwebuiapi.payload.script

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReActorScriptArgs(
    @SerialName("img") val image: String?,
    @SerialName("enable") val enable: Boolean,
    @SerialName("source_faces_index") val sourceFacesIndex: String,
    @SerialName("faces_index") val facesIndex: String,
    @SerialName("model") val model: String,
    @SerialName("face_restorer_name") val faceRestorerName: String,
    @SerialName("face_restorer_visibility") val faceRestorerVisibility: Float,
    @SerialName("restore_first") val restoreFirst: Boolean,
    @SerialName("upscaler_name") val upscalerName: String,
    @SerialName("upscaler_scale") val upscalerScale: Int,
    @SerialName("upscaler_visibility") val upscalerVisibility: Float,
    @SerialName("swap_in_source") val swapInSource: Boolean,
    @SerialName("swap_in_generated") val swapInGenerated: Boolean,
    @SerialName("console_logging_level") val consoleLoggingLevel: Int,
    @SerialName("gender_source") val genderSource: Int,
    @SerialName("gender_target") val genderTarget: Int,
    @SerialName("save_original") val saveOriginal: Boolean,
    @SerialName("codeFormer_weight") val codeFormerWeight: Float,
    @SerialName("source_hash_check") val sourceHashCheck: Boolean,
    @SerialName("target_hash_check") val targetHashCheck: Boolean,
    @SerialName("device") val device: String,
    @SerialName("mask_face") val maskFace: Boolean,
    @SerialName("select_source") val selectSource: Int,
    @SerialName("face_model") val faceModel: String?,
) : ScriptArgs
