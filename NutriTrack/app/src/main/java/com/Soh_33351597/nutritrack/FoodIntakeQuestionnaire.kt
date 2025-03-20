package com.Soh_33351597.nutritrack

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.Soh_33351597.nutritrack.ui.theme.NutriTrackTheme

data class Persona(
    val description: String,
    val imageResId: Int
)


class FoodIntakeQuestionnaire : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NutriTrackTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    Column(modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        QuestionnaireTopBar()

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
                fontSize = 22.sp,
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

    val context = LocalContext.current

    val personaOptions = hashMapOf(
        "Health Devotee" to Persona(
            description = "I’m passionate about healthy eating & health plays a big part in my life. " +
                            "I use social media to follow active lifestyle personalities or get new " +
                            "recipes/exercise ideas. " +
                            "I may even buy superfoods or follow a particular type of diet. " +
                            "I like to think I am super healthy.",
            imageResId = R.drawable.health_devotee_icon),
        "Mindful Eater" to Persona(
            description = "I’m health-conscious and being healthy and eating healthy is important to me. " +
                            "Although health means different things to different people, " +
                            "I make conscious lifestyle decisions about eating based on what " +
                            "I believe healthy means. " +
                            "I look for new recipes and healthy eating information on social media.",
            imageResId = R.drawable.mindful_eater_icon),
        "Wellness Striver" to Persona(
            description = "I aspire to be healthy (but struggle sometimes). " +
                            "Healthy eating is hard work! I’ve tried to improve my diet, " +
                            "but always find things that make it difficult to stick with the changes. " +
                            "Sometimes I notice recipe ideas or healthy eating hacks, " +
                            "and if it seems easy enough, I’ll give it a go.",
            imageResId = R.drawable.wellness_striver_icon),
        "Balance Seeker" to Persona(
            description = "I try and live a balanced lifestyle, and I think that all foods are " +
                            "okay in moderation. I shouldn’t have to feel guilty about eating a " +
                            "piece of cake now and again. I get all sorts of inspiration from social " +
                            "media like finding out about new restaurants, fun recipes and sometimes " +
                            "healthy eating tips.",
            imageResId = R.drawable.balance_seeker_icon),
        "Health Procrastinator" to Persona(
            description = "I’m contemplating healthy eating but it’s not a priority for me " +
                            "right now. I know the basics about what it means to be healthy, " +
                            "but it doesn’t seem relevant to me right now. I have taken a few steps " +
                            "to be healthier but I am not motivated to make it a high priority because " +
                            "I have too many other things going on in my life.",
            imageResId = R.drawable.health_procrastinator_icon),
        "Food Carefree" to Persona(
            description = "I’m not bothered about healthy eating. I don’t really see the point and " +
                            "I don’t think about it. I don’t really notice healthy eating tips or " +
                            "recipes and I don’t care what I eat.",
            imageResId = R.drawable.food_carefree_icon))

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                "Tick all the food categories you can eat",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(10.dp))

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

            Text("Your Persona", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "People can be broadly classified into 6 different types based on their" +
                        "eating preferences. Click on each button below to find out the different types, " +
                        "and select the type that best fits you!",
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    ShowButtonAndPersonaInfoModal("Health Devotee", personaOptions.getValue("Health Devotee"))
                    ShowButtonAndPersonaInfoModal("Balance Seeker", personaOptions.getValue("Balance Seeker"))
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    ShowButtonAndPersonaInfoModal("Mindful Eater", personaOptions.getValue("Mindful Eater"))
                    ShowButtonAndPersonaInfoModal("Health Procrastinator", personaOptions.getValue("Health Procrastinator"))
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    ShowButtonAndPersonaInfoModal("Wellness Striver", personaOptions.getValue("Wellness Striver"))
                    ShowButtonAndPersonaInfoModal("Food Carefree", personaOptions.getValue("Food Carefree"))
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "Which persona best fits you?",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(10.dp))

            ExposedDropdownMenuBox(
                expanded = isDropdownExpanded,
                onExpandedChange = { isDropdownExpanded = it }
            ) {
                OutlinedTextField(
                    value = selectedPersona,
                    onValueChange = { selectedPersona = it },
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDropdownExpanded) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(MenuAnchorType.PrimaryNotEditable)
                        .clickable { isDropdownExpanded = true }
                )

                ExposedDropdownMenu(
                    expanded = isDropdownExpanded,
                    onDismissRequest = { isDropdownExpanded = false }
                ) {
                    personaOptions.keys.forEach { id ->
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

            Text("Timings", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Column {
                    Text("What time of the day approx, do you normally eat your biggest meal?", fontSize = 14.sp)
                    Text("What time of the day approx, do you go to sleep at night?", fontSize = 14.sp)
                    Text("What time of the day approx, do you wake up in the morning?", fontSize = 14.sp)
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
                    onClick = { context.startActivity(Intent(context, HomeScreen::class.java)) }
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
        Text(text, fontSize = 14.sp)
    }
}

@Composable
fun ShowButtonAndPersonaInfoModal(persona: String, personaInfo: Persona) {
    var showDialog by remember { mutableStateOf(false) }

    Button(
        onClick = { showDialog = true },
        shape = RoundedCornerShape(5.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        Text(persona, fontSize = 12.sp)
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = personaInfo.imageResId),
                        contentDescription = "$persona Logo",
                        modifier = Modifier.size(150.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(persona, textAlign = TextAlign.Center, fontWeight = FontWeight.ExtraBold)
                }
            },
            text = {
                Column {
                    Text(personaInfo.description, textAlign = TextAlign.Center)
                }
            },
            confirmButton = { },
            dismissButton = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = { showDialog = false }, shape = RoundedCornerShape(5.dp)) {
                        Text("Dismiss")
                    }
                }
            }
        )
    }
}
