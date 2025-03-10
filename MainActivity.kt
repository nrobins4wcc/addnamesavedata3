package com.example.addnamesavedata3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.addnamesavedata3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.names.observe(this, Observer {names ->
            binding.namesTextView.text = names.joinToString("\n")
        })

        binding.addButton.setOnClickListener{
            val name = binding.nameEditText.text.toString().trim()
            if(name.isNotEmpty()){
                mainViewModel.addName(name)
                binding.nameEditText.text.clear()
            }else{
                Toast.makeText(this, "please enter a name", Toast.LENGTH_SHORT).show()

            }
        }
    }
}