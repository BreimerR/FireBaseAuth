package com.gmail.brymher.movieticketing.validlogin

abstract class Validatable<T>(val value: T) {

    var error: String? = null

    var isValidField: Boolean? = null

    val isValid: Boolean by lazy {
        validate()
    }


    val string
        get() = toString()

    abstract fun validate(): Boolean
}

