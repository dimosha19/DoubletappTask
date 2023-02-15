package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

const val COUNTER_KEY = "val"
private const val INITIAL_COUNTER = 0
private const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {
    private var counter: Int = INITIAL_COUNTER
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "On create")
        counter = savedInstanceState?.getInt(COUNTER_KEY) ?: INITIAL_COUNTER
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Box {
                        Column (modifier = Modifier.align(Alignment.Center)) {
                            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                                CounterField(counter)
                            }
                            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                                val intent = Intent(this@MainActivity, SqrActivity::class.java)
                                intent.apply { putExtra(COUNTER_KEY, counter) }
                                ButtonToSqrActivity(intent = intent)
                            }
                        }
                    }
                }
            }
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNTER_KEY, counter + 1)
    }

    @Composable
    fun CounterField(counterValue: Int) {
        Text(
            text = counterValue.toString()
        )
    }

    @Composable
    fun ButtonToSqrActivity(intent: Intent) {
        Button(
            onClick = {
            startActivity(intent)
        }) {
            Text(text = "View square of counter", fontSize = 25.sp)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MyApplicationTheme {
            Column() {
                CounterField(1)
            }
        }
    }
}

