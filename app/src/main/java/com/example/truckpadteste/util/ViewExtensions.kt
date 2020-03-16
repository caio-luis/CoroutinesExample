package com.example.truckpadteste.util

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible

fun Context.showToastMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.toggleVisibility() {
    if (this.isVisible)
        this.visibility = View.GONE
    else
        this.visibility = View.VISIBLE
}