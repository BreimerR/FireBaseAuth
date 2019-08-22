package com.gmail.brymher.firebaseauth.util.forms.input

import com.gmail.brymher.movieticketing.validlogin.Validatable

class Password(value: String?, val copy: String?) : Validatable<String?>(value) {

    override fun validate(): Boolean {

        return when {
            value == null -> {
                error = "Password not defined"
                false
            }
            copy == null -> {
                error = "Value is  not defined"
                false
            }
            value == copy -> true

            else -> {
                error = "password $value does not match $copy"
                false
            }
        }

    }

    override fun toString() = value as String

}