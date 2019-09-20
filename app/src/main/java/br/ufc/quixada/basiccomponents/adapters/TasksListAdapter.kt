package br.ufc.quixada.basiccomponents.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import br.ufc.quixada.basiccomponents.R
import br.ufc.quixada.basiccomponents.models.Task

internal class TasksListAdapter (context: Context, private val resource: Int, private val taskList: ArrayList<Task>?) :
        ArrayAdapter<TasksListAdapter.ViewHolder>(context, resource) {

    override fun getCount(): Int {
        return if (this.taskList != null) {
            this.taskList.size
        } else 0
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var convertView = convertView

        val holder: ViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null)
            holder = ViewHolder()
            holder.tvTaskTitle = convertView!!.findViewById(R.id.tvTaskTitle)
            holder.tvTaskDetails = convertView.findViewById(R.id.tvTaskDetails)
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }

        holder.tvTaskTitle!!.text = this.taskList!![position].title
        holder.tvTaskDetails!!.text = this.taskList[position].details

        return convertView
    }

    internal class ViewHolder {
        var tvTaskTitle: TextView? = null
        var tvTaskDetails: TextView? = null
    }
}