package faith.changliu.base.utils

import faith.changliu.base.widgets.LoadingDialog
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.suspendCoroutine

fun tryBlock(loadingDialog: LoadingDialog? = null, block: suspend () -> Unit) {
	launch(UI) {
		try {
			loadingDialog?.startLoading()
			block()
		} catch (ex: NullPointerException) {
			ex.printStackTrace()
		} catch (ex: Exception) {
			ex.printStackTrace()
		} finally {
			loadingDialog?.stopLoading()
		}
	}
}

// callback wrapper
suspend fun <T> load() = suspendCoroutine<T> { cont ->
	// resumeWithException
	// resume
}