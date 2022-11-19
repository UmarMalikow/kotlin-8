package com.example.kotlin_8

import java.io.Serializable

data class MyModel(var urls: String, var namePerson: String, var age: Int, var middleName: String) : Serializable
