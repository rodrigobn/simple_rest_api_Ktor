package com.rodrigobn.plugins

import com.rodrigobn.routes.registerArticleRoutes
import com.rodrigobn.routes.registerAuthRoutes
import com.rodrigobn.routes.registerUserRoutes
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {
    registerUserRoutes()
    registerArticleRoutes()
    registerAuthRoutes()
}
