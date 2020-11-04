package com.justai.aimybox.jaicf

import com.justai.jaicf.activator.caila.caila
import com.justai.jaicf.activator.dialogflow.dialogflow
import com.justai.jaicf.activator.rasa.rasa
import com.justai.jaicf.channel.aimybox.aimybox
import com.justai.jaicf.hook.AfterProcessHook
import com.justai.jaicf.model.scenario.Scenario

object MainScenario: Scenario() {

    init {
        /**
         * Appends these buttons for every response
         */
        handle<AfterProcessHook> {
            it.reactions.buttons(
                "Help me!", "How are you?", "What is your name?"
            )
        }

        state("hello") {
            activators {
                intent("hello")
                intent("greet")
            }

            action {
                reactions.run {
                    image("https://media.giphy.com/media/ICOgUNjpvO0PC/source.gif")
                    sayRandom("Hello!", "Hello there!")
                }
            }
        }

        state("bye") {
            activators {
                intent("bye")
                intent("goodbye")
            }

            action {
                reactions.run {
                    image("https://media.giphy.com/media/EE185t7OeMbTy/source.gif")
                    say("Bye bye!")
                    aimybox?.endConversation()
                }
            }
        }

        state("smalltalk", noContext = true) {
            activators {
                anyIntent()
            }

            action {
                activator.caila?.topIntent?.answer?.let {
                    reactions.say(it)
                }

                activator.rasa?.run {
                    reactions.say("Hmm... I don't know what to say.")
                }

                activator.dialogflow?.run {
                    reactions.say(queryResult.fulfillmentText)
                }
            }
        }

        fallback {
            reactions.sayRandom(
                "Sorry, I didn't get that.",
                "Sorry, could you repeat please?"
            )
        }
    }
}