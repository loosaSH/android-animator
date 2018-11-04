# Android中的动画
## 一、逐帧动画
就是我们生活中常见的动画方式，以一帧一帧的方式展示出来。使用简单，但是容易引起 OOM，这里不做细讲。既然要做复杂动画，可以考虑使用Lottie框架来实现。
## 二、补间动画
补间动画顾名思义就是android系统帮助填补动画前和动画后期间的轨迹，有四种：

- 平移动画(translate)
- 缩放动画(scale)
- 旋转动画(rotate)
- 透明度动画(alpha)

可以使用xml中定义，以及java代码中设置。<br>

### 平移动画
animation_translate.xml<br>

```
<?xml version="1.0" encoding="utf-8"?>
<translate xmlns:android="http://schemas.android.com/apk/res/android"
    android:fromXDelta="0"
    android:toXDelta="500"
    android:fromYDelta="0"
    android:toYDelta="1000"

    android:duration="2000"
    android:fillAfter = "true" />
```
TweenTranslateActivity.class<br>

```
        val translateAnimation = AnimationUtils.loadAnimation(this,R.anim.animation_translate)
//        val translateAnimation = TranslateAnimation(0f,500f,0f,1000f)
//        translateAnimation.duration = 2000
//        translateAnimation.fillAfter = true

        image.startAnimation(translateAnimation)
        image.setOnClickListener {
            Log.e(tag,"点击了image")
        }
```
即可实现image的显示从(0,0)到(500,1000)的平移并停留在结束位置，需要注意的是，该动画并不能让view真实的移动，通过对image增加点击事件可以证明，点击image的开始位置会有响应而结束的位置没有。<br>
### 缩放动画
使用xml设置:<br>

animation_tween_scale.xml<br>

```
<?xml version="1.0" encoding="utf-8"?>
<scale xmlns:android="http://schemas.android.com/apk/res/android"
    android:fromXScale="0"
    android:toXScale="3"
    android:fromYScale="0"
    android:toYScale="3"
    android:pivotX="50%"
    android:pivotY="50%"

    android:duration="2000"
    android:fillAfter = "true" />
```
TweenScaleActivity.class<br>

```
        val scaleAnimation = AnimationUtils.loadAnimation(this,R.anim.animation_tween_scale)
//        val scaleAnimation = ScaleAnimation(0f,3f,0f,3f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
//        scaleAnimation.duration = 2000
//        scaleAnimation.fillAfter = true

        image.startAnimation(scaleAnimation)
        image.setOnClickListener {
            Log.e(tag,"点击了image")
        }
```
即可实现从image从中心点放大3倍的效果，同样image没有移动，仅存在最初的位置。
### 旋转动画
使用xml设置:<br>

animation_tween_rotate.xml<br>

```
<?xml version="1.0" encoding="utf-8"?>
<rotate xmlns:android="http://schemas.android.com/apk/res/android"

    android:fromDegrees="0"
    android:toDegrees="270"
    android:pivotX="50%"
    android:pivotY="50%"

    android:duration="2000"
    android:fillAfter = "true" />
```
TweenRotateActivity.class<br>

```
        val rotateAnimation = AnimationUtils.loadAnimation(this,R.anim.animation_tween_rotate)
//        val rotateAnimation = RotateAnimation(0f,270f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
//        rotateAnimation.duration = 2000
//        rotateAnimation.fillAfter = true

        image.startAnimation(rotateAnimation)
        image.setOnClickListener {
            Log.e(tag,"点击了image")
        }
```
即可实现从image从中心点旋转270度，同样image没有移动，仅存在最初的位置。
### 透明度动画
使用xml设置:<br>

animation_tween_alpha.xml<br>

```
<?xml version="1.0" encoding="utf-8"?>
<alpha xmlns:android="http://schemas.android.com/apk/res/android"

    android:fromAlpha="1.0"
    android:toAlpha="0.2"

    android:duration="2000"
    android:fillAfter = "true" />
```
TweenAlphaActivity.class<br>

```
        val alphaAnimation = AnimationUtils.loadAnimation(this,R.anim.animation_tween_alpha)
//        val alphaAnimation = AlphaAnimation(1f,0.2f)
//        alphaAnimation.duration = 2000
//        alphaAnimation.fillAfter = true

        image.startAnimation(alphaAnimation)
        image.setOnClickListener {
            Log.e(tag,"点击了image")
        }
```
即可实现从image从透明度1.0变为0.2，即使变为透明度0.0，同样image还在原位，与View.Gone不同。
### 组合使用
使用xml设置:<br>

