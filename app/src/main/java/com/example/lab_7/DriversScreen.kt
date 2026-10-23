package com.example.lab_7

/* requirements [All Complete]
- There should be a button to return to the HomeScreen [Complete]
- There should be text indicating that it's the DriversScreen (i.e., "FormulaZero Drivers") [Complete]
- There should be a text field and a button to add drivers, where drivers added will be displayed in a list format [Complete]
- There should be a button to clear all drivers displayed [Complete]
*/

/*
will be verified: [All Complete]
- Verify that you can properly go from the HomeScreen to the DriversScreen [Complete]
- Verify that you can properly add at least one driver, and if that driver is properly displayed [Complete]
- Verify that you can properly clear the driver(s) from the list [Complete]
- Verify that the back button takes you back to the HomeScreen [Complete]
 */

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {
    var driverName by remember {
        mutableStateOf("")
    }

    var drivers = remember {
        mutableStateListOf<String>()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // back button
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("backButton") // for testing
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // title text
        Text(
            text = "FormulaZero Drivers",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // text field and button to add race locations
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = driverName,
                onValueChange = {
                    driverName = it // update location to new value
                },
                label = {
                    Text("Driver Name")
                },
                modifier = Modifier.testTag("nameInput") // for testing
                    .width(200.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Button(
                onClick = {
                    if (driverName.isNotBlank()) {
                        drivers.add(driverName)
                        driverName = ""
                    }
                },
                modifier = Modifier.testTag("addDriverButton") // for testing
            ) {
                Text("Add")
            }

            Spacer(modifier = Modifier.width(4.dp))

            Button(
                onClick = {
                    if (drivers.isNotEmpty()) {
                        drivers.clear()
                    }
                },
                modifier = Modifier.testTag("clearDriverButton") // for testing
            ) {
                Text("Clear")
            }
        }

        // list to display races
        LazyColumn {
            items(drivers) { race ->
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = race,
                    fontSize = 24.sp
                )
            }
        }
    }
}