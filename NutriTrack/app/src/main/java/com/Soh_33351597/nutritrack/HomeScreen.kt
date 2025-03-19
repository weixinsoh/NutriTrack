package com.Soh_33351597.nutritrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.Soh_33351597.nutritrack.ui.theme.NutriTrackTheme

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NutriTrackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        name = "Rosie",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen(name: String = "Rosie", modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp, 40.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Text("Hello,", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.Gray)

            Text(name, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold)

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Your've already filled in your Food Intake " +
                        "Questionnaire, but you can change details here: ",
                    fontSize = 12.5.sp,
                    modifier = Modifier.width(270.dp))

                Button(
                    onClick = {},
                    shape = RoundedCornerShape(5.dp),
                    contentPadding = PaddingValues(horizontal = 10.dp)
                ) {
                    Icon(Icons.Outlined.Edit, contentDescription = "Edit")

                    Spacer(modifier = Modifier.width(5.dp))

                    Text("Edit")
                }
            }
            
            Image(
                painter = painterResource(id = R.drawable.nutri_track_logo),
                contentDescription = "Nutrition",
                modifier = Modifier.size(250.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("My Score", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
                TextButton(onClick = {}, contentPadding = PaddingValues(0.dp)) {
                    Text("See all scores", color = Color.Gray)

                    Spacer(modifier = Modifier.width(10.dp))

                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "See all scores",
                        tint = Color.Gray
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Row {
                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = "Arrow Up"
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text("Your Food Quality score")
                    }

                }

                Text("80/100", color = Color.Green, fontWeight = FontWeight.ExtraBold)
            }

            Spacer(modifier = Modifier.height(40.dp))

            HorizontalDivider(color = Color.LightGray)

            Spacer(modifier = Modifier.height(24.dp))

            Text("What is the Food Quality Score?", fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)

            Spacer(modifier = Modifier.height(16.dp))

            Text("Youd Food Quality Score provides a snapshot of how well your eating patterns " +
                    "align with established food guidelines, helping you identify both strengths and " +
                    "opportunities for improvement in your diet.\n" +
                    "\n" +
                    "This personalized measurement considers various food groups including vegetables, " +
                    "fruits whole grains, and proteins tp give you practical insights for making " +
                    "healthier food choices. ",
                textAlign = TextAlign.Justify)
        }
    }

}

@Composable
fun BottomNavBar() {
    BottomAppBar(
        modifier = Modifier.height(60.dp),
        content = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Home, contentDescription = "Home")
                Text("Go Home")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Home, contentDescription = "Insights")
                Text("Insights")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Home, contentDescription = "NutriCoach")
                Text("NutriCoach")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Settings, contentDescription = "Settings")
                Text("Settings")
            }
        }
    )
}