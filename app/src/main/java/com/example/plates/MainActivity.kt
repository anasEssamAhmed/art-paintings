package com.example.plates

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plates.ui.theme.PlatesTheme
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.style.TextAlign
import com.example.plates.ui.theme.PurpleGrey80
import com.example.plates.ui.theme.backgroundColorOfThePaint
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlatesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    showPaintArt()
                }
            }
        }
    }
}

@Composable
fun showPaintArt() {
    var arrayOfImageAndText = mutableMapOf(
        "Samer Abdel Rahim" to R.drawable.image1,
        "Nasser Farhat" to R.drawable.image2,
        "Abdel-Aal" to R.drawable.image3,
        "Karim Nasr Farhat" to R.drawable.image4,
        "Hanan Al-Louly" to R.drawable.image5,
    )

    var counter by remember {
        mutableStateOf(0)
    }

    var currentValue : Pair<String , Int> = Pair(arrayOfImageAndText.keys.first() , arrayOfImageAndText.getValue(arrayOfImageAndText.keys.first()))

    when(counter){
        0 -> {currentValue = Pair(arrayOfImageAndText.keys.elementAt(0) , arrayOfImageAndText.getValue(arrayOfImageAndText.keys.elementAt(0)))}
        1 -> {currentValue = Pair(arrayOfImageAndText.keys.elementAt(1) , arrayOfImageAndText.getValue(arrayOfImageAndText.keys.elementAt(1)))}
        2 -> {currentValue = Pair(arrayOfImageAndText.keys.elementAt(2) , arrayOfImageAndText.getValue(arrayOfImageAndText.keys.elementAt(2)))}
        3 -> {currentValue = Pair(arrayOfImageAndText.keys.elementAt(3) , arrayOfImageAndText.getValue(arrayOfImageAndText.keys.elementAt(3)))}
        4 -> {currentValue = Pair(arrayOfImageAndText.keys.elementAt(4) , arrayOfImageAndText.getValue(arrayOfImageAndText.keys.elementAt(4)))}
    }
    Column(
        modifier = Modifier
            .wrapContentSize(align = Alignment.TopCenter)
            .padding(50.dp)
            .background(backgroundColorOfThePaint)
    ) {
        Image(
            painter = painterResource(currentValue.second),
            contentDescription = null,
            Modifier.size(350.dp).padding(20.dp)
        )
    }

    Column(
        modifier = Modifier
            .wrapContentSize(align = Alignment.BottomCenter)
            .padding(20.dp)
    ) {
        Text(
            text = currentValue.first,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .size(height = 50.dp , width = 200.dp)
                .background(PurpleGrey80)
                .padding(10.dp)

        )
        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            Button(onClick = {
                if(counter > 0 ){
                    counter--
                }else {
                    counter = 0
                }
            }) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = {
                if(counter < 4 ){
                    counter++
                }else {
                    counter = 1
                }
            }) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PlatesTheme {
        showPaintArt()
    }
}