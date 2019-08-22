package com.gmail.brymher.firebaseauth.util.db.FireBase

import android.os.AsyncTask
import com.google.firebase.auth.FirebaseAuth
import com.gmail.brymher.movieticketing.validlogin.Validatable

class FireBaseAuth : FireBase() {

    var errors = arrayOf<String>()

    private inline val hasErrors get() = errors.isNotEmpty()

    val auth by lazy {
        FirebaseAuth.getInstance()
    }

    val isSignedIn
        get() = auth.currentUser != null

    fun create(
        email: Validatable<*>, password: Validatable<*>, onComplete: (() -> Unit)? = null,
        onSuccess: (() -> Unit)? = null,
        onCanceled: (() -> Unit)? = null
    ) {
        if (validateInputs(email, password)) {
            Task(this, onComplete, onSuccess, onCanceled).execute(email.string, password.string)
        }
    }

    private fun validateInputs(vararg inputs: Validatable<*>): Boolean {

        errors = arrayOf()

        for (input in inputs) {
            if (!input.isValid) {
                // TODO update error values and return
                input.error?.let {
                    errors += it
                }

            }
        }

        return hasErrors
    }

    class Task(
        val db: FireBaseAuth,
        val onComplete: (() -> Unit)? = null,
        val onSuccess: (() -> Unit)? = null,
        val onCanceled: (() -> Unit)? = null
    ) : AsyncTask<String?, Void, Unit>() {
        override fun doInBackground(vararg params: String?) {
            db.auth.createUserWithEmailAndPassword(params[0] as String, params[1] as String).apply {
                addOnCompleteListener { task ->
                    with(task) {
                        when {
                            isComplete -> {
                                this@Task.onComplete?.let {
                                    it()
                                }
                            }
                            isCanceled -> {
                                this@Task.onCanceled?.let {
                                    it()
                                }
                            }
                            isSuccessful -> {
                                this@Task.onSuccess?.let {
                                    it()
                                }
                            }
                        }
                    }
                }
            }
        }
    }


}