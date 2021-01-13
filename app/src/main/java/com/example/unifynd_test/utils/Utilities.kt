package com.example.unifynd_test.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class Utilities {
    companion object {


        fun isNotEmpty(responseObject: Any?): Boolean {
            return responseObject != null
        }

        fun hideKeyboard(activity: Activity) {
            try {
                if (activity.currentFocus != null) {
                    val imm =
                        activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm?.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
                }
            } catch (e: Exception) {
            }
        }

        @Throws(IOException::class)
        fun readJSONDataFromFile(context: Context, int: Int): String {
            var inputStream: InputStream? = null
            val builder = StringBuilder()
            try {
                var jsonString: String? = null
                inputStream =
                    context.resources.openRawResource(int)
                val bufferedReader = BufferedReader(
                    InputStreamReader(inputStream, "UTF-8")
                )
                while (bufferedReader.readLine().also({ jsonString = it }) != null) {
                    builder.append(jsonString)
                }
            } finally {
                if (inputStream != null) {
                    inputStream.close()
                }
            }
            return String(builder)
        }

    }

}