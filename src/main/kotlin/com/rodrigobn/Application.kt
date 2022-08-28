package com.rodrigobn

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.rodrigobn.plugins.*

fun main() {
    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        initDB()
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
