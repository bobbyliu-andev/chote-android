package faith.changliu.base.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "notes")
data class Note(
		@PrimaryKey
		val id: String,
		var title: String,
		var createdAt: Date,
		var content: String
) {
	@Ignore
	constructor() : this("", "", Date(), "")
}