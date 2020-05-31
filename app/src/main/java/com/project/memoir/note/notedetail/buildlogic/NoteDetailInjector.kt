package com.project.memoir.note.notedetail.buildlogic

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.google.firebase.FirebaseApp
import com.project.memoir.model.RoomNoteDatabase
import com.project.memoir.model.implementations.NoteRepoImpl
import com.project.memoir.model.repository.INoteRepository

class NoteDetailInjector(application: Application): AndroidViewModel(application) {

    private fun getNoteRepository(): INoteRepository {
        FirebaseApp.initializeApp(getApplication())
        return NoteRepoImpl(
            local = RoomNoteDatabase.getInstance(getApplication()).roomNoteDao()
        )
    }

    fun provideNoteViewModelFactory(): NoteViewModelFactory =
        NoteViewModelFactory(
            getNoteRepository()
        )

}