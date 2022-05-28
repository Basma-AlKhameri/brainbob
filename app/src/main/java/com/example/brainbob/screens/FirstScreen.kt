package com.example.brainbob.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.brainbob.NavRoutes
import com.example.brainbob.R

@Composable
fun FirstScreen(navController: NavController) {
    Box(Modifier.fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Box() {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "",
                        Modifier.size(width = 150.dp, height = 100.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_person),
                        contentDescription = "",
                        Modifier.padding(top = 24.dp)
                    )
                }
            }
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(top = 16.dp)
            ) {
                Column() {
                    Text(
                        text = "Be ready to learn English easily",
                        textAlign = TextAlign.Center,
                         style = typography.h1
                    )

                    Text(
                        text = "Listen to stories, watch videos and" +
                                " improve your language with Brainbob",
                        textAlign = TextAlign.Center,
                        style = typography.body2,
                        color= Color.Gray,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
            }
            Box(Modifier.padding(16.dp), contentAlignment = Alignment.BottomCenter) {
                Button(shape = RoundedCornerShape(40.dp),
                    onClick = { navController.navigate(NavRoutes.SecondScreen.route) }
                ) { Text(
                        text = "Join us",
                        style = typography.button,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun preview() {
    FirstScreen(navController = rememberNavController())
}