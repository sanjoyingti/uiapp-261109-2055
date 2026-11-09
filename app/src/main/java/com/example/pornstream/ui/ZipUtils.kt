package com.example.pornstream.ui

import android.content.Context
import com.luben.zippy.Zippy
import java.io.File

object ZipUtils {
    fun createZip(context: Context, outputFileName: String, vararg files: File): Boolean {
        return try {
            val outputFile = File(context.filesDir, outputFileName)
            Zippy(context).zip(files, outputFile)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}
