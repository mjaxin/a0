package com.example.cmput301assignment0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    var displayString by remember { mutableStateOf("Are WE yes WE going here?")}
    var count by remember { mutableStateOf(0)}

    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = displayString,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                onClick = {
                    count++
                    if (determineOutcome(1)) {
                        displayString = "Yes"
                    }
                    else {
                        displayString = "No"
                    }
                }

            ) {
                Text("YES YES YES")
            }
            Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow,
                Color.Black),
                onClick = {
                    count++
                    if (determineOutcome(2)) {
                        displayString = "Yes"
                    }
                    else {
                        displayString = "No"
                    }
                }
            ) {
                Text("Perhaps...")
            }
            Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                onClick = {
                    count++
                    if (determineOutcome(3)) {
                        displayString = "Yes"
                    }
                    else {
                        displayString = "No"
                    }
                }
            ) {
                Text("NO NO NO")
            }
        }
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Button presses: $count",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

        }
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "CCID: mpjackso, ID: 1800321",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

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

@Preview(showBackground = true)
@Composable
fun CityListScreenPreview() {
    CMPUT301Assignment0Theme {
        InitialScreen(modifier = Modifier.padding())
    }
}