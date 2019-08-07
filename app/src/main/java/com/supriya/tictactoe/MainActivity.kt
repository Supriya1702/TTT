package com.supriya.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var b1:ImageButton
    lateinit var  b2: ImageButton
    lateinit var b3: ImageButton
    lateinit var b4: ImageButton
    lateinit var b5: ImageButton
    lateinit var b6: ImageButton
    lateinit var b7: ImageButton
    lateinit var b8: ImageButton
    lateinit var b9: ImageButton
    lateinit var restart: Button
    lateinit var initBtn: ImageButton
    lateinit var tV: TextView


    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var winner = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1 = findViewById(R.id.btn1)
        b2 = findViewById(R.id.btn2)
        b3 = findViewById(R.id.btn3)
        b4 = findViewById(R.id.btn4)
        b5 = findViewById(R.id.btn5)
        b6 = findViewById(R.id.btn6)
        b7 = findViewById(R.id.btn7)
        b8 = findViewById(R.id.btn8)
        b9 = findViewById(R.id.btn9)
//        restart = findViewById(R.id.restartBtn)

        tV = findViewById(R.id.textView)

        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)
        b4.setOnClickListener(this)

        b5.setOnClickListener(this)
        b6.setOnClickListener(this)
        b7.setOnClickListener(this)
        b8.setOnClickListener(this)
        b9.setOnClickListener(this)
        //restart.setOnClickListener(this)
    }

    fun restartClick(view: View) {

          b1.setImageResource(android.R.color.transparent)
        b2.setImageResource(android.R.color.transparent)
        b3.setImageResource(android.R.color.transparent)
        b4.setImageResource(android.R.color.transparent)
        b5.setImageResource(android.R.color.transparent)
        b6.setImageResource(android.R.color.transparent)
        b7.setImageResource(android.R.color.transparent)
        b8.setImageResource(android.R.color.transparent)
        b9.setImageResource(android.R.color.transparent)
        tV.text = ""




        b1.isEnabled = true
        b2.isEnabled = true
        b3.isEnabled = true
        b4.isEnabled = true
        b5.isEnabled = true
        b6.isEnabled = true
        b7.isEnabled = true
        b8.isEnabled = true
        b9.isEnabled = true

        player1.clear()
        player2.clear()
        activePlayer = 1
        winner = -1


    }


    override fun onClick(view: View) {


       lateinit var buSelected:ImageButton
        var cellID = 0

        if (view.id == R.id.btn1) {
            cellID = 1
            buSelected = b1

        }
        if (view.id == R.id.btn2) {
            cellID = 2
            buSelected = b2
        }
        if (view.id == R.id.btn3) {
            cellID = 3
            buSelected = b3

        }
        if (view.id == R.id.btn4) {
            cellID = 4
            buSelected = b4
        }
        if (view.id == R.id.btn5) {
            cellID = 5
            buSelected = b5
        }
        if (view.id == R.id.btn6) {
            cellID = 6
            buSelected = b6
        }
        if (view.id == R.id.btn7) {
            cellID = 7
            buSelected = b7
        }
        if (view.id == R.id.btn8) {
            cellID = 8
            buSelected = b8
        }
        if (view.id == R.id.btn9) {
            cellID = 9
            buSelected = b9
        }

        playGame(cellID, buSelected)


    }

    fun playGame(cellID: Int, buSelected: ImageButton?) {
        if (activePlayer == 1) {
            buSelected!!.setImageResource(R.drawable.x48)
            player1.add(cellID)
            activePlayer = 2
        } else if (activePlayer == 2) {
            buSelected!!.setImageResource(R.drawable.o48)
            player2.add(cellID)
            activePlayer = 1
        }
        //buSelected.isEnabled(false);
        buSelected!!.isEnabled = false
        checkWinner()

    }

    fun checkWinner() {


        //rows
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1

        } else if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        } else if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        } else if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        } else if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        } else if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        } else if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        } else if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        } else if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        } else if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        } else if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        } else if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        } else if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        } else if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        } else if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        } else if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }//diagonals
        //columns

        if (winner == -1 && b1.isEnabled == false && b2.isEnabled == false && b3.isEnabled == false && b4.isEnabled == false && b5.isEnabled == false && b6.isEnabled == false && b7.isEnabled == false && b8.isEnabled == false && b9.isEnabled == false) {
            tV.text="GAME IS TIE"
        }



        if (winner != -1) {
            if (winner == 1) {
                tV.text = "player 1 has won!"
                disableImgBtn()

            }
            if (winner == 2) {
                tV.text = "player 2 has won!"
                disableImgBtn()
            }
        }

    }

    private fun disableImgBtn() {
        b1.isEnabled = false
        b2.isEnabled = false
        b3.isEnabled = false
        b4.isEnabled = false
        b5.isEnabled = false
        b6.isEnabled = false
        b7.isEnabled = false
        b8.isEnabled = false
        b9.isEnabled = false


    }
}
