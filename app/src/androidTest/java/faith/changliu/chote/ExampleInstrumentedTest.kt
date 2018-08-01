package faith.changliu.chote

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import faith.changliu.base.database.Note
import faith.changliu.base.database.room.RoomDB

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.util.*

@RunWith(AndroidJUnit4::class)
class DatabaseTest {
	@Test
	fun testDatabaseInit() {
		val appContext = InstrumentationRegistry.getTargetContext()
		val testInstance = Room.inMemoryDatabaseBuilder(appContext, RoomDB::class.java).build()
		testInstance.noteDao.insertNote(Note("1001", "Test Agent", Date(), "Test Memo"))
		val noteFromDB = testInstance.noteDao.getNoteByID("1001")
		assertEquals("1001", noteFromDB.id)
	}
}
