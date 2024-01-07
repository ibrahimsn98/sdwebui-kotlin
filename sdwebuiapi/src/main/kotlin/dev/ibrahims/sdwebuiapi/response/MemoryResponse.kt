package dev.ibrahims.sdwebuiapi.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MemoryResponse(
   @SerialName("ram") val ram: Ram,
   @SerialName("cuda") val cuda: Cuda,
) {

    @Serializable
    data class Ram(
        @SerialName("free") val free: Double?,
        @SerialName("used") val used: Double?,
        @SerialName("total") val total: Double?,
        @SerialName("error") val error: String?,
    )

    @Serializable
    data class Cuda(
        @SerialName("free") val free: Double?,
        @SerialName("used") val used: Double?,
        @SerialName("total") val total: Double?,
        @SerialName("error") val error: String?,
    )
}