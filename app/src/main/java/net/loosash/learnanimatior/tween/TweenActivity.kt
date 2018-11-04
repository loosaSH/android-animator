package net.loosash.learnanimatior.tween

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tween.*
import net.loosash.learnanimatior.R

class TweenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tween)

        btn_tween_translate.setOnClickListener {
            val intent = Intent(this, TweenTranslateActivity::class.java)
            startActivity(intent)
        }

        btn_tween_scale.setOnClickListener {
            val intent = Intent(this, TweenScaleActivity::class.java)
            startActivity(intent)
        }

        btn_tween_rotate.setOnClickListener {
            val intent = Intent(this, TweenRotateActivity::class.java)
            startActivity(intent)
        }

        btn_tween_alpha.setOnClickListener {
            val intent = Intent(this, TweenAlphaActivity::class.java)
            startActivity(intent)
        }

        btn_tween_set.setOnClickListener {
            val intent = Intent(this, TweenSetActivity::class.java)
            startActivity(intent)
        }
    }

}
