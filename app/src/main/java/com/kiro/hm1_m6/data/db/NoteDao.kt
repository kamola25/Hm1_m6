package com.kiro.hm1_m6.data.db

import androidx.room.*
import com.kiro.hm1_m6.data.model.NoteModel

@Dao
interface NoteDao {
    @Query("SELECT * FROM noteModel")
    fun getAllNote(): List<NoteModel>

    @Insert
    fun addNote(model: NoteModel)

    @Delete
    fun deleteNote(model: NoteModel)

    @Update
    fun updateNote(model: NoteModel)
}
