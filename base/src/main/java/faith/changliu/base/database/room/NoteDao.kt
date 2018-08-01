package faith.changliu.base.database.room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import faith.changliu.base.database.Note

@Dao
interface NoteDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertNote(note: Note)

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertAll(notes: List<Note>)

	@Query("SELECT * FROM notes")
	fun getAll(): LiveData<List<Note>>

	@Query("SELECT * FROM notes WHERE id=:id")
	fun getNoteByID(id: String): Note

	@Delete
	fun deleteNote(note: Note)

	@Query("DELETE FROM notes")
	fun deleteAll()
}