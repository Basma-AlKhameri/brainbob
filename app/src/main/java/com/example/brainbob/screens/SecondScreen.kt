package com.example.brainbob.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brainbob.R

@Composable
fun SecondScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.End,
    ) {
        Header()
        TagList()
        MainCard()
        Recommended()
    }

} //end of fun

@Composable
fun Header() {
    Box(
        Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopStart
    ) {
        Column(modifier = Modifier.padding(8.dp))
        {
            Text(
                text = "Choose what",
                style = typography.subtitle1
            )
            Text(
                text = "to learn today?",
                style = typography.h2
            )
        }
    }
}

@Composable
fun TagList() {
    var selectedItem by remember { mutableStateOf(0) }

    val tagList = listOf("Brainstorm", "Books", "Video", "Images")

    LazyRow(Modifier.padding(top = 8.dp)) {
        items(tagList.size) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { selectedItem = it },
                backgroundColor = if (selectedItem == it) Color.Black else Color.Gray,
                shape = RoundedCornerShape(40.dp),
            ) {
                Text(
                    text = tagList[it],
                    color = if (selectedItem==it) Color.White else Color.Black
                    , style = typography.subtitle2,
                    modifier = Modifier.padding(
                        start = 32.dp,
                        end = 32.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    )
                )
            }
        }
    }
}

@Composable
fun MainCard() {
    Card(
        backgroundColor = colors.primary,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Text(
                    text = "Vocabulary", style = typography.h3,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = "Listen 20 new words", style = typography.body2,
                    modifier = Modifier.padding(8.dp)
                )

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    modifier = Modifier.padding(top = 24.dp),
                    shape = RoundedCornerShape(10.dp),
                )
                {

                    Text(text = "Start", modifier = Modifier.padding(start = 8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.play_circle),
                        contentDescription = "",
                        modifier = Modifier.padding(start = 8.dp)

                        // modifier = Modifier.padding(top = 6.dp)
                    )
                }

            }
        }
        Box(contentAlignment = Alignment.CenterEnd) {
            Image(
                painter = painterResource(id = R.drawable.ic_person_white),
                contentDescription = "",
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
            )
        }

    }
}


@Composable
fun Recommended() {
    var itemSelected by remember { mutableStateOf(0) }


    var RecList = listOf("Chatting", "Listen", "Speak")
    var minList = listOf("5 minutes", "2 minutes", "3 minutes")
    var iconList = listOf(R.drawable.chat, R.drawable.headset, R.drawable.mic)
    val colors = listOf(
        Color(0xFFF56D63),
        Color(0xFF493EAA),
        Color(0xFFED8658))

    Column() {
        Text(
            text = "Recommended", style = typography.h2,
            modifier = Modifier.padding(start = 8.dp, top = 16.dp, bottom = 16.dp)
        )

        LazyColumn(Modifier.fillMaxWidth()) {

            items(RecList.size) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp).
                    clickable { itemSelected=it},
                    shape = RoundedCornerShape(15.dp),
                    backgroundColor = Color.LightGray
                ) {
                    Row(modifier = Modifier.padding(8.dp)) {
                        Card(
                            modifier = Modifier.padding(8.dp),
                            backgroundColor = colors[it]
                        ) {
                            Icon(
                                painter = painterResource(id = iconList[it]),
                                contentDescription = "",
                                Modifier
                                    .padding(8.dp)
                                    .background(colors[it]),
                                tint = Color.White

                            )
                        }
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(
                                text = RecList[it],
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            )
                            Text(
                                text = minList[it],
                                style = TextStyle(
                                    fontWeight = FontWeight.Light,
                                    fontSize = 16.sp
                                )
                            )
                        }

                        Box(
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp, start = 8.dp),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.bookmark),
                                contentDescription = "",
                                tint= if(itemSelected==it) Color.Black else Color.Gray
                            )
                        }

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_2_XL)
@Composable
fun show() {
    SecondScreen()
}