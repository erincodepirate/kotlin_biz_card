package com.cursedfood.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cursedfood.jetbizcard.ui.theme.JetBizCardTheme

val robotoFamily = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.roboto_thin_italic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.roboto_thin, FontWeight.Thin),
    Font(R.font.roboto_bold, FontWeight.Bold)
)

val pangolinFamily = FontFamily(
    Font(R.font.pangolin_regular)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                CreateBizCard()
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            //border = BorderStroke(4.dp, Color.Red),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            DisplayInfo()
        }
    }
}

@Composable
private fun DisplayInfo() {
    Column(
        modifier = Modifier
            .height(400.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DisplayProfileImage()
        Divider(modifier = Modifier.padding(10.dp))
        CreateInfo()
        Button(
            onClick = {},
            shape = MaterialTheme.shapes.medium,
        ) {
            Text(text = "Portfolio", style = MaterialTheme.typography.bodyMedium)

        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Raccy Raccoon",
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = "Android Programmer",
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "@raccytheraccoon",
            fontFamily = pangolinFamily,
            color = Color.Green,
            modifier = Modifier.padding(3.dp)
        )
    }
}

@Composable
private fun DisplayProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        val imageModifier = Modifier
            .size(150.dp)
            .border(BorderStroke(1.dp, Color.Black))
            .background(Yellow)
        Image(
            painter = painterResource(id = R.drawable.racctrash),
            contentDescription = "raccoon",
            contentScale = ContentScale.Crop,
            modifier = imageModifier
        )
    }
}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBizCardTheme {
        Greeting("Android")
    }
}*/
