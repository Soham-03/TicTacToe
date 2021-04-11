package com.soham.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDialog
import java.lang.Appendable

class launch_activity : AppCompatActivity() {
    lateinit var player1Name: EditText
    lateinit var player2Name: EditText
    lateinit var start: Button
    lateinit var exit: Button
    lateinit var op:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_activity)

        player1Name = findViewById(R.id.player1Name)
        player2Name = findViewById(R.id.player2Name)
        start = findViewById(R.id.startButton)
        exit =findViewById(R.id.exitButton)

        start.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            var player1 = player1Name.text.toString()
            var player2 = player2Name.text.toString()
            intent.putExtra("player1",player1)
            intent.putExtra("player2",player2)
            println(player1)
            println(player2)
            this.startActivity(intent)
            var one: Editable? = null
            player1Name.text = one
            player2Name.text = one
            player1Name.clearFocus()
            player2Name.clearFocus()
        }
        exit.setOnClickListener {
            finish()
        }
    }
}