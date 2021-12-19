package com.retrypay.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.retrypay.example.util.Coroutines
import com.retrypay.rickandmorti.data.network.model.ApiRMResponse
import com.retrypay.rickandmorti.data.repository.PersonRepository
import com.retrypay.rickandmorti.util.Resource
import com.retrypay.rickandmorti.util.ResourceStatus

class MainActivity : AppCompatActivity() {

    lateinit var personRepository: PersonRepository
    var allPersonsButton: MaterialButton? = null
    var responseText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        personRepository = PersonRepository()
    }

    override fun onStart() {
        super.onStart()
        allPersonsButton = findViewById(R.id.allPersonsButton)
        responseText = findViewById(R.id.responseText)
        allPersonsButton?.setOnClickListener {
            onGetAllPersons()
        }
    }

    private fun onGetAllPersons() {
        personRepository.getAllPersons(null).observe(this) {
            when(it.status) {
                ResourceStatus.SUCCESS -> {
                    // Do something with data
                    setResponseText(it.data.toString())
                }
                ResourceStatus.LOADING -> {
                    // Show loading to user
                }
                ResourceStatus.ERROR -> {
                    it.message?.let {
                        // Show message to user
                    }
                }
            }
        }
    }

    private fun onGetOnePerson(personId: Int) {
        personRepository.getOnePerson(personId).observe(this) {
            when(it.status) {
                ResourceStatus.SUCCESS -> {
                    // Do something with data
                }
                ResourceStatus.LOADING -> {
                    // Show loading to user
                }
                ResourceStatus.ERROR -> {
                    it.message?.let {
                        // Show message to user
                    }
                }
            }
        }
    }

    private fun onGetSomePersons(personIds: List<Int>) {
        personRepository.getSomePersons(personIds).observe(this) {
            when(it.status) {
                ResourceStatus.SUCCESS -> {
                    // Do something with data
                }
                ResourceStatus.LOADING -> {
                    // Show loading to user
                }
                ResourceStatus.ERROR -> {
                    it.message?.let {
                        // Show message to user
                    }
                }
            }
        }
    }

    private fun onFilterPersons(
            name: String?,
            status: String?,
            species: String?,
            type: String?,
            gender: String?
    ) {
        personRepository.getPersons(name, status, species, type, gender).observe(this) {
            when(it.status) {
                ResourceStatus.SUCCESS -> {
                    // Do something with data
                }
                ResourceStatus.LOADING -> {
                    // Show loading to user
                }
                ResourceStatus.ERROR -> {
                    it.message?.let {
                        // Show message to user
                    }
                }
            }
        }
    }

    private fun setResponseText(text: String) {
        Coroutines.main {
            responseText?.text = text
        }
    }
}