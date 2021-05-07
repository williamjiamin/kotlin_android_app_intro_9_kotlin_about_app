package com.lexueoude.aboutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
//import kotlinx.android.synthetic.main.activity_main.*

import com.lexueoude.aboutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityMainBinding

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        age_text_view.text = String.format(resources.getString(R.string.str_age), 0)
        binding.ageTextView.text = "拖动右侧，调整年龄->"

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.ageTextView.text = String.format(resources.getString(R.string.str_age), progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.list_of_units,
            android.R.layout.simple_list_item_1
        ).also { arrayAdapter ->
            binding.spinner.adapter = arrayAdapter
        }

//        spinner.adapter = adapter


    }
}