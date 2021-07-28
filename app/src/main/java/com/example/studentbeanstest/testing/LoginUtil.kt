package com.example.studentbeanstest.testing

import android.util.Patterns
import java.util.regex.Pattern

object LoginUtil {

    /**
     * object for testing
     * input not valid if email/password is  empty
     * input not valid if email is not valid as in doesn't match typical email pattern
     */


    private val pattern = Patterns.EMAIL_ADDRESS

    fun loginValidation(
        emailAddress: String,
        password: String
    ): Boolean {
        if (emailAddress.isNotEmpty() || password.isNotEmpty()) {
            return true
        }
        if (pattern.matcher(emailAddress).matches()) {
            return true
        }
        return false
    }


}