package com.example.brainbob.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.brainbob.R

// Set of Material typography styles to start with
val lato = FontFamily(
   //Font(R.font.lato_regular, FontWeight.ExtraBold),
  // Font(R.font.lato_light, FontWeight.ExtraBold),
   Font(R.font.lato_black, FontWeight.Black),
  Font(R.font.lato_bold, FontWeight.Black),
    Font(R.font.lato_regular, FontWeight.Normal)

)
val Typography = Typography(
   h1 = TextStyle(
       fontFamily = lato,
       fontWeight = FontWeight.Black,
      fontSize =40.sp
   ),

   body2 = TextStyle(
      fontFamily = lato,
      fontWeight = FontWeight.Normal,
      fontSize = 16.sp,
       color = Color.Gray
   ),
    button = TextStyle(
        fontFamily = lato,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    )
)

