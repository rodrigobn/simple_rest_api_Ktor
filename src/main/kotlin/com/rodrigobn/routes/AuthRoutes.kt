package com.rodrigobn.routes

import com.rodrigobn.jwt_config.JwtConfig
import com.rodrigobn.models.Credentials
import com.rodrigobn.models.User
import com.rodrigobn.models.Users
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.authRouting(){
    route("/auth"){
        post {
            val credentials = call.receive<Credentials>()
            val users: List<User> = transaction {
                Users.select { (Users.password eq credentials.password) and (Users.name eq credentials.login) }.map { Users.toUser(it) }
            }

            if (users.isNotEmpty()){
                val user = users.first()
                val token = JwtConfig.generateToken(user)
                return@post call.respond(token)
            }
            return@post call.respondText("User not found", status = HttpStatusCode.NotFound)
        }
    }
}

fun Application.registerAuthRoutes(){
    routing {
        authRouting()
    }
}