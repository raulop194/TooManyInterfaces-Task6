package es.nexcreep.testing.toomanyinterfaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.Objects

class MainActivity : AppCompatActivity() {
    private lateinit var layoutBtns: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layouts = listOf<Class<*>>(
            Layout1::class.java,
            Layout2::class.java,
            Layout3::class.java,
            Layout4::class.java,
            Layout5::class.java,
            Layout6::class.java
        )

        layoutBtns = listOf(
            findViewById(R.id.layout1_btn),
            findViewById(R.id.layout2_btn),
            findViewById(R.id.layout3_btn),
            findViewById(R.id.layout4_btn),
            findViewById(R.id.layout5_btn),
            findViewById(R.id.layout6_btn)
        )

        for ((i, layout) in layouts.withIndex())
            layoutBtns[i].setOnClickListener { launchLayout(layout) }

    }

    private fun launchLayout(layoutClass: Class<*>) {
        val intent = Intent(this@MainActivity, layoutClass)
        startActivity(intent)
    }
}