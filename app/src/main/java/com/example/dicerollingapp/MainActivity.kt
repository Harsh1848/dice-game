package com.example.dicerollingapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat

import com.example.dicerollingapp.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private lateinit var sharedPreferences: SharedPreferences
private lateinit var Dice: dice

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize shared preferences


        // Initialize dice with 6 sides
        Dice = dice(6)

        // Set up dice options spinner
        val diceOptions = resources.getStringArray(R.array.dice_types)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, diceOptions)
        binding.diceSpinner.adapter = adapter

        // Set up roll button
        binding.rollButton.setOnClickListener {
            rollDice()
        }

        // Set up roll twice button
        binding.doubleRollButton.setOnClickListener {
            rollDiceTwice()
        }
    }

    private fun rollDice() {
        val selectedOption = binding.diceSpinner.selectedItemPosition
        val sides = when (selectedOption) {
            0 -> 4
            1 -> 6
            2 -> 8
            3 -> 10
            4 -> 12
            5 -> 20
            else -> 6
        }
        Dice = dice(sides)
        val result = Dice.roll()
        displayResult(result)
    }

    private fun rollDiceTwice() {
        val selectedOption = binding.diceSpinner.selectedItemPosition
        val sides = when (selectedOption) {
            0 -> 4
            1 -> 6
            2 -> 8
            3 -> 10
            4 -> 12
            5 -> 20
            else -> 6
        }
        Dice = dice(sides)
        val result1 = Dice.roll()
        val result2 = Dice.roll()
        displayResult(result1, result2)
    }

    private fun displayResult(result: Int) {
        binding.resultsTextView.text = result.toString()
        binding.resultsTextView.setTextColor(ContextCompat.getColor(this, R.color.black))
    }

    private fun displayResult(result1: Int, result2: Int) {
        binding.resultsTextView.text = "$result1, $result2"
        binding.resultsTextView.setTextColor(ContextCompat.getColor(this, R.color.black))
    }
}