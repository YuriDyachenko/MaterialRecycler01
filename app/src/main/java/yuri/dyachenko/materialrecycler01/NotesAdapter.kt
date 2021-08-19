package yuri.dyachenko.materialrecycler01

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    private var notes: MutableList<Note> = mutableListOf()
    private var isSecondItemSelected = false

    fun setNotes(list: List<Note>) {
        notes.clear()
        notes.addAll(list)
        notifyDataSetChanged()
    }

    fun editNote() {
        Log.d(
            TAG,
            "editNote: change viewType for $SECOND_ITEM_POSITION, notify for = $CHANGED_ITEM_POSITION"
        )
        isSecondItemSelected = isSecondItemSelected.not()
        notifyItemChanged(CHANGED_ITEM_POSITION)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder, position = $position")
        holder.bind(notes[position])
    }

    override fun getItemCount() = notes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(
                if (viewType == SELECTED_TYPE) R.layout.notes_item_selected
                else R.layout.notes_item, parent, false
            ) as View
    )

    override fun getItemViewType(position: Int): Int {
        Log.d(TAG, "getItemViewType, position = $position")
        return if (position == SECOND_ITEM_POSITION && isSecondItemSelected) SELECTED_TYPE
        else USUAL_TYPE
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(note: Note) {
            itemView.apply {
                findViewById<TextView>(R.id.notes_item_title).text = note.title
                findViewById<TextView>(R.id.notes_item_created).text = note.created.toString()
            }
        }
    }

    companion object {
        private const val USUAL_TYPE = 0
        private const val SELECTED_TYPE = 1
        private const val SECOND_ITEM_POSITION = 1
        private const val CHANGED_ITEM_POSITION = 3
        private const val TAG = "Recycler"
    }
}