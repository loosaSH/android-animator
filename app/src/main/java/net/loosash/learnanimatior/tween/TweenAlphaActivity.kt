package net.loosash.learnanimatior.tween

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_tween_scale.*
import net.loosash.learnanimatior.R

class TweenAlphaActivity : AppCompatActivity() {

    val tag = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tween_alpha)

        val alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_tween_alpha)
//        val alphaAnimation = AlphaAnimation(1f,0.2f)
//        alphaAnimation.duration = 2000
//        alphaAnimation.fillAfter = true

        image.startAnimation(alphaAnimation)
        image.setOnClickListener {
            Log.e(tag, "点击了image")
        }



    }
}
