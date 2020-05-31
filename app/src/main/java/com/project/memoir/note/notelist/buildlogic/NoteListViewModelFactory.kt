package com.project.memoir.note.notelist.buildlogic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.memoir.model.repository.INoteRepository
import com.project.memoir.note.NoteListViewModel
import kotlinx.coroutines.Dispatchers

class NoteListViewModelFactory(
    private val noteRepo: INoteRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return NoteListViewModel(noteRepo, Dispatchers.Main) as T
    }

}