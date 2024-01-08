package dev.ibrahims.sdwebui.interceptor

interface Interceptor {

    suspend fun interceptUrl(baseUrl: String, path: String): String

    suspend fun interceptBody(body: Any?): Any?
}
