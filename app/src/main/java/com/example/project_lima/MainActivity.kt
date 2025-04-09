package com.example.project_lima

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

/*
Nama : Muhammad Farhad Ajilla
NIM : 23552011063
Kelas : TIF CID 23 A
 */

// IMPLEMENTASI 4 INPUT CONTROL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // 1. Input Control Date & Time
    fun pickDate(view: View) {
        val calendar = Calendar.getInstance()
        val tvDateTime = findViewById<TextView>(R.id.tv_date_time)
        val datePicker = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${month + 1}/$year"
                val timePicker = TimePickerDialog(
                    this,
                    { _, hour, minute ->
                        val selectedTime = String.format("%02d:%02d", hour, minute)

                        val dateTime = "Tanggal: $selectedDate\nWaktu: $selectedTime"
                        tvDateTime.setText(dateTime)
                    },
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    true
                )
                timePicker.show()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePicker.show()
    }

    // 2. Input Control Alert
    fun resetDateTime(view: View) {
        AlertDialog.Builder(this)
            .setTitle("Reset Tanggal & Waktu")
            .setMessage("Yakin ingin reset tanggal dan waktu???")
            .setPositiveButton("Yakin") { _, _ ->
                val tvDateTime = findViewById<TextView>(R.id.tv_date_time)
                tvDateTime.text = "Tanggal: DD/MM/YYYY\nWaktu: HH:MM"

                // 3. Input Control Toast
                Toast.makeText(this, "Tanggal & waktu telah direset", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Nanti Saja") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    fun toastPhone(view: View) {
        val etPhone = findViewById<EditText>(R.id.et_phone)
        Toast.makeText(this, "Nomor telepon anda " + etPhone.text, Toast.LENGTH_SHORT).show()
    }
}