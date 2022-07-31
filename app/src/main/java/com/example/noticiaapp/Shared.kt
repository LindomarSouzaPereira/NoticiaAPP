package com.example.noticiaapp

import com.example.noticiaapp.model.Noticia

class Shared {
    companion object{
        @JvmStatic
        var instance= Shared()
        //para salvar no storege
     }

    init {
        instance =this
    }

    var noticiaLista: MutableList<Noticia> = arrayListOf()


}