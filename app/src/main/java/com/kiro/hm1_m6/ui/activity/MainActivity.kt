package com.kiro.hm1_m6.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.kiro.hm1_m6.data.model.NoteModel
import com.kiro.hm1_m6.databinding.ActivityMainBinding
import com.kiro.hm1_m6.ui.adapter.AdapterNote

class MainActivity : AppCompatActivity(), AdapterNote.Result {
    private lateinit var binding :ActivityMainBinding
    private lateinit var adapterNote: AdapterNote
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapterNote = AdapterNote(this)
        binding.rvNotes.adapter = adapterNote
        onClick()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.getAllNotes()
        viewModel.liveData.observe(this) {
            adapterNote.setList(it)
            Toast.makeText(this, "getNotes", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onClick(){
        binding.btnAdd.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun deleteNote(model: NoteModel) {
        viewModel.deleteNote(model)
        viewModel.getAllNotes()
        viewModel.liveData.observe(this) {
            adapterNote.setList(it)
            Toast.makeText(this, "getNotes", Toast.LENGTH_SHORT).show()
        }
    }

    override fun updateNote(model: NoteModel) {
        viewModel.updateNote(model)
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("key", model)
        startActivity(intent)
        finish()

    }

    override fun didNote(model: NoteModel) {
    }


}