package faith.changliu.chote

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import faith.changliu.base.database.AppRepository
import faith.changliu.base.database.Note
import faith.changliu.base.database.viewModels.MainViewModel
import faith.changliu.base.utils.toast
import faith.changliu.base.widgets.LoadingDialog

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

	private val mLoadingDialog: LoadingDialog by lazy { LoadingDialog.create(this) }
	private val notes = arrayListOf<Note>()
	private val mainViewModel by lazy { MainViewModel(application) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(toolbar)

		mainViewModel.notes.observe(this, object : Observer<List<Note>> {
			override fun onChanged(t: List<Note>?) {
				toast("${t?.size}")
			}
		})

		fab.setOnClickListener { view ->
			val id = System.currentTimeMillis().toString()
			AppRepository.insertNote(Note(id, id, Date(), ""))
		}
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		menuInflater.inflate(R.menu.menu_main, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return when (item.itemId) {
			R.id.action_settings -> true
			else -> super.onOptionsItemSelected(item)
		}
	}
}
