package faith.changliu.base.database.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import faith.changliu.base.database.Note
import faith.changliu.base.database.room.converters.DateConverter

@Database(entities = [Note::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class RoomDB : RoomDatabase() {

	companion object {
		const val name = "chote_room.db"
	}

	abstract val noteDao: NoteDao
}