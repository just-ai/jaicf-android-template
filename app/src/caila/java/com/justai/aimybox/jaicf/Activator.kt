package com.justai.aimybox.jaicf

import android.content.Context
import com.justai.jaicf.activator.caila.CailaIntentActivator
import com.justai.jaicf.activator.caila.CailaNLUSettings

fun createActivator(context: Context) = CailaIntentActivator.Factory(
    CailaNLUSettings("52f8c478-b863-409f-8ad5-98b666413601")
)