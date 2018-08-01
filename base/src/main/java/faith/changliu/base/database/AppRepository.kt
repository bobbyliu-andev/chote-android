package faith.changliu.base.database

import android.arch.persistence.room.Room
import faith.changliu.base.AppContext
import faith.changliu.base.database.room.RoomDB

object AppRepository {

	private val roomDB = Room.databaseBuilder(AppContext, RoomDB::class.java, RoomDB.name)
}
