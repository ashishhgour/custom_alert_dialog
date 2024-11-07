package com.example.customalertdialog

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn_alert_dialog)

        val resultTextView = findViewById<TextView>(R.id.alert_button_result)

        val dialog = CustomAlertDialog.Builder(this)
            .setTitle("Sample Alert")
            .setMessage("This is a customizable alert dialog.")

            .addButton("Confirm") { buttonTitle ->
                resultTextView.text = getString(R.string.button_clicked, buttonTitle)
                Log.d("Dialog", "Confirm clicked")
            }
            .addButton("Cancel") { buttonTitle ->
                resultTextView.text = getString(R.string.button_clicked, buttonTitle)
                Log.d("Dialog", "Cancel clicked")
            }
            .build()

        // Show dialog on button click
        button.setOnClickListener {
            dialog.show()
        }
    }
}
