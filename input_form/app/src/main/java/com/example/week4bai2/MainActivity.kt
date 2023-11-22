package com.example.week4bai2

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private var firstName: EditText? = null
    private var lastName: EditText? = null
    private var radioGroup: RadioGroup? = null
    private var birthday: EditText? = null
    private var birthdaySelectButton: Button? = null
    private var address: EditText? = null
    private var email: EditText? = null
    private var checkbox: CheckBox? = null
    private var registerButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_unconstraint)

        firstName = findViewById(R.id.firstName)
        lastName = findViewById(R.id.lastName)
        radioGroup = findViewById(R.id.radioGroup)
        birthday = findViewById(R.id.birthday)
        birthdaySelectButton = findViewById(R.id.datePicker)
        birthdaySelectButton?.setOnClickListener { birthdaySelect() }
        address = findViewById(R.id.address)
        email = findViewById(R.id.email)
        checkbox = findViewById(R.id.checkbox)
        registerButton = findViewById(R.id.register)
        registerButton?.setOnClickListener { register() }

    }

    private fun register() {
        if (!isStringNotEmpty((firstName?.text.toString()))
            || !isStringNotEmpty((lastName?.text.toString()))
            || radioGroup?.checkedRadioButtonId == -1
            || !isStringNotEmpty((birthday?.text.toString()))
            || !isStringNotEmpty((address?.text.toString()))
            || !isStringNotEmpty((email?.text.toString()))
            || checkbox?.isChecked == false
        ) {
            Toast.makeText(applicationContext, "Please fill in all the required fields", Toast.LENGTH_SHORT).show()
            return
        }
        Toast.makeText(applicationContext, "Register successfully", Toast.LENGTH_SHORT).show()
    }

    private fun birthdaySelect() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->
                // Update the calendar with the selected date
                calendar.set(selectedYear, selectedMonth, selectedDay)

                // Handle the selected date (e.g., display it or use it in your code)
                val selectedDate = calendar.time
                val dateFormat = android.text.format.DateFormat.getDateFormat(this)
                val formattedDate = dateFormat.format(selectedDate)
                birthday?.setText(formattedDate.toString())
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }

    private fun isStringNotEmpty(input: String?): Boolean {
        return input != null && input.trim().isNotEmpty()
    }
}