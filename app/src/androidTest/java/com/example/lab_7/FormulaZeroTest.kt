package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun add_and_clear_drivers_and_go_home() {
        // navigate to drivers screen
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        // verify this is the drivers screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // enter driver name
        composeTestRule
            .onNodeWithTag("nameInput")
            .performTextInput("John Doe")

        // add driver name to list
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify driver appears in list
        composeTestRule
            .onNodeWithText("John Doe")
            .assertExists()

        // confirm you can clear out list
        composeTestRule
            .onNodeWithTag("clearDriverButton")
            .performClick()

        // confirm driver no longer exists
        composeTestRule
            .onNodeWithText("John Doe")
            .assertDoesNotExist()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}

/*
to do
- Verify that you can properly go from the HomeScreen to the DriversScreen
- Verify that you can properly add at least one driver, and if that driver is properly displayed
- Verify that you can properly clear the driver(s) from the list
- Verify that the back button takes you back to the HomeScreen
 */