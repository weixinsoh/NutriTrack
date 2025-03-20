package com.Soh_33351597.nutritrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.Soh_33351597.nutritrack.ui.theme.NutriTrackTheme

class InsightsScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NutriTrackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InsightsScreen(modifier: Modifier = Modifier) {
    val categories = listOf(
        "Vegetables" to 10, "Fruits" to 10, "Grains & Cereals" to 10, "Whole Grains" to 10,
        "Meat & Alternatives" to 10, "Dairy" to 10, "Water" to 2, "Unsaturated Fats" to 10,
        "Sodium" to 10, "Sugar" to 10, "Alcohol" to 2, "Discretionary Foods" to 8
    )

    var scores by remember { mutableStateOf(categories.map { it.second }) }
    val totalScore = scores.sum() * 10 / 120

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp, 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                "Insights: Food Score",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(24.dp))

            categories.forEachIndexed { index, (category, maxScore) ->
                ScoreSlider(category, scores[index], maxScore) { newScore ->
                    scores = scores.toMutableList().also { it[index] = newScore }
                }
            }
            
            Spacer(modifier = Modifier.height(40.dp))

            Text("Total Food Quality Score", fontWeight = FontWeight.Bold, fontSize = 22.sp, modifier = Modifier.fillMaxWidth())

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Slider(
                    value = totalScore.toFloat(),
                    onValueChange = {},
                    valueRange = 0f..100f,
                    enabled = false,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text("$totalScore/100", fontSize = 14.sp, color = Color.Gray, modifier = Modifier.weight(0.2f))
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {  },
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Share with someone")
            }

            Button(
                onClick = {  },
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Improve my diet!")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScoreSlider(label: String, score: Int, maxScore: Int, onScoreChange: (Int) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label, fontSize = 14.sp, modifier = Modifier.weight(1f))

            Slider(
                value = score.toFloat(),
                onValueChange = { newScore -> onScoreChange(newScore.toInt()) },
                valueRange = 0f..maxScore.toFloat(),
                modifier = Modifier
                    .height(10.dp)
                    .width(200.dp)
                    .weight(1f),
                thumb = {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(Color.Gray, shape = CircleShape)
                    )
                }
            )
            Spacer(modifier = Modifier.width(10.dp))

            Text("$score/$maxScore", fontSize = 14.sp, color = Color.Gray, modifier = Modifier.weight(0.3f))
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}
