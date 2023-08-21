package com.kiro.hm1_m6.data.repo

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kiro.hm1_m6.data.db.NoteDao
import com.kiro.hm1_m6.data.db.NoteDatabase
import com.kiro.hm1_m6.data.model.NoteModel
import com.kiro.hm1_m6.ui.utills.App
import javax.inject.Inject


class NoteRepository (){

    private val dao = App.db.getDao()

    fun getAllNotes(): LiveData<List<NoteModel>> {
        val liveData = MutableLiveData<List<NoteModel>>()
        liveData.value = dao.getAllNote()
        return liveData
    }

    fun setNote(model: NoteModel) {
        dao.addNote(model)
    }

    fun deleteNote(model: NoteModel) {
        dao.deleteNote(model)
    }

    fun updateModel(model: NoteModel) {
        dao.updateNote(model)
    }
}