package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

private const val TAG = "SqrActivity"
class SqrActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "On create")
        val counter = intent.extras?.getInt (COUNTER_KEY) ?: throw Exception("Unable to find counter key")
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SqrField(counter)
                }
            }
        }
    }

    @Composable
    fun SqrField(value: Int) {
        Text(text = (value * value).toString())
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview2() {
        MyApplicationTheme {
            SqrField(1)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "On start")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "On restart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "On resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "On pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "On stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "On destroy")
    }

}