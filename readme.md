# **ComposerPro**

**ComposerPro** is a **Jetpack Compose** library offering additional composables that streamline complex UI components, reducing development time. The **current version (1.0.0)** includes three customizable button composables, making button creation easier and more flexible.

## **Features**

ComposerPro provides three custom buttons that share the same parameter structure, making them **easy to use and modify**:

### **Custom Button Structure**

```kotlin
CustomButton(
    onClick: () -> Unit, // Triggered when the button is clicked
    onDoubleClick: () -> Unit = {}, // Triggered on double click
    onLongClick: () -> Unit = {}, // Triggered on long press; does not affect click or ripple effect
    haptics: Boolean = false, // Enables haptic feedback on click, long press, and double click
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.shape,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit = {}
)
```

### **Available Buttons**

ComposerPro offers a variety of button types to suit different design needs:

1. **CustomButton**: A versatile button with customizable actions and appearance.

2. **CustomOutlinedButton**: A button with an outlined style, perfect for secondary actions.

3. **CustomElevatedButton**: An elevated button that adds depth to your UI, ideal for primary actions.

Each button type shares the same parameter structure, ensuring a **consistent and intuitive** development experience.

## **Getting Started**

To integrate ComposerPro into your project, follow these steps:

### **1. Add JitPack Repository**

Open your **`settings.gradle.kts`** file and add the following line in the **`repositories`** section:

```kotlin
mavenCentral()
maven(url = "https://jitpack.io")
```

### **2. Add Dependency**

In your app-level **`build.gradle.kts`**, add the following dependency:

```kotlin
implementation("com.github.LEGENDXOP:ComposerPro:1.0.1")
```

Sync your project after adding the dependency.

## **Usage Example**

Here’s how to use a **custom button** from ComposerPro:

```kotlin
CustomButton(
    onClick = { /* Mandatory action */ },
    onDoubleClick = { /* Optional action */ },
    onLongClick = { /* Optional action */ },
    haptics = true // Optional, set to false by default
    // more parameters can be added here
) {
    Text("Custom Button")
}
```

You can use **`CustomOutlinedButton`** and **`CustomElevatedButton`** in the same way as the **`CustomButton`** example above:

### **CustomOutlinedButton Example**

```kotlin
CustomOutlinedButton(
    onClick = { /* Mandatory action */ },
    onDoubleClick = { /* Optional action */ },
    onLongClick = { /* Optional action */ },
    haptics = true // Optional, set to false by default
) {
    Text("Custom Outlined Button")
}
```

### **CustomElevatedButton Example**

```kotlin
CustomElevatedButton(
    onClick = { /* Mandatory action */ },
    onDoubleClick = { /* Optional action */ },
    onLongClick = { /* Optional action */ },
    haptics = true // Optional, set to false by default
) {
    Text("Custom Elevated Button")
}
```

## **Contribution**

Contributions are welcome! If you have any **ideas, suggestions, or found any bugs**, feel free to contribute in the following ways:

1. **Report Bugs**: If you encounter any bugs, please create an **issue** [here](https://github.com/LEGENDXOP/ComposerPro/issues).
2. **Request Features**: If you have an idea for a new feature, create a **feature request** issue.
3. **Submit Pull Requests**:
    - Fork the repository.
    - Create a new branch for your feature or bug fix.
    - Make your changes and push them to your branch.
    - Submit a **pull request** with a clear description of your changes.

Let’s build a better **ComposerPro** together!

## **Contact**

For any questions or support, feel free to contact: [**Email**](mailto:legendx@legendx.live)
