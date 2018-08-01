package faith.changliu.base.database.viewModels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import faith.changliu.base.database.AppRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
	var notes = AppRepository.getAllNotes()
}

