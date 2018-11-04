package net.loosash.learnanimatior.property

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_property.*
import net.loosash.learnanimatior.R

class PropertyActivity : AppCompatActivity() {

    val tag = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property)

        btn_property_translate.setOnClickListener {
            val intent = Intent(this,PropertyTranslateActivity::class.java)
            startActivity(intent)
        }

//        val objectAnimator = ObjectAnimator.ofFloat(image,"alpha",1f, 0f, 1f)
//        objectAnimator.duration = 3000
//        objectAnimator.start()




    }
}
