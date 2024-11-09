package com.example.customalertdialog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        var resultText by remember { mutableStateOf("") }
        var showDialog by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { showDialog = true },
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(text = "Show Alert Dialog")
            }

            Text(
                text = resultText,
                fontSize = 18.sp
            )

            if (showDialog) {
                val customAlertDialog = CustomAlertDialog.Builder()
                    .setTitle("Alert Title")
                    .setMessage("This is a customizable alert dialog")
                    .addButton("Confirm") {
                        resultText = "Button clicked: Confirm"
                        showDialog = false
                    }
                    .addButton("Cancel") {
                        resultText = "Button clicked: Cancel"
                        showDialog = false
                    }

                    .build()

                customAlertDialog.ShowDialog(onDismiss = { showDialog = false })
            }
        }
    }
}