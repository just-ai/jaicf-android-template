package com.justai.aimybox.jaicf

import android.content.Context
import com.justai.jaicf.activator.rasa.RasaIntentActivator
import com.justai.jaicf.activator.rasa.api.RasaApi

fun createActivator(context: Context) = RasaIntentActivator.Factory(
    RasaApi("https://just-ai-rasa-template.herokuapp.com/")
)