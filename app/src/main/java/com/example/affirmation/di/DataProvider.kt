package com.example.affirmation.di

import com.example.affirmation.feature_assertion.domain.model.Affirmation

class DataProvider {

    fun loadAffirmations() : List<Affirmation> {
        return listOf(
            Affirmation("Je deviens la meilleure développeuse, et aimer apprendre continuellement"),
            Affirmation("J'aurais mon premier emploi de développeuse, et je ferai tout ce qu'il faut pour l'obstenir"
            ),
            Affirmation("Je retrouve un souffle parfait"
            ),
            Affirmation("Je suis en confiance avec mon corps, je ne fais plus qu'un avec lui, je prends extrêmement soin de lui"
            ),
            Affirmation("Je fais plus attention, à mes dépenses, investir plus, épargner et en gagner plus que je n'en aurais pas"
            ),
            Affirmation("Je gagne de l'argent par n'importe quel moyen, et je me sers correctement de l'argent"
            ),
            Affirmation("Je suis désirable, et je le sais. C'est aux autres de me découvrir"
            ),
            Affirmation("Interdiction formelle de rappeler les évènements ou les actions faites par un proche"
            )
        )
    }
}