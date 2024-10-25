package com.example.lr2

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputEditText

class FillPersonDataParamsActivity : AppCompatActivity() {
    lateinit var dateEdt: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_fillpersdata)
        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_vector);
            actionBar.setTitle("Мои данные")
            // showing the back button in action bar
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        dateEdt = findViewById(R.id.birthData)

        dateEdt.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                R.style.CustomDatePickerDialog,
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    dateEdt.setText(dat)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()

        }
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()  // Или вам может понадобиться вызвать finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

