package com.limonalmacenes.interfaces.broadcast

interface BroadcastView {
    fun mostrarConexionExitosa(ssid: String?)
    fun mostrarConexionNoDisponible()
    fun mostrarConexionDBExitosa()
    fun mostrarConexionDBRechazada()
}
