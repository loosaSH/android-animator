package net.loosash.learnanimatior.tween

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.animation.*
import kotlinx.android.synthetic.main.activity_tween_set.*
import net.loosash.learnanimatior.R

class TweenSetActivity : AppCompatActivity() {

    val tag = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tween_set)

//        val tweenSetAnimation = AnimationUtils.loadAnimation(this,R.anim.animation_tween_set)
        val tweenSetAnimation = AnimationSet(true)
        tweenSetAnimation.fillAfter = true
        tweenSetAnimation.duration = 2000

        val alphaAnimation = AlphaAnimation(1f, 0.2f)
        alphaAnimation.duration = 2000
        alphaAnimation.fillAfter = true

        val rotateAnimation = RotateAnimation(0f, 270f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        rotateAnimation.duration = 2000
        rotateAnimation.fillAfter = true

        val scaleAnimation = ScaleAnimation(0f, 3f, 0f, 3f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        scaleAnimation.duration = 2000
        scaleAnimation.fillAfter = true

        val translateAnimation = TranslateAnimation(0f, 500f, 0f, 1000f)
        translateAnimation.duration = 2000
        translateAnimation.fillAfter = true

        tweenSetAnimation.addAnimation(alphaAnimation)
        tweenSetAnimation.addAnimation(rotateAnimation)
        tweenSetAnimation.addAnimation(scaleAnimation)
        tweenSetAnimation.addAnimation(translateAnimation)

        image.startAnimation(tweenSetAnimation)
        image.setOnClickListener {
            Log.e(tag, "点击了image")
        }

        tweenSetAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {

            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })
    }
}
