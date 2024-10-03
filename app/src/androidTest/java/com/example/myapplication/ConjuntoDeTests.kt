package com.example.myapplication

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.Tablas.BarChartScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ConjuntoDeTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testInitialValues() {
        composeTestRule.setContent {
            BarChartScreen()
        }

        composeTestRule.onNodeWithText("Valor 1").assertExists()
        composeTestRule.onNodeWithText("Valor 2").assertExists()
        composeTestRule.onNodeWithText("Valor 3").assertExists()
    }

    @Test
    fun testShowCharts() {
        composeTestRule.setContent {
            BarChartScreen()
        }

        composeTestRule.onNodeWithText("Valor 1").performTextInput("10")
        composeTestRule.onNodeWithText("Valor 2").performTextInput("20")
        composeTestRule.onNodeWithText("Valor 3").performTextInput("30")
        composeTestRule.onNodeWithText("Mostrar TODAS LAS FUNCIONES").performClick()

        // Use onAllNodesWithText and filter by index
        composeTestRule.onAllNodesWithText("FUNCION 1")[0].assertExists()
        composeTestRule.onAllNodesWithText("FUNCION 2")[0].assertExists()
        composeTestRule.onAllNodesWithText("FUNCION 3")[0].assertExists()
    }

    @Test
    fun testShowAreaChart() {
        composeTestRule.setContent {
            BarChartScreen()
        }

        composeTestRule.onNodeWithText("Valor 1").performTextInput("10")
        composeTestRule.onNodeWithText("Valor 2").performTextInput("20")
        composeTestRule.onNodeWithText("Valor 3").performTextInput("30")
        composeTestRule.onNodeWithText("Mostrar TODAS LAS FUNCIONES").performClick()

        composeTestRule.onAllNodesWithText("FUNCION 7")[0].assertExists()
    }

    @Test
    fun testShowDonutChart() {
        composeTestRule.setContent {
            BarChartScreen()
        }

        composeTestRule.onNodeWithText("Valor 1").performTextInput("10")
        composeTestRule.onNodeWithText("Valor 2").performTextInput("20")
        composeTestRule.onNodeWithText("Valor 3").performTextInput("30")
        composeTestRule.onNodeWithText("Mostrar TODAS LAS FUNCIONES").performClick()

        composeTestRule.onAllNodesWithText("FUNCION 5")[0].assertExists()
    }

    @Test
    fun testShowHalfCircleChart() {
        composeTestRule.setContent {
            BarChartScreen()
        }

        composeTestRule.onNodeWithText("Valor 1").performTextInput("10")
        composeTestRule.onNodeWithText("Valor 2").performTextInput("20")
        composeTestRule.onNodeWithText("Valor 3").performTextInput("30")
        composeTestRule.onNodeWithText("Mostrar TODAS LAS FUNCIONES").performClick()

        composeTestRule.onAllNodesWithText("FUNCION 6")[0].assertExists()
    }

    @Test
    fun testShowLineChart() {
        composeTestRule.setContent {
            BarChartScreen()
        }

        composeTestRule.onNodeWithText("Valor 1").performTextInput("10")
        composeTestRule.onNodeWithText("Valor 2").performTextInput("20")
        composeTestRule.onNodeWithText("Valor 3").performTextInput("30")
        composeTestRule.onNodeWithText("Mostrar TODAS LAS FUNCIONES").performClick()

        composeTestRule.onAllNodesWithText("FUNCION 3")[0].assertExists()
    }

    @Test
    fun testShowPieChart() {
        composeTestRule.setContent {
            BarChartScreen()
        }

        composeTestRule.onNodeWithText("Valor 1").performTextInput("10")
        composeTestRule.onNodeWithText("Valor 2").performTextInput("20")
        composeTestRule.onNodeWithText("Valor 3").performTextInput("30")
        composeTestRule.onNodeWithText("Mostrar TODAS LAS FUNCIONES").performClick()

        composeTestRule.onAllNodesWithText("FUNCION 4")[0].assertExists()
    }
}