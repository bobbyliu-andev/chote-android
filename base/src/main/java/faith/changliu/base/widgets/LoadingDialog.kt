package faith.changliu.base.widgets

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import faith.changliu.base.R

class LoadingDialog(ctx: Context) : Dialog(ctx, R.style.ProgressBar) {

	private var isLoading = false

	fun startLoading() {
		if (!isLoading) {
			isLoading = true
			show()
		}
	}

	fun stopLoading() {
		if (isLoading) {
			isLoading = false
			dismiss()
		}
	}

	override fun onBackPressed() {
		stopLoading()
		super.onBackPressed()
	}

	companion object {

		fun create(ctx: Context): LoadingDialog {

			val mDialog = LoadingDialog(ctx)
					.apply {
						setContentView(R.layout.progress_dialog)
						setCancelable(true) // enable cancel
						setCanceledOnTouchOutside(false)
						// display in center
						window.attributes.gravity = Gravity.CENTER

						// dim bg
						val lp = window.attributes
						lp.dimAmount = 0f
						window.attributes = lp
					}


			return mDialog!!
		}
	}
}