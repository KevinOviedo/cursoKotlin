package com.example.myapplication.dogdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import coil.load
import com.example.myapplication.Dog
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDogDetailBinding

class DogDetailActivity : AppCompatActivity() {

    companion object{
        const  val DOG_KEY = "dog"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dog = intent?.extras?.getParcelable<Dog>(DOG_KEY)

        if(dog == null){
            Toast.makeText(this, R.string.error_showing_dog, Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        binding.dogIndex.text = getString(R.string.dog_index_format,dog.index)
        binding.lifeExpectancy.text = getString(R.string.dog_life, dog.lifeExpectancy)
        binding.dog = dog
        binding.dogImage.load(dog.imageUrl)
        binding.closeButton.setOnClickListener{
            finish()
        }
    }
}