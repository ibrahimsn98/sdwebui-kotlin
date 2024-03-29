package dev.ibrahims.sdwebui.payload

import dev.ibrahims.sdwebui.payload.script.ScriptPayload
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Text2ImagePayload(
    @SerialName("prompt") val prompt: String,
    @SerialName("negative_prompt") val negativePrompt: String,
    @SerialName("styles") val styles: List<String>,
    @SerialName("seed") val seed: Int,
    @SerialName("subseed") val subseed: Int,
    @SerialName("subseed_strength") val subseedStrength: Int,
    @SerialName("seed_resize_from_h") val seedResizeFromH: Int,
    @SerialName("seed_resize_from_w") val seedResizeFromW: Int,
    @SerialName("sampler_name") val samplerName: String,
    @SerialName("batch_size") val batchSize: Int,
    @SerialName("n_iter") val nIter: Int,
    @SerialName("steps") val steps: Int,
    @SerialName("cfg_scale") val cfgScale: Float,
    @SerialName("width") val width: Int,
    @SerialName("height") val height: Int,
    @SerialName("restore_faces") val restoreFaces: Boolean,
    @SerialName("tiling") val tiling: Boolean,
    @SerialName("do_not_save_samples") val doNotSaveSamples: Boolean,
    @SerialName("do_not_save_grid") val doNotSaveGrid: Boolean,
    @SerialName("eta") val eta: Float,
    @SerialName("denoising_strength") val denoisingStrength: Float,
    @SerialName("s_churn") val sChurn: Int,
    @SerialName("s_tmax") val sTmax: Int,
    @SerialName("s_tmin") val sTmin: Int,
    @SerialName("s_noise") val sNoise: Int,
    @SerialName("override_settings") val overrideSettings: Map<String, String>,
    @SerialName("override_settings_restore_afterwards") val overrideSettingsRestoreAfterwards: Boolean,
    @SerialName("comments") val comments: Map<String, String>,
    @SerialName("enable_hr") val enableHr: Boolean,
    @SerialName("firstphase_width") val firstphaseWidth: Int,
    @SerialName("firstphase_height") val firstphaseHeight: Int,
    @SerialName("hr_scale") val hrScale: Int,
    @SerialName("hr_upscaler") val hrUpscaler: String,
    @SerialName("hr_second_pass_steps") val hrSecondPassSteps: Int,
    @SerialName("hr_resize_x") val hrResizeX: Int,
    @SerialName("hr_resize_y") val hrResizeY: Int,
    @SerialName("sampler_index") val samplerIndex: String,
    @SerialName("script_name") val scriptName: String?,
    @SerialName("script_args") val scriptArgs: List<String>,
    @SerialName("send_images") val sendImages: Boolean,
    @SerialName("save_images") val saveImages: Boolean,
    @SerialName("alwayson_scripts") val alwaysonScripts: Map<String, ScriptPayload>
)
