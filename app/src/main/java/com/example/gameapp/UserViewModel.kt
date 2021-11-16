package com.example.gameapp

import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private lateinit var _name: String
    private lateinit var _email: String
    private var _score = 0
    val name: String
        get() = _name
    val email: String
        get() = _email
    val score: Int
        get() = _score


}