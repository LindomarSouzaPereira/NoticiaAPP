package com.example.noticiaapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.noticiaapp.PostActivity
import com.example.noticiaapp.R
import com.example.noticiaapp.Shared
import com.example.noticiaapp.model.Noticia

class AdapterNoticias(context: Context): RecyclerView.Adapter<AdapterNoticias.ViewHolder>() {
    private val mContext: Context = context
    private val mListNoticias: MutableList<Noticia?> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        val position = holder.bindingAdapterPosition
        val noticia = mListNoticias[position]
        holder.title.text = noticia?.titulo

        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, PostActivity::class.java)
            Shared.instance.noticiaSelecionada = noticia
            startActivity(mContext, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return mListNoticias.size
    }

    fun setData(listNoticias: MutableList<Noticia>){
        mListNoticias.clear()
        mListNoticias.addAll(listNoticias.toMutableList())
        this.notifyDataSetChanged()
    }

    fun updateLayout(){
        this.notifyDataSetChanged()
    }

    // uma classe interna(ou seja dentro de outra classe)
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var title: TextView = itemView.findViewById(R.id.itemtitle)
    }
}