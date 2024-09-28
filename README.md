
# Dotted Indicator

A customizable dotted indicator for Jetpack Compose applications, perfect for simulating a "typing..." effect with animated dots. The widget offers full customization options for color, size, shape, shadow, gradients, and more.

## Demo
### Quick Demo

<img src="https://github.com/user-attachments/assets/0493e1e9-bbeb-4224-a9e6-2bf868f9b021" alt="Simulator Screenshot - iPhone 15 - 2024-09-10 at 23 26 24" width="350"/>

### Full Demo

![ScreenRecording2024-09-10at11 26 42PM-ezgif com-video-to-gif-converter](https://github.com/user-attachments/assets/9c30fde3-7f6f-4e61-a94a-0892632ae1f5)

## Features

- Customize dot colors, shapes, gradients, and more.
- Flexible control over the number of dots and their animation duration.
- Ideal for chat applications or any situation requiring a "typing..." animation.

## Installation

Add this widget directly to your Jetpack Compose project:

1. Add the following dependencies to your `build.gradle` file:

   ```groovy
   dependencies {
    // Your dependencies

    // Dotted Indicator
    implementation "com.github.tusharhow:dotted-indicator:1.0.0"
   }
   ```

2. Import the `DottedIndicator` composable in your Kotlin file:

   ```kotlin
   import com.tusharhow.dottedindicator.DottedIndicator
   ```

## Usage

Here's a basic example of how to use the `DottedIndicator`:

```kotlin
@Composable
fun TypingIndicatorDemo() {
    DottedIndicator(
        dotColor = Color.Blue,
        backgroundColor = Color.White,
        dotSize = 10f,
        dotCount = 4,
        durationMillis = 1500,
        padding = 12f,
        borderRadius = RoundedCornerShape(15.dp),
        isGradient = true,
        gradientColors = listOf(Color.Blue, Color.LightBlue),
        inactiveDotColor = Color.LightGray,
        inactiveGradientColors = listOf(Color.LightGray, Color.Gray)
    )
}
```

## Customization Options

### Constructor Parameters

| Property                | Type             | Default Value                                  | Description                                                             |
|-------------------------|------------------|------------------------------------------------|-------------------------------------------------------------------------|
| `dotColor`              | `Color`          | `Color.Gray`                                   | Color of the active dots in the indicator.                             |
| `backgroundColor`       | `Color`          | `Color(0xFFE0E0E0)`                           | Background color of the indicator box.                                  |
| `dotSize`               | `Float`          | `8f`                                          | Size of each dot.                                                       |
| `dotCount`              | `Int`            | `3`                                           | Number of dots to display.                                            |
| `durationMillis`        | `Int`            | `300`                                         | Animation duration for each dot.                                       |
| `padding`               | `Float`          | `10f`                                         | Padding inside the indicator container.                                 |
| `borderRadius`          | `RoundedCornerShape` | `RoundedCornerShape(12.dp)`                 | Border radius of the container.                                        |
| `dotSpacing`            | `Float`          | `4f`                                          | Spacing between dots.                                                  |
| `isGradient`            | `Boolean`        | `false`                                       | Set to `true` if you want to use gradients instead of solid colors.    |
| `gradientColors`        | `List<Color>`    | `listOf(Color.Gray, Color.Gray)`              | Gradient colors for the dots (if enabled).                             |
| `inactiveDotColor`      | `Color?`         | `null`                                        | Color of the inactive dots.                                            |
| `inactiveGradientColors` | `List<Color>`    | `listOf(Color.LightGray, Color.Gray)`         | Gradient colors for inactive dots.                                     |