package com.example.kotlinproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.kotlinproject1.databinding.ActivityFoodBinding

class FoodActivity : AppCompatActivity() {
    lateinit var binding: ActivityFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.hurricanImg.setOnClickListener {
            openDialog(R.layout.hurrican_dialog)
        }
        binding.typhonImg.setOnClickListener {
            openDialog(R.layout.typhoon_dialog)
        }
        binding.sakaMakiImg.setOnClickListener {
            openDialog(R.layout.saka_maki_layout)
        }
        binding.pinkBatataImg.setOnClickListener {
            openDialog(R.layout.pink_batata_dialog)
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