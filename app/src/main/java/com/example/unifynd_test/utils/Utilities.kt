package com.example.unifynd_test.utils

import android.content.Context
import com.example.unifynd_test.R
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class Utilities {
    companion object {


        fun isNotEmpty(responseObject: Any?): Boolean {
            return responseObject != null
        }

        @Throws(IOException::class)
        fun readJSONDataFromFile(context: Context): String {
            var inputStream: InputStream? = null
            val builder = StringBuilder()
            try {
                var jsonString: String? = null
                inputStream =
                    context.resources.openRawResource(R.raw.dummy)
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