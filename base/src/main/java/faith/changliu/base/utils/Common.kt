package faith.changliu.base.utils

import android.widget.Toast
import faith.changliu.base.AppContext

fun toast(msg: String) {
	Toast.makeText(AppContext, msg, Toast.LENGTH_LONG).show()
}