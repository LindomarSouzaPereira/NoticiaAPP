package com.example.noticiaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.noticiaapp.databinding.ActivityMainBinding
import com.example.noticiaapp.model.Noticia

class Post : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var titulo: TextView
    private lateinit var noticia: TextView
    private lateinit var data: TextView
    private lateinit var autor: TextView
    private lateinit var publicar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_post)
        titulo= binding.editTitulo.findViewById(R.id.editTitulo)
        noticia = binding.editNoticia.findViewById(R.id.editNoticia)
        data= binding.editData.findViewById(R.id.editData)
        autor= binding.editAutor.findViewById(R.id.editAutor)
        publicar = binding.button.findViewById(R.id.button)


        publicar.setOnClickListener {
            val titulo = titulo.text.toString()
            val noticia = noticia.text.toString()
            val data = data.text.toString()
            val autor = autor.text.toString()

            val nota= Noticia(titulo,noticia,data,autor)

            Shared.instance.noticiaLista.add(nota)
            Toast.makeText(this, "Publicado com sucesso", Toast.LENGTH_SHORT).show()
        }

    }
}