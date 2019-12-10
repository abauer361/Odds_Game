package com.example.oddsgame

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dice.*

class Dice : MenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)

        var mp: MediaPlayer? = MediaPlayer.create(this, R.raw.dice_roll)
        var sides = intent.extras?.get("sides").toString().toInt()
        var dice_image: ImageView
        dice_image = four_dice

        when (sides){
            4 -> {
                dice_image = four_dice
            }
            6 -> {
                dice_image = six_dice
            }
            8 -> {
                dice_image = eight_dice
            }
            10 -> {
                dice_image = ten_dice
            }
            20 -> {
                dice_image = twenty_dice
            }
        }
        dice_image.setVisibility(View.VISIBLE)

        roll_button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                val roll = (1 until (sides + 1)).random()

                Toast.makeText(applicationContext,"You Rolled a " + roll + "!", Toast.LENGTH_SHORT).show()

                mp?.start()
                var rotate = RotateAnimation(0f, 180f, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f)
                rotate.duration = 5000
                dice_image.startAnimation(rotate)

                rotate = RotateAnimation(0f, 180f, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f)
                dice_image.startAnimation(rotate)
            }
        })
    }
}
