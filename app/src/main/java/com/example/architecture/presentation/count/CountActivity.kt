package com.example.architecture.presentation.count

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.R
import com.example.architecture.databinding.ActivityCountBinding
import com.example.architecture.presentation.viewModel.CountViewModel
import org.intellij.lang.annotations.Pattern
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.logging.SimpleFormatter

class CountActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCountBinding.inflate(layoutInflater) }
    private val viewModel: CountViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnIncrement.setOnClickListener {
            viewModel.increment()
        }
        binding.btnDecrement.setOnClickListener {
            viewModel.decrement()
        }
        binding.btnReset.setOnClickListener {
            viewModel.resetCount()
        }

        viewModel.countData.observe(this) { countData ->
            binding.apply {
                tvCount.text = countData.count.toString()
                tvTime.text = formatMillisToDateTime(countData.createdAt)
                tvTypeOfOperation.text = countData.typeOfOperation.value
            }
        }
    }

    fun formatMillisToDateTime(milliseconds: Long, pattern: String = "HH:mm:ss"): String {
        val date = Date(milliseconds)
        val formatter = SimpleDateFormat(pattern, Locale.getDefault())
        return formatter.format(date)
    }
}