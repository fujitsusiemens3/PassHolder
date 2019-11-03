package com.rafal.database

import com.rafal.MASTER_PASSWORD
import com.rafal.model.SensitiveDataDto
import com.rafal.model.SensitiveDataDtoList
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import tornadofx.*
import tornadofx.select
import java.sql.Connection

object SensitiveData : Table() {
    val id = long("id").autoIncrement().primaryKey()
    val name = varchar("name", length = 256)
    val value = varchar("value", length = 256)
    val description = varchar("description", length = 500)
}

class DataRepository {

    init {
        runAsync {
            var connectionString = System.getProperty("user.dir")
            connectionString = "jdbc:sqlite:$connectionString/database/passwords.db"

            Database.connect(connectionString, driver = "org.sqlite.JDBC")
            TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE

            transaction {
                SchemaUtils.create(SensitiveData)
            }
        }
    }

    fun fetchAllData() =
            SensitiveDataDtoList(SensitiveData.selectAll().map {
                SensitiveDataDto(it[SensitiveData.id], it[SensitiveData.name], it[SensitiveData.value], it[SensitiveData.description])
            })

    fun fetchMasterPassword(): String? {
        var result: String? = null
        transaction {
            result = SensitiveData.select { SensitiveData.name eq MASTER_PASSWORD }.map { it[SensitiveData.value] }.firstOrNull()
        }
        return result
    }
}