package com.example.myapplication.dogdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityDogDetailBinding

class DogDetailActivity : AppCompatActivity() {

    companion object{
        const  val DOG_KEY = "dog"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}