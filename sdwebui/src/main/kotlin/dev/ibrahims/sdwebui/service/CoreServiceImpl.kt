package dev.ibrahims.sdwebui.service

import dev.ibrahims.sdwebui.interceptor.Interceptor
import dev.ibrahims.sdwebui.response.QueueResponse
import io.ktor.client.*

class CoreServiceImpl(
    override val baseUrl: String,
    override val client: HttpClient,
    override val interceptors: List<Interceptor>,
) : Service(), CoreService {

    override suspend fun getQueue(): Result<QueueResponse> {
        return getRequest("queue/status")
    }
}
