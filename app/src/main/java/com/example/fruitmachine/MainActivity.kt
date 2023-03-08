package com.example.fruitmachine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fruitmachine.ui.theme.FruitMachineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FruitMachineTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BodyContent()
                }
            }
        }
    }
}

@Composable
fun BodyContent() {
//    Content column
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
//        Title row
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Fruit Machine",
                color = Color.Blue,
                fontSize = 36.sp
            )
        }
//        Bottom container
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Red)
        ) {
//            Status row
            StatsRow()
//            Reel Row
            ReelRow()
//            Button Row
            ButtonRow()
        }
    }

}

@Composable
fun StatsItem(label: String = "Label", value: Int = 0) {
    Column() {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.Gray, shape = RoundedCornerShape(6.dp))
                .shadow(2.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                text = value.toString(),
                style = TextStyle(
                    fontSize = 36.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,

                    ),
            )
        }

    }
}

@Composable
fun StatsRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
//                Stats Item
            StatsItem(label = "Credits", value = 100)
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
//                Stats Item
            StatsItem(label = "Winnings", value = 3)
        }
    }
}

@Composable
fun ReelRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
            .height(200.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        repeat(3) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Yellow)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.apple),
                    contentDescription = "An Apple",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

    }
}

@Composable
fun ButtonRow(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp, 0.dp)) {
        repeat(3){
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(), elevation = ButtonDefaults.elevation(defaultElevation = 4.dp)) {
                Text(text = "Spin")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FruitMachineTheme {
//        BodyContent()

//        StatsRow()
//        ReelRow()
        ButtonRow()
    }

}