package net.loosash.learnanimatior

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.loosash.learnanimatior.property.PropertyActivity
import net.loosash.learnanimatior.tween.TweenActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_tween.setOnClickListener {
            val intent = Intent(this, TweenActivity::class.java)
            startActivity(intent)
        }

        btn_property.setOnClickListener {
            val intent = Intent(this, PropertyActivity::class.java)
            startActivity(intent)
        }
    }
}
