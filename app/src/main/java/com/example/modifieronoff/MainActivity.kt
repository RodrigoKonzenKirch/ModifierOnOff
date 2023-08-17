package com.example.modifieronoff

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.modifieronoff.ui.theme.ModifierOnOffTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifierOnOffTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

/*
    Sample code demonstrating 3 different ways to conditionally set modifiers of a Composable
    The click modifier in a Text composable is enabled or disabled based on a condition
    See the modifier of the Text inside each of these Composables:
    TextConditionallyClickable1, TextConditionallyClickable2 and TextConditionallyClickable3
*/

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    modifier.padding(horizontal = 8.dp, vertical = 16.dp)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Example1(modifier = modifier)
        Spacer(modifier = Modifier.height(32.dp))
        Example2(modifier = modifier)
        Spacer(modifier = Modifier.height(32.dp))
        Example3(modifier = modifier)
    }
}

@Composable
fun Example1(modifier: Modifier) {
    var isTextClickEnabled by remember {
        mutableStateOf(true)
    }
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { isTextClickEnabled = !isTextClickEnabled }) {
            Text(text = if (isTextClickEnabled) "Disable clicks on text bellow" else "Enable clicks on text bellow")
        }
        Spacer(modifier = Modifier.height(12.dp))
        TextConditionallyClickable1(isTextClickEnabled)
    }
}

@Composable
fun Example2(modifier: Modifier) {
    var isTextClickEnabled by remember {
        mutableStateOf(true)
    }
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { isTextClickEnabled = !isTextClickEnabled }) {
            Text(text = if (isTextClickEnabled) "Disable clicks on text bellow" else "Enable clicks on text bellow")
        }
        Spacer(modifier = Modifier.height(12.dp))
        TextConditionallyClickable2(isTextClickEnabled)
    }
}

@Composable
fun Example3(modifier: Modifier) {
    var isTextClickEnabled by remember {
        mutableStateOf(true)
    }
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { isTextClickEnabled = !isTextClickEnabled }) {
            Text(text = if (isTextClickEnabled) "Disable clicks on text bellow" else "Enable clicks on text bellow")
        }
        Spacer(modifier = Modifier.height(12.dp))
        TextConditionallyClickable3(isTextClickEnabled)
    }
}

@Composable
fun TextConditionallyClickable1(isClickEnabled: Boolean = true) {
    var clickCounter by remember {
        mutableStateOf(0)
    }
    Text(
        modifier = Modifier.then(if (isClickEnabled) Modifier.clickable { clickCounter++ } else Modifier),
        text = if (isClickEnabled) {
            "Clickable text. It has been clicked $clickCounter times. (Clicks are enabled)"
        } else {
            "Clickable text. It has been clicked $clickCounter times. (Clicks are disabled)"
        }
    )
}

@Composable
fun TextConditionallyClickable2(isClickEnabled: Boolean = true) {
    var clickCounter by remember {
        mutableStateOf(0)
    }
    Text(
        modifier = if (isClickEnabled) Modifier.clickable { clickCounter++ } else Modifier,
        text = if (isClickEnabled) {
            "Clickable text. It has been clicked $clickCounter times. (Clicks are enabled)"
        } else {
            "Clickable text. It has been clicked $clickCounter times. (Clicks are disabled)"
        }
    )
}

@Composable
fun TextConditionallyClickable3(isClickEnabled: Boolean = true) {
    var clickCounter by remember {
        mutableStateOf(0)
    }

    val clickableModifier = if (isClickEnabled) Modifier.clickable { clickCounter++ } else Modifier
    Text(
        modifier = clickableModifier,
        text = if (isClickEnabled) {
            "Clickable text. It has been clicked $clickCounter times. (Clicks are enabled)"
        } else {
            "Clickable text. It has been clicked $clickCounter times. (Clicks are disabled)"
        }
    )
}

