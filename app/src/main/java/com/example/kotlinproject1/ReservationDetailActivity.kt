package com.example.kotlinproject1

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import com.example.kotlinproject1.databinding.ActivityReservationDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*

class ReservationDetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityReservationDetailBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        var dayOfReservation : Int? = null
        var monthOfReservation : Int? = null
        var yearOfReservation : Int? = null
        binding = ActivityReservationDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent= Intent(this,MainActivity::class.java)
        binding.dateInput.setOnClickListener{
            val c= Calendar.getInstance()
            val listener= DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                binding.dateInput.text = "Date of reservation: $dayOfMonth/$month/$year"
                yearOfReservation=year
                monthOfReservation=month
                dayOfReservation=dayOfMonth
            }
            val dpd= DatePickerDialog(this, listener,c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(
                Calendar.DAY_OF_MONTH))
            dpd.datePicker.minDate=System.currentTimeMillis()
            dpd.show()
        }
        binding.reservationSitsBtn.setOnClickListener {
            if(binding.nameInput.text.toString() == "" ||dayOfReservation==null|| binding.amountInput.text.toString() == ""){
                Toast.makeText(this,"Please enter every detail",Toast.LENGTH_SHORT).show()
            }else{
                val bottomSheetDialog = BottomSheetDialog(this)
                bottomSheetDialog.setContentView(R.layout.reserved_sits_dialog)
                bottomSheetDialog.findViewById<TextView>(R.id.date_text)?.text =
                    "Date: $dayOfReservation/$monthOfReservation/$yearOfReservation"
                bottomSheetDialog.findViewById<TextView>(R.id.name_text)?.text = "Thank you ${binding.nameInput.text}"
                if (binding.veganCheck.isChecked) {
                    bottomSheetDialog.findViewById<TextView>(R.id.vegan_text)?.text = "Vegan: yes we are!"
                } else {
                    bottomSheetDialog.findViewById<TextView>(R.id.vegan_text)?.text = "Vegan: no we are not"
                }
                bottomSheetDialog.findViewById<TextView>(R.id.amount_text)?.text="Amount: ${binding.amountInput.text}"
                bottomSheetDialog.show()
            }
        }
    }
}
