class Scharfschuetzen(name: String, lebensPunkte: Int, var schadenswert: IntRange): Helden(name, lebensPunkte){
    var tarnModus = false
    init {
        this.name = "Hannelore Schreckschuss"
        this.lebensPunkte = 150
        this.schadenswert = 20..40

    }
    fun attack(boss: Endgegner, zielHelden: Scharfschuetzen) {
        if (lebensPunkte <= 0){
            dead = true
            println("$name ist gefallen und kann keinen weiteren Angriff durch führen")
        }
        else if (this.lebensPunkte > 0 && boss.lebensPunkte > 0) {
            var attacke = readln().toInt()

            when (attacke) {
                1 -> headShot(boss)
                2 -> doubleShot(boss)
                3 -> tarnModus(zielHelden)
                4 -> wurfMesser(boss)

            }
        }
    }

fun trank(ziel: Scharfschuetzen){
    ziel.lebensPunkte += 50
}

fun vitamine(ziel: Scharfschuetzen){
    ziel.schadenswert + 10
}

fun headShot(ziel: Endgegner){
    var headi = schadenswert.random()
    ziel.lebensPunkte -= headi
    println("$name hält die Luft an zielt und trifft ${ziel.name} in den Kopf und verursacht $headi Schaden. " +
            "${ziel.name} hat jetzt noch ${ziel.lebensPunkte} Leben")
}

fun doubleShot(ziel: Endgegner){
    var doppelschuss = schadenswert.random()*2
    ziel.lebensPunkte -= doppelschuss
    println("$name macht einen Doppelschuss auf ${ziel.name} und verursacht $doppelschuss Schaden. " +
            "${ziel.name} hat jetzt noch ${ziel.lebensPunkte}Leben ")
}

fun tarnModus(ziel: Scharfschuetzen){
    tarnModus = true
    println("$name aktiviert den Tarnmodus und verschmilzt mit seiner umgebung..")
}

fun wurfMesser(ziel: Endgegner){
    var messer = schadenswert.random()
    ziel.lebensPunkte -= messer
    println("Der $name wirft ein Messer auf den Friedhofs Wächter und verursacht $messer Schaden. " +
            "${ziel.name} hat jetzt noch ${ziel.lebensPunkte} Leben")
}
}