animation_tween_set.xml<br>

```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:fillAfter = "true"
    android:duration="2000">

    <alpha
        android:fromAlpha="1.0"
        android:toAlpha="0.2"

        android:duration="2000"
        android:fillAfter = "true" />

    <rotate
        android:fromDegrees="0"
        android:toDegrees="270"
        android:pivotX="50%"
        android:pivotY="50%"

        android:duration="2000"
        android:fillAfter = "true" />
    
    <scale
        android:fromXScale="0"
        android:toXScale="3"
        android:fromYScale="0"
        android:toYScale="3"
        android:pivotX="50%"
        android:pivotY="50%"

        android:duration="2000"
        android:fillAfter = "true" />

    <translate
        android:fromXDelta="0"
        android:toXDelta="500"
        android:fromYDelta="0"
        android:toYDelta="1000"

        android:duration="2000"
        android:fillAfter = "true" />
    
</set>
```
TweenSetActivity.class<br>

```
        val tweenSetAnimation = AnimationUtils.loadAnimation(this,R.anim.animation_tween_set)
//        val tweenSetAnimation = AnimationSet(true)
//        tweenSetAnimation.fillAfter = true
//        tweenSetAnimation.duration = 2000
//
//        val alphaAnimation = AlphaAnimation(1f, 0.2f)
//        alphaAnimation.duration = 2000
//        alphaAnimation.fillAfter = true
//
//        val rotateAnimation = RotateAnimation(0f, 270f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
//        rotateAnimation.duration = 2000
//        rotateAnimation.fillAfter = true
//
//        val scaleAnimation = ScaleAnimation(0f, 3f, 0f, 3f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
//        scaleAnimation.duration = 2000
//        scaleAnimation.fillAfter = true
//
//        val translateAnimation = TranslateAnimation(0f, 500f, 0f, 1000f)
//        translateAnimation.duration = 2000
//        translateAnimation.fillAfter = true
//
//        tweenSetAnimation.addAnimation(alphaAnimation)
//        tweenSetAnimation.addAnimation(rotateAnimation)
//        tweenSetAnimation.addAnimation(scaleAnimation)
//        tweenSetAnimation.addAnimation(translateAnimation)

        image.startAnimation(tweenSetAnimation)
        image.setOnClickListener {
            Log.e(tag, "点击了image")
        }
```
组合使用就是将上面的四个动画组合起来使用。
### 公共属性介绍
>
android:duration="3000" // 动画持续时间（ms），必须设置，动画才有效果<br>
android:startOffset ="1000" // 动画延迟开始时间（ms）<br>
android:fillBefore = “true” // 动画播放完后，视图是否会停留在动画开始的状态，默认为true<br>
android:fillAfter = “false” // 动画播放完后，视图是否会停留在动画结束的状态，优先于fillBefore值，默认为false<br>
android:fillEnabled= “true” // 是否应用fillBefore值，对fillAfter值无影响，默认为true<br>
android:repeatMode= “restart” // 选择重复播放动画模式，restart代表正序重放，reverse代表倒序回放，默认为restart<br>
android:repeatCount = “0” // 重放次数（所以动画的播放次数=重放次数+1），为infinite时无限重复<br>
android:interpolator = @[package:]anim/interpolator_resource // 插值器<br>

### 监听动画
使用AnimationListener对动画进行监听,实现自己需求<br>
TweenSetActivity.class<br>

```
        tweenSetAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {

            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })
```
## 三、属性动画
上面也提到了，补间动画`Animation`无法实现对view的属性变换，虽然界面上的view移动了，view的实际位置还是在最初的位置，在Android 3.0后系统提供了属性动画`Animator`供开发者使用。<br>
属性动画是对对象属性做改变，并且不局限于view可以是任意object。<br>
### 实现平移动画
属性动画是对属性进行操作，最好动态在代码中处理，以动态获取开始属性，虽然也可是使用xml实现属性动画，但不建议使用。下面仅给出kotlin示例:<br>

