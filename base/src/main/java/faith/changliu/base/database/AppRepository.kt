package faith.changliu.base.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Room
import faith.changliu.base.AppContext
import faith.changliu.base.database.room.RoomDB
import faith.changliu.base.utils.*
import java.util.concurrent.Executors

object AppRepository {

	private val roomDB = Room.databaseBuilder(AppContext, RoomDB::class.java, RoomDB.name).build()

	private val executor = Executors.newSingleThreadExecutor()



	fun insertNote(note: Note) {
		isConnected().yes {
			executor.execute {
				roomDB.noteDao.insertNote(note)
			}
		}.no {
			toast("Error: No Internet")
		}
	}

	fun getAllNotes(): LiveData<List<Note>> {
		return roomDB.noteDao.getAll()
	}

}
