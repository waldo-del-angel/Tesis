package com.limonalmacenes.view

import com.limonalmacenes.interactor.broadcast.BroadcastInteractor
import com.limonalmacenes.interfaces.broadcast.BroadcastView
import com.limonalmacenes.presenter.BroadcastPresenterImpl

open class BroadcastViewImpl : AppCompatActivity(), BroadcastView {

    private val msjConexionExitosa = "CONECTADO"
    private val msjConexionNoDisponible = "SIN CONEXIÓN"

	// Inicializar BroadcastPresenterImpl el cual recibe
	// como parámetros las capas a manejar.
    private val broadcastPresenter = BroadcastPresenterImpl(this, BroadcastInteractor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Realizar la conexión del presentador con el modelo.
        broadcastPresenter.conexionInteractor()

        // Hacer el registro del Broadcast a usar.
        registerReceiver(
        	BroadcastInteractor,
        	IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        broadcastPresenter.onDestroy()
        unregisterReceiver(BroadcastInteractor)
    }

    override fun mostrarConexionExitosa(ssid: String?) {
        // Mostrar mensaje de conexión exitosa:
        // Toast, SnackBar, etc.
    }

    override fun mostrarConexionNoDisponible() {
        // Mostrar mensaje de conexión no disponible:
        // Toast, SnackBar, etc.
    }

    override fun mostrarConexionDBExitosa() {
        // Mostrar mensaje de conexión a la base de datos:
        // Toast, SnackBar, etc.
    }

    override fun mostrarConexionDBRechazada() {
        // Mostrar mensaje de conexión a la base de datos rechazada:
        // Toast, SnackBar, etc.
    }
}
