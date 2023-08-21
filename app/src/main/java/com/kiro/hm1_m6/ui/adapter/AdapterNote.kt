package com.kiro.hm1_m6.ui.adapter

import android.annotation.SuppressLint
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kiro.hm1_m6.data.model.NoteModel
import com.kiro.hm1_m6.databinding.ItemNoteBinding

class AdapterNote(
    private val click: Result
) :RecyclerView.Adapter<AdapterNote.ViewHolderNote>(){
    private var list = ArrayList<NoteModel>()

    inner class ViewHolderNote (val binding: ItemNoteBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(noteModel: NoteModel) {
            binding.tvTitleItem.text = noteModel.title
            binding.tvDescriptionItem.text  = noteModel.description

        }

    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNote {
        val view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderNote(view)
    }

    override fun onBindViewHolder(holder: ViewHolderNote, position: Int) {
        holder.bind(list[position])
        holder.binding.btnDelete.setOnClickListener {
            click.deleteNote(list[position])
        }

        holder.binding.btnEdit.setOnClickListener {
            click.updateNote(list[position])
        }
    }

    override fun getItemCount(): Int {
    return list.size
    }

    interface Result {
        fun deleteNote(model: NoteModel)
        fun updateNote(model: NoteModel)
        fun didNote(model: NoteModel)
    }

}

