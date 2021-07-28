package com.example.studentbeanstest.ui.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class LoginViewModel : ViewModel() {

    /**
     * will pass on two way databinding
     */
    var emailAddress: String = ""
    var password: String = ""

    /**
     * To pass login result to fragment
     */
    private val logInResult = MutableLiveData<String>()

    fun getLogInResult(): LiveData<String> = logInResult

    private val isEmailValid: Boolean
        get() = Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()

    /**
     * Called from fragment on login button click
     */
    fun loginValidation(): Boolean {

        if (!isEmailValid || password.isBlank() || emailAddress.isBlank()) {
            logInResult.value = "Invalid email address/password"
            return false
        }
        else {
            logInResult.value = "Logged in successfully! :D"
            return true
        }

    }

}