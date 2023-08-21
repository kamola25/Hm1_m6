package com.kiro.hm1_m6.ui.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.kiro.hm1_m6.Clickable
import com.kiro.hm1_m6.data.model.NoteModel
import com.kiro.hm1_m6.databinding.ActivitySecondBinding
import com.kiro.hm1_m6.ui.adapter.AdapterNote
import com.kiro.hm1_m6.ui.utills.App
import dagger.hilt.android.AndroidEntryPoint

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClick()

    }

    private fun onClick() {
        binding.btBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
        val model = intent.getSerializableExtra("key") as? NoteModel
        if (model != null) {
            // Используйте модель, полученную из интента
            val id = model.id
            val title = model.title
            val desc = model.description
            binding.etTitle.setText(title)
            binding.etDescription.setText(desc)
            binding.btnSave.setOnClickListener {
                val title1 = binding.etTitle.text.toString()
                val des = binding.etDescription.text.toString()

                viewModel.updateNote(NoteModel(id = id, title = title1, description = des))
                Toast.makeText(this, "setNote", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        } else {
            binding.btnSave.setOnClickListener {
                val title = binding.etTitle.text.toString()
                val des = binding.etDescription.text.toString()

                viewModel.setUser(NoteModel(title = title, description = des))
                Toast.makeText(this, "setNote", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}