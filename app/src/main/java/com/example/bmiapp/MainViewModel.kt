package com.example.bmiapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.pow
import kotlin.math.roundToInt

class MainViewModel: ViewModel() {
    var height by mutableStateOf(value = "")
    var weight by mutableStateOf(value = "")
    var resultBmi by mutableStateOf(0f)

    fun calcBmi() {
        val isHeight = height.toFloatOrNull()
        val isWeight = weight.toFloatOrNull()

        val resultHeight = isHeight?.div(100) ?: 0f

        val resultWeight = isWeight ?: 0f


        resultBmi = if (resultWeight > 0f || resultHeight > 0f) {
            (resultWeight / resultHeight.pow(2) * 10).roundToInt() / 10f
        } else 0f

    }
}