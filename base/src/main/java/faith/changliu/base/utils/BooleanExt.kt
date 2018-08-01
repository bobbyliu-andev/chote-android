package faith.changliu.base.utils

fun Boolean.yes(action: () -> Unit): Boolean {
	if (this) action()
	return this
}

fun Boolean.no(action: () -> Unit) {
	if (!this) action()
}