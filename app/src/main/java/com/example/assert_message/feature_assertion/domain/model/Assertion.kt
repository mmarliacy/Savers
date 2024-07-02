package com.example.assert_message.feature_assertion.domain.model


data class Assertion(
    var message: String = ""
) {
    companion object {
        var messageList = arrayListOf(
            Assertion("Je deviens la meilleure développeuse, et aimer apprendre continuellement"),
            Assertion(
                "J'aurais mon premier emploi de développeuse, et je ferai tout ce qu'il faut pour l'obstenir"
            ),
            Assertion(
                "Je retrouve un souffle parfait"
            ),
            Assertion(
                "Je suis en confiance avec mon corps, je ne fais plus qu'un avec lui, je prends extrêmement soin de lui"
            ),
            Assertion(
                "Je fais plus attention, à mes dépenses, investir plus, épargner et en gagner plus que je n'en aurais pas"
            ),
            Assertion(
                "Je gagne de l'argent par n'importe quel moyen, et je me sers correctement de l'argent"
            ),
            Assertion(
                "Je suis désirable, et je le sais. C'est aux autres de me découvrir"
            ),
            Assertion(
                "Interdiction formelle de rappeler les évènements ou les actions faites par un proche"
            )
        )
    }
}




