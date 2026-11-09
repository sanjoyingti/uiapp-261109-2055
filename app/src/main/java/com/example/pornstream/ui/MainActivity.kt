package com.example.pornstream.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pornstream.ui.ui.theme.UiAppTheme
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ZipDemoScreen()
                }
            }
        }
    }
}

@Composable
fun ZipDemoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = {
            val files = arrayOf(
                File.createTempFile("temp1", ".txt"),
                File.createTempFile("temp2", ".txt")
            )
            val success = ZipUtils.createZip(androidx.compose.ui.platform.LocalContext.current, "archive.zip", *files)
            Toast.makeText(
                androidx.compose.ui.platform.LocalContext.current,
                if (success) "Zip created successfully" else "Failed to create zip",
                Toast.LENGTH_SHORT
            ).show()
        }) {
            Text("Create Zip File")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ZipDemoScreenPreview() {
    UiAppTheme {
        ZipDemoScreen()
    }
}
