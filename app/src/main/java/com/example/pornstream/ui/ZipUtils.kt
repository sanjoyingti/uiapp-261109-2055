package com.example.pornstream.ui

import android.content.Context
import net.lingala.zip4j.ZipFile
import net.lingala.zip4j.model.ZipParameters
import net.lingala.zip4j.model.enums.CompressionMethod
import net.lingala.zip4j.model.enums.CompressionLevel
import java.io.File

object ZipUtils {
    fun createZip(context: Context, outputFileName: String, vararg files: File): Boolean {
        return try {
            val outputFile = File(context.filesDir, outputFileName)
            val zipFile = ZipFile(outputFile)
            val zipParameters = ZipParameters()
            zipParameters.compressionMethod = CompressionMethod.STORE
            zipParameters.compressionLevel = CompressionLevel.NORMAL

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
