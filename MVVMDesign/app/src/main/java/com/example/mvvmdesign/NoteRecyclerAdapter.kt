
package com.example.mvvmdesign

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdesign.model.Blog
import com.example.mvvmdesign.model.viewModel.MainViewModel

class NoteRecyclerAdapter(val viewModel: MainViewModel, val arrayList: ArrayList<Blog>, val context: Context):
    RecyclerView.Adapter<NoteRecyclerAdapter.NotesViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int,
        ) : NoteRecyclerAdapter.NotesViewHolder{
            var root = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
            return NotesViewHolder(root);
        }

    override fun  onBindViewHolder(holder: NoteRecyclerAdapter.NotesViewHolder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        if(arrayList.size == 0) {
            Toast.makeText(context, "List is empty", Toast.LENGTH_LONG).show()
        } else {

        }

        return arrayList.size
    }

    inner class NotesViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding)  {

      
        

        fun bind(blog: Blog) {
            var textView: TextView
            val deleteBtn: Button

            textView = binding.findViewById(R.id.text)
            deleteBtn = binding.findViewById(R.id.delete)
            
            textView.text = blog.title
            deleteBtn.setOnClickListener{
                viewModel.remove(blog);
                notifyItemRemoved(arrayList.indexOf(blog))
            }
           
        }
    }
}




