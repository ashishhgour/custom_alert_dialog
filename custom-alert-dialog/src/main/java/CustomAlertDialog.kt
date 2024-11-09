package com.example.customalertdialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class CustomAlertDialog private constructor(
    private val title: String?,
    private val message: String?,
    private val buttons: List<ButtonConfig>
) {

    // Data class to hold button title and action
    data class ButtonConfig(val title: String, val action: () -> Unit)

    // Builder class to construct the dialog
    class Builder {
        private var title: String? = null
        private var message: String? = null
        private val buttons = mutableListOf<ButtonConfig>()

        // Set the title of the dialog
        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        // Set the message of the dialog
        fun setMessage(message: String): Builder {
            this.message = message
            return this
        }

        // Add a button with a title and an action
        fun addButton(title: String, action: () -> Unit): Builder {
            buttons.add(ButtonConfig(title, action))
            return this
        }

        // Build the dialog
        fun build(): CustomAlertDialog {
            return CustomAlertDialog(title, message, buttons)
        }
    }

    // Compose function to show the dialog
    @Composable
    fun ShowDialog(onDismiss: () -> Unit) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = {
                title?.let {
                    Text(text = it)
                }
            },
            text = {
                message?.let {
                    Text(text = it)
                }
            },
            confirmButton = {
                // Add confirm buttons from the list
                buttons.forEach { button ->
                    Button(
                        onClick = {
                            button.action()
                            onDismiss()
                        }
                    ) {
                        Text(button.title)
                    }
                }
            },

        )
    }
}
