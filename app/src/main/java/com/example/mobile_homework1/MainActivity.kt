package com.example.mobile_homework1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import com.example.mobile_homework1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val converter: TextToIntegerConverter = TextToIntegerConverter()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val output = binding.out
        val input = binding.input

        binding.convertBtn.setOnClickListener {
            if(validateFields(input.text.toString())) {
                output.text = converter.int2text(input.text.toString().toInt())
            }
        }
    }

    private fun validateFields(input:String): Boolean {
        if (!emptyTextValidation(input)) {
            return false
        }
        if (!limitValidation(input)) {
            return false
        }
        return true
    }

    private fun emptyTextValidation(input:String):Boolean {
        if (input.isEmpty()) {
            binding.input.error = "Input a number"
            return false
        }
        return true
    }

    private fun limitValidation(input:String):Boolean {
        if (input.length > 9) {
            binding.input.error = "The input number is not in the given range"
            return false
        }
        return true
    }


}