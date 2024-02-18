package com.example.gamesuit

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    lateinit var computerImageView: ImageView
    lateinit var batuImageView: ImageView
    lateinit var guntingImageView: ImageView
    lateinit var kertasImageView: ImageView
    lateinit var hasilImageView: ImageView

    private fun initComponens(){
        computerImageView = findViewById(R.id.computerImageView)
        batuImageView = findViewById(R.id.batuImageButton)
        guntingImageView = findViewById(R.id.guntingImageButton)
        kertasImageView = findViewById(R.id.kertasImageButton)
        hasilImageView = findViewById(R.id.hasilImageView)
    }

    private fun initListener(){
        batuImageView.setOnClickListener { mulaiGame("BATU") }
        guntingImageView.setOnClickListener { mulaiGame("GUNTING") }
        kertasImageView.setOnClickListener { mulaiGame("KERTAS") }
    }

    private fun mulaiGame(option: String){
        val computerOption = Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))

        when{
            Game.isDraw(option, computerOption) -> hasilImageView.setImageResource(R.drawable.draw)
            Game.isWin(option, computerOption) -> hasilImageView.setImageResource(R.drawable.win)
            else -> hasilImageView.setImageResource(R.drawable.lose)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponens()
        initListener()
    }

}