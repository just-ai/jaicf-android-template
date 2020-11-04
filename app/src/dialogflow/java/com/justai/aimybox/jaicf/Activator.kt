package com.justai.aimybox.jaicf

import android.content.Context
import com.justai.jaicf.activator.dialogflow.DialogflowAgentConfig
import com.justai.jaicf.activator.dialogflow.DialogflowConnector
import com.justai.jaicf.activator.dialogflow.DialogflowIntentActivator

fun createActivator(context: Context) = DialogflowIntentActivator.Factory(
    DialogflowConnector(
        DialogflowAgentConfig("en", context.assets.open("jaicf-aimybox-template.json"))
    )
)