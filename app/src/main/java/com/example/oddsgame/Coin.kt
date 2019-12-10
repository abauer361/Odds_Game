package com.example.oddsgame

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.util.Random

class Coin : MenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin)

        val button = findViewById<Button>(R.id.btnFlip)
        val imageView = findViewById<ImageView>(R.id.coin)
        val random = Random()
        var mp: MediaPlayer? = MediaPlayer.create(this, R.raw.coinflip)

        button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                val side = random.nextInt(2)

                if (side == 0){
                    imageView.setImageResource(R.drawable.heads)
                    Toast.makeText(applicationContext, "You Flipped the Coin to Heads!", Toast.LENGTH_SHORT).show()
                }
                else if (side == 1){
                    imageView.setImageResource(R.drawable.tails)
                    Toast.makeText(applicationContext,"You Flipped the Coin to Tails!", Toast.LENGTH_SHORT).show()
                }

                // rotation
                var rotate = RotateAnimation(0f, 360f, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f)
                mp?.start()

                rotate.duration = 1000

                imageView.startAnimation(rotate)
            }
        })
    }
}
