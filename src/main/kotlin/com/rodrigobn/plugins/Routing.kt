package com.rodrigobn.plugins

import com.rodrigobn.routes.registerUserRoutes
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {

    routing {
        get("/") {
                call.respondText("Hello World!")
            }
    }

    registerUserRoutes()
}
