package com.kevin.firstapptut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialtextViewTranslationY = textView_progress.translationY

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView_progress.text = progress.toString()

                val translationDistance = (initialtextViewTranslationY + progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                textView_progress.animate().translationY(translationDistance)

                textView_progress.animate().setDuration(500).rotation(360f).translationY(initialtextViewTranslationY)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        button_reset.setOnClickListener{
            seekBar.progress = 0

        }
    }
}