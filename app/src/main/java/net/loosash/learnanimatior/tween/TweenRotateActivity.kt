package net.loosash.learnanimatior.tween

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_tween_scale.*
import net.loosash.learnanimatior.R

class TweenRotateActivity : AppCompatActivity() {

    val tag = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tween_rotate)

        val rotateAnimation = AnimationUtils.loadAnimation(this,R.anim.animation_tween_rotate)
//        val rotateAnimation = RotateAnimation(0f,270f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
//        rotateAnimation.duration = 2000
//        rotateAnimation.fillAfter = true

        image.startAnimation(rotateAnimation)
        image.setOnClickListener {
            Log.e(tag,"点击了image")
        }
    }
}
