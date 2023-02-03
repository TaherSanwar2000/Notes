package com.example.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) :AndroidViewModel(application) {
    val getNotes:LiveData<List<Note>>
    private val repository: NoteRepository
    init{
        val dao = NoteRoomDatabase.getDatabase(application).getNoteDao()
        repository = NoteRepository(dao)
        getNotes = repository.allNotes
    }
     fun NoteDelete(note: Note) = viewModelScope.launch (Dispatchers.IO){
        repository.delete(note)
    }
    fun NoteInsert(note: Note) = viewModelScope.launch (Dispatchers.IO){
        repository.insert(note)
    }

}