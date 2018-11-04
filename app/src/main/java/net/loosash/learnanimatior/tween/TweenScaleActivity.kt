package net.loosash.learnanimatior.tween

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import net.loosash.learnanimatior.R

class TweenScaleActivity : AppCompatActivity() {
    val tag = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tween_scale)

//        val scaleAnimation = AnimationUtils.loadAnimation(this,R.anim.animation_tween_scale)
////        val scaleAnimation = ScaleAnimation(0f,3f,0f,3f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
////        scaleAnimation.duration = 2000
////        scaleAnimation.fillAfter = true
//
//        image.startAnimation(scaleAnimation)
//        image.setOnClickListener {
//            Log.e(tag,"点击了image")
//        }

    }
}
