package com.project.memoir.note.notedetail.buildlogic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.memoir.model.repository.INoteRepository
import com.project.memoir.note.NoteViewModel
import kotlinx.coroutines.Dispatchers

class NoteViewModelFactory(
    private val noteRepo: INoteRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return NoteViewModel(noteRepo, Dispatchers.Main) as T
    }

}