package com.gmail.brymher.firebaseauth.util.forms.input

import com.gmail.brymher.movieticketing.validlogin.Validatable


class Email(value: String?) : Validatable<String?>(value) {
    override fun validate(): Boolean {
        return when {
            value == null -> {
                error = "Email is empty"
                false
            }

            value matches ".*".toRegex() -> true

            else -> {
                error = "Email is not valid"
                false
            }
        }
    }

    override fun toString() = value as String

}