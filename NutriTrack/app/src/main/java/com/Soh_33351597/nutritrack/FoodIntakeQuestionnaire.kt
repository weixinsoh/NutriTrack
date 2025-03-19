package com.Soh_33351597.nutritrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.Soh_33351597.nutritrack.ui.theme.NutriTrackTheme

class FoodIntakeQuestionnaire : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NutriTrackTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding).fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        QuestionnaireTopBar()
                    }

                    Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
                        FoodIntakeQuestionnaire(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionnaireTopBar() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    CenterAlignedTopAppBar(
        title = {
            Text("Food Intake Questionnaire",
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)},
        navigationIcon = {
            IconButton(onClick = { onBackPressedDispatcher?.onBackPressed() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun FoodIntakeQuestionnaire(modifier: Modifier = Modifier) {
    var fruitsChecked by remember { mutableStateOf(false) }
    var vegeChecked by remember { mutableStateOf(false) }
    var grainsChecked by remember { mutableStateOf(false) }
    var redMeatChecked by remember { mutableStateOf(false) }
    var seafoodChecked by remember { mutableStateOf(false) }
    var poultryChecked by remember { mutableStateOf(false) }
    var fishChecked by remember { mutableStateOf(false) }
    var eggsChecked by remember { mutableStateOf(false) }
    var nutsOrSeedsChecked by remember { mutableStateOf(false) }

    var selectedPersona by remember { mutableStateOf("") }
    var isDropdownExpanded by remember { mutableStateOf(false) }

    val personaOptions = listOf("Health Devotee", "Mindful Eater", "Wellness Striver",
        "Balance Seeker", "Health Procrastinator", "Food Carefree")

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "Tick all the food categories you can eat",
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Column {
                    CheckBoxItem("Fruits", fruitsChecked) { fruitsChecked = it }
                    CheckBoxItem("Red Meat", redMeatChecked) { redMeatChecked = it }
                    CheckBoxItem("Fish", fishChecked) { fishChecked = it }
                }

                Column {
                    CheckBoxItem("Vegetables", vegeChecked) { vegeChecked = it }
                    CheckBoxItem("Seafood", seafoodChecked) { seafoodChecked = it }
                    CheckBoxItem("Poultry", poultryChecked) { poultryChecked = it }
                }

                Column {
                    CheckBoxItem("Grains", grainsChecked) { grainsChecked = it }
                    CheckBoxItem("Eggs", eggsChecked) { eggsChecked = it }
                    CheckBoxItem("Nuts/Seeds", nutsOrSeedsChecked) { nutsOrSeedsChecked = it }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Your Persona", fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "People can be broadly classified into 6 different types based on their" +
                        "eating preferences. Click on each button below to find out the different types, " +
                        "and select the type that best fits you!"
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        contentPadding = PaddingValues(horizontal = 8.dp)
                    ) {
                        Text("Health Devotee", fontSize = 11.sp)
                    }

                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        contentPadding = PaddingValues(horizontal = 8.dp)
                    ) {
                        Text("Balance Seeker", fontSize = 12.sp)
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        contentPadding = PaddingValues(horizontal = 8.dp)
                    ) {
                        Text("Mindful Eater", fontSize = 12.sp)
                    }

                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        contentPadding = PaddingValues(horizontal = 8.dp)
                    ) {
                        Text("Health Procrastinator", fontSize = 12.sp)
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        contentPadding = PaddingValues(horizontal = 8.dp)
                    ) {
                        Text("Wellness Striver", fontSize = 12.sp)
                    }

                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(5.dp),
                        contentPadding = PaddingValues(horizontal = 8.dp)
                    ) {
                        Text("Food Carefree", fontSize = 12.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "Which persona best fits you?",
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(16.dp))

            ExposedDropdownMenuBox(
                expanded = isDropdownExpanded,
                onExpandedChange = { isDropdownExpanded = it }
            ) {
                OutlinedTextField(
                    value = selectedPersona,
                    onValueChange = { selectedPersona = it },
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDropdownExpanded) },
                    modifier = Modifier.fillMaxWidth()
                        .menuAnchor(MenuAnchorType.PrimaryNotEditable)
                        .clickable { isDropdownExpanded = true }
                )

                ExposedDropdownMenu(
                    expanded = isDropdownExpanded,
                    onDismissRequest = { isDropdownExpanded = false }
                ) {
                    personaOptions.forEach { id ->
                        DropdownMenuItem(
                            text = { Text(id) },
                            onClick = {
                                selectedPersona = id
                                isDropdownExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Timings", fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Column {
                    Text("What time of the day approx, do you normally eat your biggest meal?")
                    Text("What time of the day approx, do you go to sleep at night?")
                    Text("What time of the day approx, do you wake up in the morning?")
                }

                Column {

                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    shape = RoundedCornerShape(15.dp),
                    onClick = {}
                ) {
                    Text("Save")
                }
            }
        }


    }
}

@Composable
fun CheckBoxItem(text: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Text(text)
    }
}
