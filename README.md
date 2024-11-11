# Custom Alert Dialog

A simple, customizable alert dialog library built with Jetpack Compose, allowing you to easily set titles, messages, and actions for multiple buttons in your Android app.

## Features

- **Flexible Design**: Customize the dialog title, message, and buttons with specific actions.
- **Builder Pattern**: Easily configure your dialog using the builder pattern for a fluent and readable syntax.
- **Jetpack Compose Support**: Compose-based dialog that integrates seamlessly into Compose UI projects.

## Installation

Add the library dependency to your project by including the following in your `build.gradle` file:

```gradle
dependencies {
    implementation("com.github.ashishhgour:custom_alert_dialog:1.0")
}
```

Ensure you have added JitPack to your repositories in `settings.gradle` file:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```


## Usage

### Step 1: Build the Custom Alert Dialog
Create an instance of CustomAlertDialog with Builder, setting up the title, message, and button actions.

```kotlin
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

```

### Step 2: Display the Dialog in Your Composable
In your composable, call ShowDialog to display the dialog with a dismiss action.

```kotlin
@Composable
fun MainScreen() {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        customDialog.ShowDialog(onDismiss = { showDialog = false })
    }

    // Your main content here
}
```

Example:

```kotlin
@Composable
fun MainScreen() {
    var showDialog by remember { mutableStateOf(false) }

    // Create a dialog instance
    val customDialog = CustomAlertDialog.Builder()
        .setTitle("Sample Alert")
        .setMessage("This is a customizable alert dialog.")
        .addButton("Confirm") {
            // Handle confirm action
        }
        .addButton("Cancel") {
            // Handle cancel action
        }
        .build()

    Column {
        Button(onClick = { showDialog = true }) {
            Text("Show Alert Dialog")
        }

        if (showDialog) {
            customDialog.ShowDialog(onDismiss = { showDialog = false })
        }
    }
}
```

Sample App
For a working example of how to use this library in your project, check out our Sample App repository.
https://github.com/ashishhgour/custom_alert_sample_app

