package com.justai.aimybox.jaicf

import android.app.Application
import android.content.Context
import com.justai.aimybox.Aimybox
import com.justai.aimybox.components.AimyboxProvider
import com.justai.aimybox.core.Config
import com.justai.aimybox.dialogapi.jaicf.JAICFDialogApi
import com.justai.aimybox.speechkit.google.platform.GooglePlatformSpeechToText
import com.justai.aimybox.speechkit.google.platform.GooglePlatformTextToSpeech
import com.justai.jaicf.BotEngine
import java.util.*

class AimyboxApplication: Application(), AimyboxProvider {

    override val aimybox by lazy { createAimybox(this) }

    private fun createAimybox(context: Context): Aimybox {
        val unitId = UUID.randomUUID().toString()

        val textToSpeech = GooglePlatformTextToSpeech(context, Locale.ENGLISH)
        val speechToText = GooglePlatformSpeechToText(context, Locale.ENGLISH)

        val engine = BotEngine(
            scenario = MainScenario,
            activators = arrayOf(createActivator(context))
        )

        val dialogApi = JAICFDialogApi(unitId, engine)

        return Aimybox(Config.create(speechToText, textToSpeech, dialogApi))
    }
}