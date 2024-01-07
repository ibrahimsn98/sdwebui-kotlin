package dev.ibrahims.sdwebui.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProgressResponse(
    @SerialName("progress") val progress: Float,
    @SerialName("eta_relative") val etaRelative: Float,
    @SerialName("state") val state: State,
    @SerialName("current_image") val currentImage: String?,
    @SerialName("textinfo") val textInfo: String?,
) {

    @Serializable
    data class State(
        @SerialName("skipped") val skipped: Boolean,
        @SerialName("interrupted") val interrupted: Boolean,
        @SerialName("job") val job: String,
        @SerialName("job_count") val jobCount: Int,
        @SerialName("job_timestamp") val jobTimestamp: String,
        @SerialName("job_no") val jobNo: Int,
        @SerialName("sampling_step") val samplingStep: Int,
        @SerialName("sampling_steps") val samplingSteps: Int,
    )
}