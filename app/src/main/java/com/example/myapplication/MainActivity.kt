package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.models.PelisClient
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pelisAdapter = PelisAdapter(emptyList(),object :PelisClickedListener{
            override fun onPelisClicked(peli: Result){
                Toast.makeText(this@MainActivity, peli.original_title, Toast.LENGTH_LONG).show()
            }
        })

        binding.recycler.adapter

        thread {
            val api_key="";
            val popPelis=PelisClient.service.listPopularPelis(api_key)
            val body = popPelis.execute().body()
            if (body!=null){
                pelisAdapter.pelis=body.results
                pelisAdapter.notifyDataSetChanged()
            }
        }
    }
}