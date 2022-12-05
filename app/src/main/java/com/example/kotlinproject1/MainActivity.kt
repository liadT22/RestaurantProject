package com.example.kotlinproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.kotlinproject1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fadeRotateAnim = AnimationUtils.loadAnimation(applicationContext,R.anim.fade_rotate)
        binding.sohoLogo.startAnimation(fadeRotateAnim)
        binding.foodMenuBtn.setOnClickListener {
            val intent= Intent(this,FoodActivity::class.java)
            startActivity(intent)
        }
        binding.drinkMenuBtn.setOnClickListener {
            val intent = Intent(this,DrinkActivity::class.java)
            startActivity(intent)
        }
        binding.reserveDetailBtn.setOnClickListener {
            val intent = Intent(this, ReservationDetailActivity::class.java)
            startActivity(intent)
        }
    }

}