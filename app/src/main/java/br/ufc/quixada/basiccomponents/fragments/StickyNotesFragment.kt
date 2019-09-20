package br.ufc.quixada.basiccomponents.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.ufc.quixada.basiccomponents.R
import br.ufc.quixada.basiccomponents.adapters.StickyNotesAdapter
import br.ufc.quixada.basiccomponents.repository.ProjectStore
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.sticky_notes_list.*

class StickyNotesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.sticky_notes_list, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnAddTask = view.findViewById<FloatingActionButton>(R.id.fabStickyNotesList)
        btnAddTask.setOnClickListener {
            StickyNotesDialogFragment().show (this.requireFragmentManager(), "Add")
        }

        rvStickyNotesList.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = StickyNotesAdapter(ProjectStore.getStickyNoteList())
        }
    }
}
