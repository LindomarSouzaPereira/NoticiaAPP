package com.example.noticiaapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noticiaapp.adapters.AdapterNoticias
import com.example.noticiaapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recycleview: RecyclerView
    private lateinit var mAdapterNoticias: AdapterNoticias
    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        supportActionBar!!.hide()
        recycleview = binding.recyclerview.findViewById(R.id.recyclerview)
        initializerAdapter(recycleview)

   }

    private fun initializerAdapter(reciclerview: RecyclerView){
        reciclerview.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        mAdapterNoticias = AdapterNoticias(mContext)
        recycleview.adapter = mAdapterNoticias
        reciclerview.addItemDecoration(
            DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        )

        val noticias = Shared.instance.noticiaLista

        mAdapterNoticias.setData(noticias)
    }


}