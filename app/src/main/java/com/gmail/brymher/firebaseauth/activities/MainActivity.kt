package com.gmail.brymher.firebaseauth.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : DialogActivity(R.layout.activity_main) {

    val TAG = "MainActivity"

    override fun init(savedInstanceState: Bundle?) {
        setSupportActionBar(toolbar)
        initEvents()
    }

    private fun initEvents() {
        initFab()
        initAccess()
    }

    @SuppressLint("InflateParams")
    private fun initAccess() {
        initSignInBtn()
        initSignUpBtn()
    }

    private fun initSignUpBtn() {
        signUp.apply {
            setOnClickListener {
                startActivity(Intent(this@MainActivity, SignUp::class.java))
            }
            // TODO remove
            performClick()
        }
    }

    private fun initSignInBtn() {
        signIn.setOnClickListener {

            alert(R.layout.login_layout) { dialog, view ->
                dialog?.let {
                    initSignIn(view, it)
                    initSignUp(view, it)
                }
            }
        }
    }

    private fun initSignUp(view: View?, dialog: AlertDialog) {
        view?.let {

            it.findViewById<Button>(R.id.signUp)?.setOnClickListener {
                dialog.dismiss()
                signUp.performClick()
            }

        }
    }

    private fun initSignIn(view: View?, dialog: AlertDialog) {
        view?.let {

            it.findViewById<Button>(R.id.signIn)?.setOnClickListener {
                // get current focused view
                closeDialogInput(dialog)

                showLoader()
            }

        }
    }

    private fun closeDialogInput(dialog: AlertDialog) {
        dialog.apply {
            currentFocus?.let { v ->
                (context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
                    .hideSoftInputFromWindow(
                        v.windowToken,
                        0
                    )
            }
        }
    }

    private fun showLoader() {
        Toast.makeText(this, "Signing In...", Toast.LENGTH_LONG).show()
    }

    private fun initFab() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

}
