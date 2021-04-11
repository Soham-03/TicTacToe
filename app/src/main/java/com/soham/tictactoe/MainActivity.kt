package com.soham.tictactoe

import android.graphics.Typeface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.awesomedialog.*

class MainActivity : AppCompatActivity() {
    lateinit var button0:ImageView
    lateinit var button1:ImageView
    lateinit var button2:ImageView
    lateinit var button3:ImageView
    lateinit var button4:ImageView
    lateinit var button5:ImageView
    lateinit var button6:ImageView
    lateinit var button7:ImageView
    lateinit var button8:ImageView
    lateinit var buttonBottomLeft: ImageView
    lateinit var op:ImageView
    lateinit var buttonBottomRight: ImageView
    var flag: Int = 0
    var activePlayer = 0 // o = X and 1 = O
    var gameState = 2
    var winConditions = arrayOf(arrayOf(0,1,2))
    var winCheck = arrayOf(2,2,2,2,2,2,2,2,2)
    var count  = 0
    var loss = true
    lateinit var player1Name: String
    lateinit var player2Name: String
    lateinit var winnerMp: MediaPlayer
    lateinit var drawMp: MediaPlayer
    lateinit var tapXMp: MediaPlayer
    lateinit var tapYMP: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flag = 1


        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
//        buttonBottomLeft = findViewById(R.id.buttonBottomLeft)
//        buttonBottomRight = findViewById(R.id.buttonBottomRight)

        val intent = intent
        player1Name = intent.getStringExtra("player1")!!
        player2Name = intent.getStringExtra("player2")!!

        winnerMp = MediaPlayer.create(this,R.raw.winner)
        drawMp = MediaPlayer.create(this,R.raw.draw)
        tapXMp = MediaPlayer.create(this,R.raw.tap)
        tapYMP = MediaPlayer.create(this,R.raw.tap)

        button0.setOnClickListener {
            TapCheck(button0,0)
        }

        button1.setOnClickListener {
            TapCheck(button1,1)
        }

        button2.setOnClickListener {
            TapCheck(button2,2)
        }

        button3.setOnClickListener {
            TapCheck(button3,3)
        }

        button4.setOnClickListener {
            TapCheck(button4,4)
        }

        button5.setOnClickListener {
            TapCheck(button5,5)
        }

        button6.setOnClickListener {
            TapCheck(button6,6)
        }

        button7.setOnClickListener {
            TapCheck(button7,7)
        }

        button8.setOnClickListener {
            TapCheck(button8,8)
        }
    }

    fun TapCheck(button:ImageView,i:Int){
        if(gameState == 2){
            if(activePlayer == 0){
                var resourceId = resources.getIdentifier("ic_button${i}_x","drawable",packageName)
                button.setImageResource(resourceId)
                activePlayer = 1
                winCheck[i] = 1
                count++
                tapXMp.start()
                button.isClickable = false
            }
            else{
                var resourceId = resources.getIdentifier("ic_button${i}_o","drawable",packageName)
                button.setImageResource(resourceId)
                activePlayer = 0
                winCheck[i] = 3
                count++
                tapYMP.start()
                button.isClickable = false
            }
        }
        checkWin(button)
        if(count == 9){
            drawMp.start()
            Toast.makeText(this,"Its a Draw",Toast.LENGTH_SHORT).show()
            val dialog = AwesomeDialog.build(this)
                .title(
                    "Draw", Typeface.DEFAULT_BOLD
                ).body("Both Players Played well", Typeface.DEFAULT_BOLD)
                .icon(R.drawable.trophy)
                .background(R.drawable.dialogue_gradient)
                .onPositive("Replay",R.drawable.replay_button_background,R.color.purple_200,
                    { recreate() })
                .onNegative("Quit",R.drawable.quit_button_background,R.color.red,
                    {finish()})
                .position(AwesomeDialog.POSITIONS.CENTER)
            dialog.show()
        }
    }

    fun checkWin(button:ImageView){
        if((winCheck[0]==1 && winCheck[1]==1 && winCheck[2]==1) ||
                (winCheck[3]==1 && winCheck[4]==1 && winCheck[5]==1) ||
                (winCheck[6]==1 && winCheck[7]==1 && winCheck[8]==1) ||
                (winCheck[0]==1 && winCheck[4]==1 && winCheck[8]==1) ||
                (winCheck[2]==1 && winCheck[4]==1 && winCheck[6]==1) ||
                (winCheck[0]==1 && winCheck[3]==1 && winCheck[6]==1) ||
                (winCheck[1]==1 && winCheck[4]==1 && winCheck[7]==1) ||
                (winCheck[2]==1 && winCheck[5]==1 && winCheck[8]==1)){
                    winnerMp.start()

            val dialog = AwesomeDialog.build(this)
                .title(
                    "$player1Name",Typeface.DEFAULT_BOLD
                ).body("Is the Winner!", Typeface.DEFAULT_BOLD)
                .icon(R.drawable.trophy)
                .background(R.drawable.dialogue_gradient)
                .onPositive("Replay",R.drawable.replay_button_background,R.color.purple_200,
                    { recreate() })
                .onNegative("Quit",R.drawable.quit_button_background,R.color.red,
                    {finish()})
                .position(AwesomeDialog.POSITIONS.CENTER)
            dialog.show()

            Toast.makeText(this,"Congratulations",Toast.LENGTH_SHORT).show()

        }
        if((winCheck[0]==3 && winCheck[1]==3 && winCheck[2]==3) ||
                (winCheck[3]==3 && winCheck[4]==3 && winCheck[5]==3) ||
                (winCheck[6]==3 && winCheck[7]==3 && winCheck[8]==3) ||
                (winCheck[0]==3 && winCheck[4]==3 && winCheck[8]==3) ||
                (winCheck[2]==3 && winCheck[4]==3 && winCheck[6]==3) ||
                (winCheck[0]==3 && winCheck[3]==3 && winCheck[6]==3) ||
                (winCheck[1]==3 && winCheck[4]==3 && winCheck[7]==3) ||
                (winCheck[2]==3 && winCheck[5]==3 && winCheck[8]==3)){
                    winnerMp.start()

            val dialog = AwesomeDialog.build(this)
                .title(
                    "$player2Name", Typeface.DEFAULT_BOLD,
                ).body("Is the Winner!", Typeface.DEFAULT_BOLD)
                .icon(R.drawable.trophy)
                .background(R.drawable.dialogue_gradient)
                .onPositive("Replay",R.drawable.replay_button_background,R.color.purple_200,
                    { recreate() })
                .onNegative("Quit",R.drawable.quit_button_background,R.color.red,
                    {finish()})
                .position(AwesomeDialog.POSITIONS.CENTER)
            dialog.show()

            Toast.makeText(this,"Congratulations",Toast.LENGTH_SHORT).show()

        }
    }
}