package com.example.notes

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notes.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity(),INote {

    lateinit var binding: ActivityMain2Binding
    lateinit var viewModel: NoteViewModel

    val notesList = arrayListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcView.layoutManager = LinearLayoutManager(this)
        val adaptor = NoteAdaptor(notesList, this)
        binding.rcView.adapter = adaptor

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.getNotes.observe(this, Observer { list ->

            notesList.addAll(list)
//            list?.let {
//                adaptor.updateList(it)
//            }
        })

        binding.button.setOnClickListener{
            addData()
        }
    }

    override fun onItemClicked(note: Note) {
        viewModel.NoteDelete(note)
        Toast.makeText(this,"${note.text}Deleted", Toast.LENGTH_LONG).show()
    }

    fun addData() {
        val noteText = binding.etText.text.toString()
        if (noteText.isNotEmpty())
        {
            viewModel.NoteInsert(Note(noteText))
            Toast.makeText(this,"${noteText}Is Added", Toast.LENGTH_LONG).show()
        }
    }


}




