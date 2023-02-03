package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun getInsertNote(note: Note)

    @Delete
    suspend fun getDeleteNote(note: Note)

    @Query("SELECT * FROM note_table ORDER BY  id ASC")
     fun getNote():LiveData<List<Note>>
}