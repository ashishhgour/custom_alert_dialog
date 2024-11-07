# CustomAlertDialog Library

A Kotlin-based Android library that provides a customizable alert dialog with support for configurable title, message, and multiple button options. The library allows the calling application to handle button clicks and retrieve details about the clicked button.

## Features

- **Customizable Title and Message**
- **Multiple Buttons** with Configurable Titles and Actions
- **Callback Handling** to Retrieve Button Titles or Indexes

## Compatibility

- Android 8.0 (API level 26) and above

## Installation

To add this library as a dependency in your Android project, you can use **JitPack** or **Maven Central**.

### Step 1: Add JitPack Repository

Add the JitPack repository to your root `build.gradle` at the end of `repositories`:

```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
### Step 2: Add the Dependency

Add the dependency to your app-level build.gradle:

```gradle
dependencies {
    implementation 'com.github.ashishhgour:CustomAlertDialog:1.0.0'
}
```

## Installation

### Step 1: Initialize and Display the Dialog
Add a button in your activity_main.xml layout to trigger the dialog

```xml
<Button
    android:id="@+id/btn_alert_dialog"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Show Alert Dialog" />
```

### Step 2: Set up and display the dialog in your MainActivity.kt

```kotlin
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customalertdialog.CustomAlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val button = findViewById<Button>(R.id.btn_alert_dialog)

        val dialog = CustomAlertDialog.Builder(this)
            .setTitle("Sample Alert")
            .setMessage("This is a customizable alert dialog.")
            .addButton("Confirm") { buttonTitle ->
                resultTextView.text = getString(R.string.button_clicked, buttonTitle)
            }
            .addButton("Cancel") { buttonTitle ->
                resultTextView.text = getString(R.string.button_clicked, buttonTitle)
            }
            .build()

        button.setOnClickListener {
            dialog.show()
        }
    }
}
```

## Sample Application
A sample Android application is included in this repository under the app directory. It demonstrates how to integrate the CustomAlertDialog library and display alert dialogs with multiple buttons and custom actions.

To run the sample app:

Clone the repository.
Open the project in Android Studio.
Build and run the sample application on an Android device or emulator.





