package dev.ibrahims.sdwebuiapi.service

import dev.ibrahims.sdwebuiapi.response.QueueResponse

interface CoreService {

    suspend fun getQueue(): Result<QueueResponse>
}
