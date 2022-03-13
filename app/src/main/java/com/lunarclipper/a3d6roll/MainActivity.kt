package com.lunarclipper.a3d6roll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * This app has one activity: it simulates the roll of 3d6
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button) //gain access to the button

        // set an event listener on the button, listening for a "click" (or tap, as the case may be)
        rollButton.setOnClickListener { rollDice() } //END rollButton.setOnClickListener

        //Display random roll on app start
        rollDice()

    }// END override fun onCreate(savedInstanceState: Bundle?)

    /**
     * Generate the roll of 3 d6 simultaneously
     */
    private fun rollDice() {
        /**
         * This project is a modified version of the die rolling app created in the Kotlin Basics
         * course on the Android studio site. I changed it to roll three dice, instead of just one.
         *
         * I realized the Dice object contained the random number generation method, and nothing
         * else. As such, I only need one instance. Code changed on 5 Feb 2022 so die1Roll, die2Roll
         * and die3Roll all access the same instance of Dice to generate their value.
         */
        val dice = Dice(6) //create a new 6 sided die object

        //Die 1
        //use Dice object private function to "roll" die (random number generated)
        val die1Roll = dice.roll()

        //grab the 1st ImageView
        val diceImage1: ImageView = findViewById(R.id.imageView1)

        //Select the correct image for the number rolled
        val drawableResource1 = when (die1Roll) {
            1 -> R.drawable.dado_rojo_uno
            2 -> R.drawable.dado_rojo_dos
            3 -> R.drawable.dado_rojo_tres
            4 -> R.drawable.dado_rojo_cuatro
            5 -> R.drawable.dado_rojo_cinco
            else -> R.drawable.dado_rojo_seis
        } //END when (diceImage)

        //Display the image
        diceImage1.setImageResource(drawableResource1)
        //Set the image description so app is accessibility friendly
        diceImage1.contentDescription = die1Roll.toString()
        //End Die 1

        //Die 2
        //use Dice object private function to "roll" die (random number generated)
        val die2Roll = dice.roll()

        //grab the 2nd ImageView
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        //Select the correct image for the number rolled
        val drawableResource2 = when (die2Roll) {
            1 -> R.drawable.dado_morado_uno
            2 -> R.drawable.dado_morado_dos
            3 -> R.drawable.dado_morado_tres
            4 -> R.drawable.dado_morado_cuatro
            5 -> R.drawable.dado_morado_cinco
            else -> R.drawable.dado_morado_seis
        } //END val drawableResource2 = when (die2Roll)

        //Display the image
        diceImage2.setImageResource(drawableResource2)
        //Set the image description so app is accessibility friendly
        diceImage2.contentDescription = die2Roll.toString()
        //END Die 2

        //Die 3
        //use Dice object private function to "roll" die (random number generated)
        val die3Roll = dice.roll()

        //grab the 3rd ImageView
        val diceImage3: ImageView = findViewById(R.id.imageView3)

        //Select the correct image for the number rolled
        val drawableResource3 = when (die3Roll) {
            1 -> R.drawable.dado_azul_uno
            2 -> R.drawable.dado_azul_dos
            3 -> R.drawable.dado_azul_tres
            4 -> R.drawable.dado_azul_cuatro
            5 -> R.drawable.dado_azul_cinco
            else -> R.drawable.dado_azul_seis
        } //END when (diceImage)

        //Display the image
        diceImage3.setImageResource(drawableResource3)
        //Set the image description so app is accessibility friendly
        diceImage3.contentDescription = die3Roll.toString()
        //END Die 3
//Display the sum of the rolled dice
        val rollTotal = (die1Roll+die2Roll+die3Roll).toString()
        val sum: TextView = findViewById(R.id.rollTotalView)
        sum.text=rollTotal
    } // END private fun rollDice()

} //END class MainActivity : AppCompatActivity()

/**
 * This class generates a random integer between 1 and the value passed in through numSides, then
 * returns that number.
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()

    } //END fun roll(): Int
} //END class Dice (val numSides: Int)