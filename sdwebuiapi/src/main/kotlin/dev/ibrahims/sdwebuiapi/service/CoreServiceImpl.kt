package dev.ibrahims.sdwebuiapi.service

import dev.ibrahims.sdwebuiapi.response.QueueResponse
import io.ktor.client.*

class CoreServiceImpl(
    override val baseUrl: String,
    override val client: HttpClient,
) : Service(), CoreService {

    override suspend fun getQueue(): Result<QueueResponse> {
        return getRequest("queue/status")
    }
}
