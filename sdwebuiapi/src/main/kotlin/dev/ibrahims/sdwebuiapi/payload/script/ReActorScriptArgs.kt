package dev.ibrahims.sdwebuiapi.payload.script

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReActorScriptArgs(
    @SerialName("img") val image: String?,
    @SerialName("enable") val enable: String,
    @SerialName("source_faces_index") val sourceFacesIndex: String,
    @SerialName("faces_index") val facesIndex: String,
    @SerialName("model") val model: String,
    @SerialName("face_restorer_name") val faceRestorerName: String,
    @SerialName("face_restorer_visibility") val faceRestorerVisibility: String,
    @SerialName("restore_first") val restoreFirst: String,
    @SerialName("upscaler_name") val upscalerName: String,
    @SerialName("upscaler_scale") val upscalerScale: String,
    @SerialName("upscaler_visibility") val upscalerVisibility: String,
    @SerialName("swap_in_source") val swapInSource: String,
    @SerialName("swap_in_generated") val swapInGenerated: String,
    @SerialName("console_logging_level") val consoleLoggingLevel: String,
    @SerialName("gender_source") val genderSource: String,
    @SerialName("save_original") val saveOriginal: String,
    @SerialName("codeFormer_weight") val codeFormerWeight: String,
    @SerialName("source_hash_check") val sourceHashCheck: String,
    @SerialName("target_hash_check") val targetHashCheck: String,
    @SerialName("device") val device: String,
    @SerialName("mask_face") val maskFace: String,
    @SerialName("select_source") val selectSource: String,
    @SerialName("face_model") val faceModel: String,
) : ScriptArgs
