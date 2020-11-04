package com.justai.aimybox.jaicf

import android.content.Context
import com.justai.jaicf.activator.caila.CailaIntentActivator
import com.justai.jaicf.activator.caila.CailaNLUSettings

fun createActivator(context: Context) = CailaIntentActivator.Factory(
    CailaNLUSettings("cec8dc67-01f1-4c52-b00d-3fc8ea154e45")
)