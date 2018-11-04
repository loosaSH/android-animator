package net.loosash.learnanimatior.property

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_tween_translate.*
import net.loosash.learnanimatior.R


class PropertyTranslateActivity : AppCompatActivity() {

    val tag = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_translate)

        image.setOnClickListener {
            Log.e(tag,"点击了image")
        }


//        val valueAnimatorOfFloat1 = ValueAnimator.ofFloat(image.x,500f)
//        val valueAnimatorOfFloat2 = ValueAnimator.ofFloat(image.y,1000f)
//
//        valueAnimatorOfFloat1.addUpdateListener { animator ->
//            val currentValue = animator.animatedValue as Float
//            image.x = currentValue
//            // 获得每次变化后的属性值
//            Log.e(tag,"currentValue:$currentValue")
//        }
//
//        valueAnimatorOfFloat2.addUpdateListener { animator ->
//            val currentValue = animator.animatedValue as Float
//            image.y = currentValue
//            // 获得每次变化后的属性值
//            Log.e(tag,"currentValue:$currentValue")
//        }



        val objectAnimator1 = ObjectAnimator.ofFloat(image,"translationX",image.x,500f)
        val objectAnimator2 = ObjectAnimator.ofFloat(image,"translationY",image.y,1000f)


        val animatorSet = AnimatorSet()
        animatorSet.duration = 2000
        animatorSet.play(objectAnimator1).with(objectAnimator2)
        animatorSet.start()



//        val valueAnimatorOfObject = ValueAnimator.ofObject(PositionEvaluator(),Position(image.x,image.y),Position(500f,1000f))
//        valueAnimatorOfObject.duration = 2000
//
//        valueAnimatorOfObject.addUpdateListener { animator ->
//            image.x = (animator.animatedValue as Position).x
//            image.y = (animator.animatedValue as Position).y
//        }
//        valueAnimatorOfObject.start()




    }


    class PositionEvaluator : TypeEvaluator<Position> {

        override fun evaluate(fraction: Float, startValue: Position, endValue: Position): Position {
            val x = startValue.x + fraction * (endValue.x - startValue.x)
            val y = startValue.y + fraction * (endValue.y - startValue.y)
            return Position(x, y)
        }
    }


    class Position(x: Float, y: Float) {
        val x = x
        val y = y
    }

}
