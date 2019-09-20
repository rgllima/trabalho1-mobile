package br.ufc.quixada.basiccomponents.fragments

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import br.ufc.quixada.basiccomponents.R
import br.ufc.quixada.basiccomponents.models.StickyNote
import br.ufc.quixada.basiccomponents.repository.ProjectStore

class StickyNotesDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater
            val myView = inflater.inflate(R.layout.add_sticky_note_dialog, null)

            val title = myView.findViewById<EditText>(R.id.dsnTitle).text
            val date = myView.findViewById<EditText>(R.id.dsnDate).text


            builder.setView(myView)
                .setPositiveButton("Create",
                    DialogInterface.OnClickListener { dialog, id ->

                        if (title != null && date != null)
                            ProjectStore.addStickyNote(StickyNote(title.toString(), date.toString()))
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