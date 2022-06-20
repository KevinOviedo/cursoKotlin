package com.example.myapplication.doglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Dog
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDogListBinding

class DogListActivity : AppCompatActivity() {

    private val dogListViewModel: DogListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.dogRecycler
        recycler.layoutManager = LinearLayoutManager(this)

        val adapter = DogAdapter()

        adapter.setOnItemClickListener{
            //pasar el dog a goddetailactivity


        }

        recycler.adapter = adapter

        dogListViewModel.dogList.observe(this){
            dogList->
            adapter.submitList(dogList)
        }


    }


}