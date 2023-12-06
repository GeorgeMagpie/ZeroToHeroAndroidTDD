package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var check: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.removeButton.setOnClickListener {
            binding.rootLayout.removeView(binding.titleTextView)
            binding.removeButton.isEnabled = false
            check =true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("BTN", binding.removeButton.isEnabled)
        outState.putBoolean("STR", check)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.removeButton.isEnabled = savedInstanceState.getBoolean("BTN")
        check = savedInstanceState.getBoolean("STR")
        if (check){
            binding.rootLayout.removeView(binding.titleTextView)
        }
    }
}