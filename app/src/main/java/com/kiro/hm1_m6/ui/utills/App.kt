package com.kiro.hm1_m6.ui.utills

import android.app.Application
import android.content.SharedPreferences
import com.kiro.hm1_m6.data.db.NoteDatabase

class App : Application() {
    private lateinit var preferences: SharedPreferences

    companion object {
        lateinit var prefs: Prefs
        lateinit var db: NoteDatabase
    }

    override fun onCreate() {
        super.onCreate()
        preferences = this.applicationContext
            .getSharedPreferences("settings", MODE_PRIVATE)
        prefs = Prefs(preferences)
        db = NoteDatabase(this)
    }
}