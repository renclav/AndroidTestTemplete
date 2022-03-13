package com.renclav.samplecalendarbooking

import android.os.Bundle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import com.renclav.samplecalendarbooking.R
import com.renclav.samplecalendarbooking.presentation.theme.SampleCalendarBookingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DemoActivity : FragmentActivity(R.layout.demo_activity) {
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SampleCalendarBookingTheme {
        Greeting("Android")
    }
}