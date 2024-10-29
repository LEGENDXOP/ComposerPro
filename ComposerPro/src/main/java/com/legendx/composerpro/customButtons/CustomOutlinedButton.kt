package com.legendx.composerpro.customButtons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.LocalViewConfiguration
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest


@Composable
fun CustomOutlinedButton(
    onClick: () -> Unit,
    onLongClick: () -> Unit = {},
    onDoubleClick: () -> Unit = {},
    haptics: Boolean = false,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.outlinedShape,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    elevation: ButtonElevation? = null,
    border: BorderStroke? = ButtonDefaults.outlinedButtonBorder(enabled),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit = {}
) {
    val longDelay = LocalViewConfiguration.current.longPressTimeoutMillis
    val shortDelay = 200L
    val hapticManager = LocalHapticFeedback.current
    val interactionSource = remember { MutableInteractionSource() }
    val buttonClicked = remember { mutableStateListOf<Int>() }
    var doubleClicked by remember { mutableStateOf(false) }
    var longClicked by remember { mutableStateOf(false) }
    LaunchedEffect(buttonClicked.size) {
        if (buttonClicked.size < 2) {
            delay(shortDelay)
            buttonClicked.clear()
            return@LaunchedEffect
        } else {
            doubleClicked = true
        }
        buttonClicked.clear()
    }

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collectLatest { interaction ->
            when (interaction) {
                is PressInteraction.Press -> {
                    buttonClicked.add(1)
                    longClicked = false
                    delay(longDelay)
                    longClicked = true
                    onLongClick()
                    if (haptics) hapticManager.performHapticFeedback(HapticFeedbackType.LongPress)
                }

                is PressInteraction.Release -> {
                    delay(shortDelay)
                    if (longClicked.not() and doubleClicked.not()) {
                        onClick()
                        if (haptics) hapticManager.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                    } else if (doubleClicked) {
                        onDoubleClick()
                        if (haptics) hapticManager.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                        doubleClicked = false
                    }
                }
            }
        }
    }
    OutlinedButton(
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        onClick = {}
    ) {
        content()
    }
}