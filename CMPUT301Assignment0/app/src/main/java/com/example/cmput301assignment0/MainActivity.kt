package com.example.cmput301assignment0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cmput301assignment0.ui.theme.CMPUT301Assignment0Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CMPUT301Assignment0Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InitialScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun InitialScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "I have no idea how to code in Kotlin",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

        }

        Row(modifier = modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = {
                    if (determineOutcome(1)) {
                        println("bro")
                        // Output yes
                    }
                    else {
                        println("bro")
                        // Output no
                    }
                }
            ) {
                Text("YES YES YES")
            }

            Button(
                onClick = {
                    if (determineOutcome(2)) {
                        println("bro")
                        // Output yes
                    }
                    else {
                        println("bro")
                        // Output no
                    }
                }
            ) {
                Text("Perhaps...")
            }
            Button(
                onClick = {
                    if (determineOutcome(3)) {
                        println("bro")
                        // Output yes
                    }
                    else {
                        println("bro")
                        // Output no
                    }
                }
            ) {
                Text("NO NO NO")
            }
        }
    }
}

fun determineOutcome(buttonPushed : Int) : Boolean {
    val numberGenerated = (1..10).random()

    if (buttonPushed == 1) { // YES YES YES pressed
        if(numberGenerated <= 6) return true // Yes
        else return false
    }
    if (buttonPushed == 2) { // Perhaps... pressed
        if(numberGenerated <= 3) return true // Yes
        else return false
    }
    if (buttonPushed == 3) { // NO NO NO pressed
        if(numberGenerated <= 1) return true // Yes
        else return false
    }

    return false
}