package com.example.notes

import androidx.lifecycle.LiveData

class NoteRepository(private val notedao:NoteDao) {

    val allNotes : LiveData<List<Note>> = notedao.getNote()

    suspend fun insert(note: Note){
        notedao.getInsertNote(note)
    }

    suspend fun delete(note:Note){
        notedao.getDeleteNote(note)
    }
}