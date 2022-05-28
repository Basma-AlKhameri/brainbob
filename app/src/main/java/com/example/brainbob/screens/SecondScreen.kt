package com.example.brainbob.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.brainbob.DataClass.Recommendation
import com.example.brainbob.DataClass.Tags
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
    val tagList = listOf(
        Tags("Brainstorm"), Tags("Books"),
        Tags("Video"), Tags("Images")
    )

    LazyRow(Modifier.padding(top = 8.dp)) {
        items(tagList) { Tags ->
            tagCard(Tags.tagName)
        }
    }
}

@Composable
fun tagCard(tag: String) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        backgroundColor = Color.Gray, shape = RoundedCornerShape(40.dp)) {
        Text(
            text = tag, style = typography.subtitle2,
            modifier = Modifier.padding(start = 32.dp, end = 32.dp, top = 16.dp, bottom = 16.dp)
        )
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
    var RecList = listOf(
        Recommendation("Chatting", "5 minutes", R.drawable.chat),
        Recommendation("Listen", "2 minutes", R.drawable.headset),
        Recommendation("Speak", "3 minutes", R.drawable.mic)
    )
    Column() {
        Text(
            text = "Recommended", style = typography.h2,
            modifier = Modifier.padding(start= 8.dp, top=16.dp, bottom= 16.dp)
        )

        LazyColumn(Modifier.fillMaxWidth()) {

            items(RecList) { Recommendation ->
                RecommendationCard(
                    Recommendation.type, Recommendation.min, Recommendation.icon
                )
            }
        }
    }
}
@Composable
fun RecommendationCard(type: String, minutes: String, image: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(15.dp), backgroundColor = Color.LightGray
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = image), contentDescription = "",
                Modifier.padding(top = 16.dp)
            )

            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = type,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = minutes,
                    style = TextStyle(
                        fontWeight = FontWeight.Light,
                        fontSize = 16.sp
                    )
                )
            }
        }

    }
}

@Preview(showBackground = true, device = Devices.PIXEL_2_XL)
@Composable
fun show() {
    SecondScreen()
}