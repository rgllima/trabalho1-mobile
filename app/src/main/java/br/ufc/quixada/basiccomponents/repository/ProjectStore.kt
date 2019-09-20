package br.ufc.quixada.basiccomponents.repository

import br.ufc.quixada.basiccomponents.models.StickyNote
import br.ufc.quixada.basiccomponents.models.Task

object ProjectStore {
    private val taskList: ArrayList<Task> = ArrayList()
    private val stickyNotesList: ArrayList<StickyNote> = ArrayList()

    fun addTask(task: Task) {
        this.taskList.add(task)
    }

    fun getTaskList(): ArrayList<Task> {
        return this.taskList
    }

    fun addStickyNote(stickyNote: StickyNote) {
        this.stickyNotesList.add(stickyNote)
    }

    fun getStickyNoteList(): ArrayList<StickyNote> {
        return this.stickyNotesList
    }
}