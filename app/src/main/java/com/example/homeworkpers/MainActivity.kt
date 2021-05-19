package com.example.homeworkpers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import com.example.homeworkpers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }

    private fun init() {

        binding.changeButton.setOnClickListener {
            startChangeActivity()
        }
    }

    private fun startChangeActivity() {
        val intent = Intent(this, ChangeActivity::class.java)
        startActivityForResult(intent, 7)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 7 && resultCode == RESULT_OK) {
            val info: ArrayList<Person> = data?.extras?.getParcelableArrayList("container")!!
            d("tagtag", "$info")
            val newPerson = info[0]

            binding.firstNameEditText.text = newPerson.lastName
            binding.lastNameEditText.text = newPerson.lastName
            binding.eMailEditText1.text = newPerson.eMail
            binding.birthYearTextVeiw.text = newPerson.year
            binding.genderEditText.text = newPerson.gender
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

}