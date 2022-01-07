package com.rodrigobn

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.rodrigobn.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {

        initDB()
        configureRouting()
        configureSerialization()

    }.start(wait = true)
}