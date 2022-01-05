package com.rodrigobn.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*

object Users: Table(){
    val id: Column<String> = char("id", 36)
    val name: Column<String> = varchar("name", 50)

    override val primaryKey = PrimaryKey(id, name = "PK_User_Id") // <- É definido a chave primária sendo o ID, determinado que um ID só pode pertencer á um único usuário.

    fun toUser(row: ResultRow): User = User(
        id = row[Users.id],
        name = row[Users.name]
    )
}

@Serializable // <- a classe abaixo poderá ser transformada em JSON e JSON poderá ser transformado nessa classe
data class User(var id: String? = null, val name: String) // <- data class é usado para classes que apenas irão guardar dados
