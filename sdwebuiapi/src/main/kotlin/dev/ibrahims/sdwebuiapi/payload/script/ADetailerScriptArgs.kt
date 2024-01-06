package dev.ibrahims.sdwebuiapi.payload.script

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ADetailerScriptArgs(
    @SerialName("ad_model") val model: String,
    @SerialName("ad_prompt") val prompt: String,
    @SerialName("ad_negative_prompt") val negativePrompt: String,
    @SerialName("ad_confidence") val confidence: Float,
    @SerialName("ad_mask_k_largest") val maskKLargest: Float,
    @SerialName("ad_mask_min_ratio") val maskMinRatio: Float,
    @SerialName("ad_mask_max_ratio") val maskMaxRatio: Float,
    @SerialName("ad_dilate_erode") val dilateErode: Int,
    @SerialName("ad_x_offset") val xOffset: Int,
    @SerialName("ad_y_offset") val yOffset: Int,
    @SerialName("ad_mask_merge_invert") val maskMergeInvert: String,
    @SerialName("ad_mask_blur") val maskBlur: Int,
    @SerialName("ad_denoising_strength") val denoisingStrength: Float,
    @SerialName("ad_inpaint_only_masked") val inpaintOnlyMasked: Boolean,
    @SerialName("ad_inpaint_only_masked_padding") val inpaintOnlyMaskedPadding: Int,
    @SerialName("ad_use_inpaint_width_height") val useInpaintWidthHeight: Boolean,
    @SerialName("ad_inpaint_width") val inpaintWidth: Int,
    @SerialName("ad_inpaint_height") val inpaintHeight: Int,
    @SerialName("ad_use_steps") val useSteps: Boolean,
    @SerialName("ad_steps") val steps: Int,
    @SerialName("ad_use_cfg_scale") val useCfgScale: Boolean,
    @SerialName("ad_cfg_scale") val cfgScale: Float,
    @SerialName("ad_use_noise_multiplier") val useNoiseMultiplier: Boolean,
    @SerialName("ad_noise_multiplier") val noiseMultiplier: Float,
    @SerialName("ad_use_clip_skip") val useClipSkip: Boolean,
    @SerialName("ad_clip_skip") val clipSkip: Int,
    @SerialName("ad_restore_face") val restoreFace: Boolean,
    @SerialName("ad_controlnet_model") val controlNetModel: String,
    @SerialName("ad_controlnet_module") val controlNetModule: String,
    @SerialName("ad_controlnet_weight") val controlNetWeight: Float,
    @SerialName("ad_controlnet_guidance_start") val controlNetGuidanceStart: Float,
    @SerialName("ad_controlnet_guidance_end") val controlNetGuidanceEnd: Float,
) : ScriptArgs