package com.kiro.hm1_m6.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var description : String
): java.io.Serializable
