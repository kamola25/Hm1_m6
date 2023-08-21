package com.kiro.hm1_m6.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kiro.hm1_m6.data.model.NoteModel
import com.kiro.hm1_m6.data.repo.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class MainViewModel (
): ViewModel() {

    private val repo = NoteRepository()
    var liveData: LiveData<List<NoteModel>> = MutableLiveData()

    fun getAllNotes() {
        liveData = repo.getAllNotes()
    }

    fun setUser(model: NoteModel) {
        repo.setNote(model)
    }

    fun deleteNote(model: NoteModel) {
        repo.deleteNote(model)
    }

    fun updateNote(model: NoteModel) {
        repo.updateModel(model)
    }
}