package com.limonalmacenes.interactor.database

import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object FirebirdDB {
    private val url = "jdbc:firebirdsql://host:port/base_de_datos"
    private var conexion: Connection? = null
    private val mapa = mapOf(
    	"user" to "MI_USUARIO",
    	"password" to "MI_CONTRASEÑA",
    	"encoding" to "ISO8859_1" // Define la codificación del alfabeto latino.
    )
    private val props = mapa.toProperties()

    @Synchronized
    fun connection(): Connection? = conexion

    @Synchronized
    fun conectar() {
        try {
        	// Registrar el driver de Firebird.
            Class.forName("org.firebirdsql.jdbc.FBDriver").kotlin
            try {
            	// Obtener una instancia de la conexión a través de DriverManager.
                conexion = DriverManager.getConnection(url, props)
            } catch (error_sql: SQLException) {
                Log.e("DBFIREBIRD:", "ERROR AL CONECTAR CON LA BASE DE DATOS")
                Log.e("DBFIREBIRD:", error_sql.localizedMessage)
            }
        } catch (error_clase: ClassNotFoundException) {
            Log.e("DBFIREBIRD:", "ERROR AL REGISTRAR EL DRIVER: $error_clase")
        }
    }
}
