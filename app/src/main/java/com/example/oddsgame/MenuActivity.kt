package com.example.oddsgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

open class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    //https://android--code.blogspot.com/2018/02/android-kotlin-menu-and.html
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.our_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.coin -> {
                Toast.makeText(this, "Coin Selected", Toast.LENGTH_SHORT).show()
                openCoin()
                return true
            }
            R.id.rng -> {
                Toast.makeText(this, "RNG Selected", Toast.LENGTH_SHORT).show()
                openRNG()
                return true
            }
            R.id.dice -> {
                Toast.makeText(this, "Dice Selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.four -> {
                Toast.makeText(this, "4 Sided Dice Selected", Toast.LENGTH_SHORT).show()
                openDice(4)
                return true
            }
            R.id.six -> {
                Toast.makeText(this, "6 Sided Dice Selected", Toast.LENGTH_SHORT).show()
                openDice(6)
                return true
            }
            R.id.eight -> {
                Toast.makeText(this, "8 Sided Dice Selected", Toast.LENGTH_SHORT).show()
                openDice(8)
                return true
            }
            R.id.ten -> {
                Toast.makeText(this, "10 Sided Dice Selected", Toast.LENGTH_SHORT).show()
                openDice(10)
                return true
            }
            R.id.twenty -> {
                Toast.makeText(this, "20 Sided Dice Selected", Toast.LENGTH_SHORT).show()
                openDice(20)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }


    fun openCoin() {
        startActivity(Intent(this, Coin::class.java))
    }

    fun openRNG() {
        startActivity(Intent(this, RNG::class.java))
    }

    fun openDice(sides: Int) {
        startActivity(Intent(this, Dice::class.java).apply { putExtra("sides",sides) })
    }
}
