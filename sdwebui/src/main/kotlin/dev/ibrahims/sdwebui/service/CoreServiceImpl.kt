package dev.ibrahims.sdwebui.service

import dev.ibrahims.sdwebui.response.QueueResponse
import io.ktor.client.*

class CoreServiceImpl(
    override val baseUrl: String,
    override val client: HttpClient,
) : Service(), CoreService {

    override suspend fun getQueue(): Result<QueueResponse> {
        return getRequest("queue/status")
    }
}
