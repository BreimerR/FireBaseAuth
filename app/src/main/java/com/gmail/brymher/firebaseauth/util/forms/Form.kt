package com.gmail.brymher.firebaseauth.util.forms

import android.widget.TextView


abstract class Form() {

    open fun onSubmit(action: Int) {
        throw Error("Unsupported action provided $action")
    }

    fun submit(action: Int) {

    }


}