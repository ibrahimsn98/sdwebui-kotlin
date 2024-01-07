package dev.ibrahims.sdwebui.service

import dev.ibrahims.sdwebui.response.QueueResponse

interface CoreService {

    suspend fun getQueue(): Result<QueueResponse>
}
