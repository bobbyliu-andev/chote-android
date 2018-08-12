package faith.changliu.base.database.firebase

import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessagingService
import faith.changliu.base.utils.log
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.suspendCancellableCoroutine

class MyFirebaseMessagingService : FirebaseMessagingService() {
	override fun onNewToken(p0: String?) {
		super.onNewToken(p0)
		log(p0 ?: "null")

	}
}

private suspend fun getFCMToken(): Deferred<String> {
	return async(CommonPool) {
		suspendCancellableCoroutine<String> { cont ->
			FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
				cont.resume(it.token)
			}.addOnFailureListener {
				cont.resumeWithException(it)
			}.addOnCanceledListener {
				cont.cancel()
			}
		}
	}
}