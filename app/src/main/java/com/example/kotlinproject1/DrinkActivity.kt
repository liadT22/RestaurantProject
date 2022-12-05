package com.example.kotlinproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.kotlinproject1.databinding.ActivityDrinkBinding

class DrinkActivity : AppCompatActivity() {
    lateinit var binding : ActivityDrinkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding=ActivityDrinkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.blueberryImg.setOnClickListener {
            openDialog(R.layout.blueberry_rum_dialog)
        }
        binding.greenGinImg.setOnClickListener {
            openDialog(R.layout.green_jin_dialog)
        }
        binding.longIslandImg.setOnClickListener {
            openDialog(R.layout.long_island_dialog)
        }
        binding.strawberryMargaritaImg.setOnClickListener {
            openDialog(R.layout.strawberry_margarita_dialog)
        }
    }
    private fun openDialog(id: Int) {
        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(id, null)
        builder.setView(dialogView)
        val dialog = builder.create()
        dialogView.findViewById<Button>(R.id.ok_btn).setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}