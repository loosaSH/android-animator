package net.loosash.learnanimatior.tween

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_tween_translate.*
import net.loosash.learnanimatior.R

class TweenTranslateActivity : AppCompatActivity() {

    val tag = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tween_translate)
        val translateAnimation = AnimationUtils.loadAnimation(this,R.anim.animation_translate)
//        val translateAnimation = TranslateAnimation(0f,500f,0f,1000f)
//        translateAnimation.duration = 2000
//        translateAnimation.fillAfter = true

        image.startAnimation(translateAnimation)
        image.setOnClickListener {
            Log.e(tag,"点击了image")
        }

    }
}
