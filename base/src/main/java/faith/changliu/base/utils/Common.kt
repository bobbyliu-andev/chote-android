package faith.changliu.base.utils

import android.app.Activity
import android.util.Log
import android.widget.Toast
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.common.GooglePlayServicesUtil
import faith.changliu.base.AppContext

fun toast(msg: String) {
	Toast.makeText(AppContext, msg, Toast.LENGTH_LONG).show()
}

fun log(msg: String, tag: String = "bobbyerrorlog") {
	Log.wtf(tag, msg)
}

/**
 * Regular check to make sure google play service is up-to-date
 *
 * @param act
 */
fun checkGooglePlayServiceAvailability(act: Activity, onSuccessBlock: () -> Unit) {
	val resultCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(AppContext)
	when (resultCode) {
		ConnectionResult.SUCCESS -> { onSuccessBlock() }
		else -> {
			GoogleApiAvailability.getInstance().getErrorDialog(act, resultCode, GOOGLE_PLAY_UPDATE_RQST_CODE)
		}
	}
}
// const
val GOOGLE_PLAY_UPDATE_RQST_CODE = 0x1001
