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

        titulo= findViewById(R.id.editTitulo)
        noticia = findViewById(R.id.editNoticia)
        data= findViewById(R.id.editData)
        autor= findViewById(R.id.editAutor)
        publicar = findViewById(R.id.button)
//        titulo.text = Shared.instance.noticiaSelecionada?.titulo
//        noticia.text = Shared.instance.noticiaSelecionada?.noticias
//        data.text = Shared.instance.noticiaSelecionada?.data
//        autor.text = Shared.instance.noticiaSelecionada?.autor

        publicar.setOnClickListener {
            val titulo = titulo.text.toString()
            val noticia = noticia.text.toString()
            val data = data.text.toString()
            val autor = autor.text.toString()

            val nota= Noticia(titulo,noticia,data,autor)

            Shared.instance.noticiaLista.add(nota)
            print(Shared.instance.noticiaLista[0].titulo)
            Toast.makeText(this, "" + Shared.instance.noticiaLista[0].titulo, Toast.LENGTH_SHORT).show()
        }

    }
}