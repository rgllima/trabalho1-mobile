package br.ufc.quixada.basiccomponents.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.ufc.quixada.basiccomponents.R
import br.ufc.quixada.basiccomponents.adapters.TasksListAdapter
import br.ufc.quixada.basiccomponents.repository.ProjectStore
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.tasks_list.*

class TaskListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.tasks_list, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnAddTask = view.findViewById<FloatingActionButton>(R.id.fbTaskList)
        btnAddTask.setOnClickListener {
            TaskDialogFragment().show(this.requireFragmentManager(), "Add")
        }

        gvTaskList.apply {
            adapter = TasksListAdapter(this.context, R.layout.task_item, ProjectStore.getTaskList())
        }
    }
}
