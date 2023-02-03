package com.example.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


//class NoteAdaptor(private val context: Context, private val listener: INote):RecyclerView.Adapter<NoteAdaptor.NoteViewHolder>() {
//
//    val getAll = ArrayList<Note>()
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
//
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_note, parent, false)
//
//        return NoteViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
//        val currentNote = getAll[position]
//        holder.delete.setOnClickListener{
////            listener.onItemClicked(getAll[viewHolder.adapterPosition])
//        }
//        holder.text.text = currentNote.text
//    }
//
//    override fun getItemCount(): Int {
//        return getAll.size
//    }
//    inner class NoteViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
//        val text = itemView.findViewById<TextView>(R.id.tv_text)
//        val delete = itemView.findViewById<ImageView>(R.id.ic_delete)
//    }
//
//    fun updateList(newList: List<Note>){
//        getAll.clear()
//        getAll.addAll(newList)
//        notifyDataSetChanged()
//    }
//}

class NoteAdaptor(private val getAll: ArrayList<Note>, private val listener: INote) : RecyclerView.Adapter<NoteAdaptor.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentNote = getAll[position]
        holder.delete.setOnClickListener{
            listener.onItemClicked(getAll[position])
        }
        holder.text.text = currentNote.text

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return getAll.size
    }

    fun updateList(newList: List<Note>){
        getAll.clear()
        getAll.addAll(newList)
        notifyDataSetChanged()
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val text = itemView.findViewById<TextView>(R.id.tv_text)
        val delete = itemView.findViewById<ImageView>(R.id.ic_delete)
    }
}

interface INote{
    fun onItemClicked(note: Note)
}