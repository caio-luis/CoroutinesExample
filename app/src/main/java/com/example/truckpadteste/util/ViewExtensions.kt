package com.example.truckpadteste.util

import android.content.Context
import android.widget.Toast

fun Context.showToastMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}