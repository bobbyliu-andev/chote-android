package faith.changliu.base.database.viewModels.cusLiveData

import android.arch.lifecycle.LiveData
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.os.Build
import faith.changliu.base.AppContext

class ConnectivityLiveData : LiveData<Boolean>() {

	val cm = AppContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

	private val networkCallback = object : ConnectivityManager.NetworkCallback() {

		override fun onLost(network: Network?) {
			super.onLost(network)
			postValue(false)
		}

		override fun onAvailable(network: Network?) {
			super.onAvailable(network)
			postValue(true)
		}

	}

	override fun onActive() {
		super.onActive()
		println("Registered network callback")
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			cm.registerDefaultNetworkCallback(networkCallback)
		} else {
			val networkRequest = NetworkRequest.Builder().build()
			cm.registerNetworkCallback(networkRequest, networkCallback)
		}
	}

	override fun onInactive() {
		super.onInactive()
		println("unregistered network callback")
		cm.unregisterNetworkCallback(networkCallback)
	}
}