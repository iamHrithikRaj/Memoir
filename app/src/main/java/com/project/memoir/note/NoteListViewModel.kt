package com.project.memoir.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.memoir.common.BaseViewModel
import com.project.memoir.common.GET_NOTES_ERROR
import com.project.memoir.common.Result
import com.project.memoir.model.Note
import com.project.memoir.model.repository.INoteRepository
import com.project.memoir.note.notelist.NoteListEvent
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class NoteListViewModel(
    val noteRepo: INoteRepository,
    uiContext: CoroutineContext
) : BaseViewModel<NoteListEvent>(uiContext) {

    private val noteListState = MutableLiveData<List<Note>>()
    val noteList: LiveData<List<Note>> get() = noteListState

    private val editNoteState = MutableLiveData<String>()
    val editNote: LiveData<String> get() = editNoteState


    override fun handleEvent(event: NoteListEvent) {
        when (event) {
            is NoteListEvent.OnStart -> getNotes()
            is NoteListEvent.OnNoteItemClick -> editNote(event.position)
        }
    }

    private fun editNote(position: Int) {
        editNoteState.value = noteList.value!![position].creationDate
    }

    private fun getNotes() = launch {
        val notesResult = noteRepo.getNotes()

        when (notesResult) {
            is Result.Value -> noteListState.value = notesResult.value
            is Result.Error -> errorState.value = GET_NOTES_ERROR
        }
    }
}