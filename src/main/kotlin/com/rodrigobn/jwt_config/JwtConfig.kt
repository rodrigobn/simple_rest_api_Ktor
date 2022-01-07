package com.rodrigobn.jwt_config

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.rodrigobn.models.User
import java.util.*

object JwtConfig {
    private const val secret = "my-secret"
    private const val issuer = "com.rodrigobn"
    private const val validityInMs = 36_000_00 * 24 //1 dia
    private val algorithm = Algorithm.HMAC512(secret)

    val verifier: JWTVerifier = JWT
        .require(algorithm)
        .withIssuer(issuer)
        .build()

    /**
     * Gera um token para com a combinação de alguns dados
     */
    fun generateToken(user: User): String = JWT.create()
        .withSubject("Authentication")
        .withIssuer(issuer)
        .withClaim("id", user.id)
        .withClaim("name", user.name)
        .withExpiresAt(getExpiration())
        .sign(algorithm)


    /**
     * Calcule a data de validade com base na hora atual + a validade fornecida
     */
    private fun getExpiration() = Date(System.currentTimeMillis() + validityInMs)
}