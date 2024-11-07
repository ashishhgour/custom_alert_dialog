package com.example.customalertdialog

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

class CustomAlertDialog private constructor(
    private val context: Context,
    private val title: String?,
    private val message: String?,
    private val buttons: List<ButtonConfig>
) {

    // Data class to hold button title and action
    data class ButtonConfig(val title: String, val action: (String) -> Unit)

    // Builder class to construct the dialog
    class Builder(private val context: Context) {
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
        fun addButton(title: String, action: (String) -> Unit): Builder {
            buttons.add(ButtonConfig(title, action))
            return this
        }

        // Build the dialog
        fun build(): CustomAlertDialog {
            return CustomAlertDialog(context, title, message, buttons)
        }
    }

    // Show the dialog
    fun show() {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)

        // Dynamically add buttons based on the list
        buttons.forEachIndexed { index, button ->
            when (index) {
                0 -> builder.setPositiveButton(button.title) { _, _ -> button.action(button.title) }
                1 -> builder.setNegativeButton(button.title) { _, _ -> button.action(button.title) }
                2 -> builder.setNeutralButton(button.title) { _, _ -> button.action(button.title) }
                else -> {
                    // Custom button handling
                    builder.setCancelable(false)
                    val dialog = builder.create()

                    // Use setButton() for additional buttons
                    dialog.setButton(DialogInterface.BUTTON_POSITIVE, button.title) { _, _ ->
                        button.action(button.title)
                    }

                    dialog.show()
                }
            }
        }

        builder.show()
    }
}
