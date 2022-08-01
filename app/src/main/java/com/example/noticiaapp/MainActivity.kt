package com.example.noticiaapp

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat

import androidx.core.content.ContextCompat.startActivity
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
    private lateinit var btn_post:ImageButton
    private val Permissions = arrayOf(
        Manifest.permission.INTERNET,
        Manifest.permission.ACCESS_NETWORK_STATE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mContext = this
        supportActionBar!!.hide()
        btn_post = binding.btnPost.findViewById(R.id.btn_post)
        recycleview = binding.recyclerview.findViewById(R.id.recyclerview)
        initializerAdapter(recycleview)


        btn_post.setOnClickListener {
            val intent = Intent(this, PostActivity::class.java)
            startActivity(mContext, intent, null)
        }

   }

    override fun onResume() {
        super.onResume()
        if(!hasPhonePermission(this,*Permissions)){
            askPermissions
        }
    }
    private fun hasPhonePermission(context: Context?,vararg permissions:String ):Boolean{
        if(context != null){
            for (permission in permissions){
                if(ActivityCompat.checkSelfPermission(context,permission) != PackageManager.PERMISSION_GRANTED){
                    return false
                }
            }
        }
        return true
    }

    private val askPermissions = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){ permissions ->
        val granted =  permissions.entries.all{
            it.value == true
        }
        if(granted){
            Toast.makeText(this,"Permisssion alloewd",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Permisssion denied",Toast.LENGTH_SHORT).show()
        }
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