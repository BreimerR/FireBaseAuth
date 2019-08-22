package com.gmail.brymher.firebaseauth.activities

import android.app.AlertDialog
import android.view.View


abstract class DialogActivity(layout: Int) : Base(layout) {
    fun alert(layout_res: Int, theme: Int = R.style.LayoutDialog, builder: (AlertDialog?, View?) -> Unit) {

        val view = layoutInflater.inflate(layout_res, null)

        builder(AlertDialog.Builder(this, theme).apply {
            setView(view)
        }.show(), view)
    }
}