```
        val valueAnimatorOfFloat1 = ValueAnimator.ofFloat(image.x,500f)
        val valueAnimatorOfFloat2 = ValueAnimator.ofFloat(image.y,1000f)
        
        valueAnimatorOfFloat1.addUpdateListener { animator ->
            val currentValue = animator.animatedValue as Float
            image.x = currentValue
            // 获得每次变化后的属性值
            Log.e(tag,"currentValue:$currentValue")
        }

        valueAnimatorOfFloat2.addUpdateListener { animator ->
            val currentValue = animator.animatedValue as Float
            image.y = currentValue
            // 获得每次变化后的属性值
            Log.e(tag,"currentValue:$currentValue")
        }

        val animatorSet = AnimatorSet()
        animatorSet.duration = 2000
        animatorSet.play(valueAnimatorOfFloat1).with(valueAnimatorOfFloat2)
        animatorSet.start()
```
我们自己监听了`ValueAnimator`，实现了image的属性变化。其实android为开发者提供了动画相关的类`ObjectAnimator`,来简化代码。<br>

```
        val objectAnimator1 = ObjectAnimator.ofFloat(image,"translationX",image.x,500f)
        val objectAnimator2 = ObjectAnimator.ofFloat(image,"translationY",image.y,1000f)

        val animatorSet = AnimatorSet()
        animatorSet.duration = 2000
        animatorSet.play(objectAnimator1).with(objectAnimator2)
        animatorSet.start()
```


以上便可以实现上面补间动画的效果，但是定义了两个`Animator`，比较复杂，我们使用`ValueAnimator.ofObject`来处理两个属性的变化。<br>
定义一个位置信息的类`Position`<br>

```
    class Position(x: Float, y: Float) {
        val x = x
        val y = y
    }
```

自定义一个估值器`PositionEvaluator`<br>

```
    class PositionEvaluator : TypeEvaluator<Position> {

        override fun evaluate(fraction: Float, startValue: Position, endValue: Position): Position {
            val x = startValue.x + fraction * (endValue.x - startValue.x)
            val y = startValue.y + fraction * (endValue.y - startValue.y)
            return Position(x, y)
        }
    }
```
PropertyTranslateActivity.class<br>

```
        val valueAnimatorOfObject = ValueAnimator.ofObject(PositionEvaluator(),Position(image.x,image.y),Position(500f,1000f))
        valueAnimatorOfObject.duration = 2000

        valueAnimatorOfObject.addUpdateListener { animator ->
            image.x = (animator.animatedValue as Position).x
            image.y = (animator.animatedValue as Position).y
        }
        valueAnimatorOfObject.start()
```
上面就是用了三种方法处理平移动画。通过点击事件监听可以证明，view跟随动画一起移动，在view的移动过程中，点击view有响应，而不是在最开始的位置才有响应。

### 实现缩放动画
与平移动画实现类似，使用`ScaleX`,`ScaleY`<br>

```
	val objectAnimator1 = ObjectAnimator.ofFloat(image,"ScaleX",1f,3f)
	val objectAnimator2 = ObjectAnimator.ofFloat(image,"ScaleY",1f,3f)
		...

```
### 实现旋转动画
同理,使用`Rotation`<br>

```
	val objectAnimator = ObjectAnimator.ofFloat(image,"Rotation",0f,360f)
	...
```
### 实现透明度动画
同理,使用`Alpha`<br>

```
	val objectAnimator = ObjectAnimator.ofFloat(image,"Alpha",1.0f,0f)
	...
```
### ObjectAnimator可以使用的属性

属性  | 作用 | 数值类型
--------- |--------- |---------
Alpha | 控制View的透明度| float
TranslationX	 | 控制X方向的位移	| float
TranslationY | 控制Y方向的位移| float
ScaleX | 控制X方向的缩放倍数| float
ScaleY | 控制Y方向的缩放倍数| float
Rotation | 控制以屏幕方向为轴的旋转度数| float
RotationX | 控制以X轴为轴的旋转度数| float
RotationY | 控制以Y轴为轴的旋转度数| float

### 总结
至此，属性动画的相关用法已经介绍完成了，但还存在着一些问题，比如`ObjectAnimator`可以使用的属性为什么就是上面的那些，如何自定义。我们在自定义view中再详细说明定义属性动画定义。


















