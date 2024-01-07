package dev.ibrahims.sdwebui.payload

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ExtraBatchImagesPayload(
    @SerialName("resize_mode") val resizeMode: Int,
    @SerialName("show_extras_results") val showExtrasResults: Boolean,
    @SerialName("gfpgan_visibility") val gfpganVisibility: Int,
    @SerialName("codeformer_visibility") val codeformerVisibility: Int,
    @SerialName("codeformer_weight") val codeformerWeight: Int,
    @SerialName("upscaling_resize") val upscalingResize: Int,
    @SerialName("upscaling_resize_w") val upscalingResizeW: Int,
    @SerialName("upscaling_resize_h") val upscalingResizeH: Int,
    @SerialName("upscaling_crop") val upscalingCrop: Boolean,
    @SerialName("upscaler_1") val upscaler1: String,
    @SerialName("upscaler_2") val upscaler2: String,
    @SerialName("extras_upscaler_2_visibility") val extrasUpscaler2Visibility: Int,
    @SerialName("upscale_first") val upscaleFirst: Boolean,
    @SerialName("imageList") val images: List<Image>,
) {

    @Serializable
    data class Image(
        @SerialName("data") val data: String,
        @SerialName("name") val name: String,
    )
}
