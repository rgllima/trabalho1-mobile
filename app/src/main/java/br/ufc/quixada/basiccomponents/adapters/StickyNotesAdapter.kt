package br.ufc.quixada.basiccomponents.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.ufc.quixada.basiccomponents.R
import br.ufc.quixada.basiccomponents.models.StickyNote


class StickyNotesAdapter (private val stickyNoteList: ArrayList<StickyNote>) :
    RecyclerView.Adapter<StickyNotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder (parent: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = stickyNoteList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stickyNote: StickyNote = stickyNoteList[position]
        print(stickyNote.title)
        holder.bind(stickyNote)
    }

    class ViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.sticky_notes_item, parent, false)) {

        private var tvTitle: TextView? = null
        private var tvDate: TextView? = null

        init {
            tvTitle = itemView.findViewById(R.id.tvStickyNoteTitle)
            tvDate  = itemView.findViewById(R.id.tvStickyNoteDate)
        }

        fun bind(stickyNote: StickyNote){
            tvTitle?.text = stickyNote.title
            tvDate?.text = stickyNote.date
        }
    }
}