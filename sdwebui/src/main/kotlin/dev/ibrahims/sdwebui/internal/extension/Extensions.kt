package dev.ibrahims.sdwebui.internal.extension

import io.ktor.http.*

internal fun buildUrl(host: String, port: Int, useHttps: Boolean): String {
    val builder = URLBuilder(
        protocol = if (useHttps) URLProtocol.HTTPS else URLProtocol.HTTP,
        host = host,
        port = port,
    )
    return builder.build().toString()
}
