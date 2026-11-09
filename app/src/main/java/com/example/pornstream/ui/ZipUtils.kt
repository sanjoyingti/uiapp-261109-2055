package com.example.pornstream.ui

import android.content.Context
import net.lingala.zip4j.ZipFile
import net.lingala.zip4j.model.ZipParameters
import java.io.File

object ZipUtils {
    fun createZip(context: Context, outputFileName: String, vararg files: File): Boolean {
        return try {
            val outputFile = File(context.filesDir, outputFileName)
            val zipFile = ZipFile(outputFile)
            val zipParameters = ZipParameters()
            zipParameters.compressionMethod = ZipParameters.COMP_STORE
            zipParameters.compressionLevel = ZipParameters.DEFLATE_LEVEL_NORMAL

            for (file in files) {
                zipFile.addFile(file, zipParameters)
            }

            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}
