package com.gmail.brymher.firebaseauth.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.gmail.brymher.firebaseauth.util.db.FireBase.FireBaseAuth
import com.gmail.brymher.firebaseauth.util.forms.input.Email
import com.gmail.brymher.firebaseauth.util.forms.input.Password
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.content_sign_up.*


class SignUp : DialogActivity(R.layout.activity_sign_up) {

    override fun init(savedInstanceState: Bundle?) {
        setSupportActionBar(toolbar)
        initEvents()
    }

    private fun initEvents() {
        signUp.setOnClickListener {
            signInUser()
        }


        haveAccount?.setOnClickListener {
            alert(R.layout.login_layout) { dialog, view ->
                view?.let {
                    val cAct = it.findViewById<Button>(R.id.signUp)

                    cAct?.setOnClickListener {
                        dialog?.dismiss()
                    }
                }
            }
        }
    }

    private fun signInUser() {
        val email = Email(if (email.text == null) null else email.text.toString())

        val password = Password(
            if (pwd.text == null) null else pwd.text.toString(),
            if (pwdRepeat.text == null) null else pwdRepeat.text.toString()
        )

        val user = FireBaseAuth()

        if (user.isSignedIn) else {
            user.create(
                email,
                password, {
                    Toast.makeText(this, "Complete", Toast.LENGTH_LONG).show()
                }, {
                    Toast.makeText(this, "Submit success", Toast.LENGTH_LONG).show()
                }, {
                    Toast.makeText(this, "Submit failed", Toast.LENGTH_LONG).show()
                }
            )
        }

    }


}
