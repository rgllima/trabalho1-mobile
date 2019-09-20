package br.ufc.quixada.basiccomponents.fragments

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import br.ufc.quixada.basiccomponents.R
import br.ufc.quixada.basiccomponents.models.Task
import br.ufc.quixada.basiccomponents.repository.ProjectStore

class TaskDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater
            val myView = inflater.inflate(R.layout.add_task_dialog, null)

            val title = myView.findViewById<EditText>(R.id.dialogTitle).text
            val details = myView.findViewById<EditText>(R.id.dialogDetails).text


            builder.setView(myView)
                .setPositiveButton("Create",
                    DialogInterface.OnClickListener { dialog, id ->

                        if (title != null && details != null)
                            ProjectStore.addTask(Task(title.toString(), details.toString()))
                        else
                            Toast.makeText(this.requireContext(), "Informe todos os campos", Toast.LENGTH_SHORT).show()

                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}