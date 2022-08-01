package com.example.noticiaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.noticiaapp.databinding.ActivityPostBinding
import com.example.noticiaapp.model.Noticia

class PostActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPostBinding
    private lateinit var titulo: TextView
    private lateinit var noticia: TextView
    private lateinit var data: TextView
    private lateinit var autor: TextView
    private lateinit var publicar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_post)

        titulo= binding.editTitulo.findViewById(R.id.editTitulo)
        noticia = binding.editNoticia.findViewById(R.id.editNoticia)
        data= binding.editData.findViewById(R.id.editData)
        autor= binding.editAutor.findViewById(R.id.editAutor)
        publicar = binding.button.findViewById(R.id.button)
        titulo.text = Shared.instance.noticiaSelecionada?.titulo
        noticia.text = Shared.instance.noticiaSelecionada?.noticias
        data.text = Shared.instance.noticiaSelecionada?.data
        autor.text = Shared.instance.noticiaSelecionada?.autor

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