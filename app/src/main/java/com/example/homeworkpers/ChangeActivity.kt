package com.example.homeworkpers

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import com.example.homeworkpers.databinding.ActivityChangeBinding
import com.example.homeworkpers.databinding.ActivityMainBinding

class ChangeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChangeBinding
    private val container = mutableListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChangeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }

    private fun init() {

        binding.saveButton.setOnClickListener {
            if (inputChecker()) {
                getData()
                openMainActivity()
            } else { Toast.makeText(this,"fill the fields to change info", Toast.LENGTH_SHORT).show() }
        }
    }

    private fun getData() {
        val newPerson = Person(
            binding.nameEditText.text.trim().toString(),
            binding.lastNameEditText.text.trim().toString(),
            binding.eMailEditText.text.trim().toString(),
            binding.yearEditText.text.trim().toString(),
            binding.genderEditText.text.trim().toString()
        )
        container.add(newPerson)
    }

    private fun inputChecker(): Boolean {
        return binding.nameEditText.text.isNotEmpty() &&
                binding.lastNameEditText.text.isNotEmpty() &&
                binding.eMailEditText.text.isNotEmpty() &&
                binding.yearEditText.text.isNotEmpty() &&
                binding.genderEditText.text.isNotEmpty()
    }

    private fun openMainActivity() {
        intent.putParcelableArrayListExtra("container", ArrayList(container))
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

}