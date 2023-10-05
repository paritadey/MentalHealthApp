package com.parita.mentalhealthapp.util

import java.util.regex.Pattern

object ValidatorClass {
    fun validatePhoneNumber(inputText: String): Boolean {
        return inputText.length.toInt() == 10
    }
    fun isNumber(value: String): Boolean {
        return value.isEmpty() || Regex("^\\d+\$").matches(value)
    }

    fun validatePassword(inputText: String):Boolean {
        val  password_pattern : Pattern =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{8,}" +                // at least 8 characters
                    "$")
        return password_pattern.matcher(inputText).matches()
    }

    fun checkEmpty(inputText: String): Boolean {
        return inputText.isEmpty()
    }
}