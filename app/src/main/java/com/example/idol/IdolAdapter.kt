package com.example.idol

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.idol.data.Idol
import kotlinx.android.synthetic.main.item_idol.view.*

class IdolAdapter (var idols:List<Idol>, var clickListener: (Idol) -> Unit): RecyclerView.Adapter<IdolAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_idol, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = idols.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(idols[position], clickListener)

    fun updateList(newIdols:List<Idol>){
        this.idols=newIdols
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(idol: Idol, clickListener: (Idol) -> Unit) = with(itemView) {
            this.tv_nombre.text= idol.nombre
            this.setOnClickListener { clickListener(idol)}
        }

    }
}