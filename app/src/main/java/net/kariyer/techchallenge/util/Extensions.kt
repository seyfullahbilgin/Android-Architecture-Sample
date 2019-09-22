package net.kariyer.techchallenge.util

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Build
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import java.lang.IndexOutOfBoundsException
import java.text.DateFormatSymbols


fun Any.log(message: Any) {
    Log.i(javaClass.simpleName, message.toString())
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}


fun DateFormatSymbols.getMonthName(month: Int): String {
    if (month < 1 || month > 12)
        throw IndexOutOfBoundsException()

    return months[month - 1]
}

fun View.setBackgroundColorByRes(@ColorRes id: Int) {
    setBackgroundColor(ContextCompat.getColor(context, id))
}

fun TextView.setTextColorByRes(@ColorRes id: Int) {
    setTextColor(ContextCompat.getColor(context, id))
}

fun AppCompatActivity.setStatusBarColor(@ColorRes id: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = ContextCompat.getColor(this, id)
    }
}

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.togleVisibility() {
    visibility = if (visibility == View.VISIBLE) View.GONE else View.VISIBLE
}



