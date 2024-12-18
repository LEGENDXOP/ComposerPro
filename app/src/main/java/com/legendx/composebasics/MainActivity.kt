package com.legendx.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.legendx.composebasics.ui.theme.ComposeBasicsTheme
import com.legendx.composerpro.customButtons.CustomButton
import com.legendx.composerpro.customButtons.CustomElevatedButton
import com.legendx.composerpro.customButtons.CustomOutlinedButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Greeting(
                            name = "Android"
                        )
                        CustomButton(
                            onClick = { /*This is mandatory*/ },
                            onDoubleClick = { /*This is optional*/ },
                            onLongClick = { /*This is optional*/ },
                            haptics = true, // This is optional and is set to false by default
                        ){
                            Text("Custom Button")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicsTheme {
        Greeting("Android")
    }
}