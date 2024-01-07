package dev.ibrahims.sdwebui.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QueueResponse(
    @SerialName("msg") val msg: String,
    @SerialName("rank") val rank: String?,
    @SerialName("queue_size") val queueSize: Int,
    @SerialName("avg_event_process_time") val avgEventProcessTime: Float?,
    @SerialName("avg_event_concurrent_process_time") val avgEventConcurrentProcessTime: Float?,
    @SerialName("rank_eta") val rankEta: Float?,
    @SerialName("queue_eta") val queueEta: Float?,
)
