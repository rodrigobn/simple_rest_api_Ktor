package com.rodrigobn.models

import io.ktor.auth.*
import kotlinx.serialization.Serializable

@Serializable
data class Credentials(val login: String, val password: String): Principal