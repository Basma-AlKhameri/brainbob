package com.example.brainbob.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SecondScreen(){
    Column(modifier = Modifier.fillMaxSize()
        //horizontalAlignment = Alignment.End)
    ){

        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.TopStart) {
            Column(modifier = Modifier.padding(8.dp))
            {
                Text(text = "Choose what",
                style = typography.subtitle1)
                Text(text = "to learn today?",
                style= typography.h2)
            }
        }
    }

} //end of fun

@Preview( showBackground = true)
@Composable
fun show(){
    SecondScreen() 
}