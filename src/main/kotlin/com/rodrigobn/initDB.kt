package com.rodrigobn

import com.rodrigobn.models.Articles
import com.rodrigobn.models.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun initDB(){
    Database.connect("jdbc:h2:mem:regular;DB_CLOSE_DELAY=-1;", "org.h2.Driver")

    /**
     * representa uma transação ao banco, executado a
     * migration usando a função SchemaUtils.create() passando a tabela
     * Users e Articles como argumento
     */
    transaction {
        SchemaUtils.create(Users)
        SchemaUtils.create(Articles)
    }
}