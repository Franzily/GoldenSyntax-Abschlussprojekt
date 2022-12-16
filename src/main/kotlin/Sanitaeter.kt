class Sanitaeter(name: String, lebensPunkte: Int,var schadenswert: IntRange): Helden(name, lebensPunkte) {

    init {
        this.name = "Sanitöter"
        this.lebensPunkte = 120
        this.schadenswert = 20..30
        istWiederbelebt = true
        this.dead = false
    }

    fun attacke(boss: Endgegner, zielHeld: Soldat, zielHeld2: Scharfschuetzen) {

        if (lebensPunkte <= 0){
            dead = true
            println("$name ist gefallen und kann keinen weiteren Angriff durch führen")
        }
        else if (this.lebensPunkte > 0 && boss.lebensPunkte > 0) {
            var attacke = readln().toInt()


            when (attacke) {
                1 -> teamHealing(zielHeld)
                2 -> rebirth(zielHeld, zielHeld2)
                3 -> molotov(boss)
                4 -> mpMagazien(boss)

            }
        }
    }

fun trank(ziel: Sanitaeter){
    ziel.lebensPunkte += 50

}

fun vitamine(ziel: Sanitaeter){
    ziel.schadenswert + 10

}

fun teamHealing(ziel: Helden) {
    var zielHeilung = ziel.lebensPunkte + 50
    println("Das Team wird geheilt und erhält 50 Lebenspunkte.")

}

fun rebirth(ziel: Soldat, ziel2: Scharfschuetzen) {
    if (ziel.lebensPunkte <= 0 || !ziel.istWiederbelebt) {
        ziel.lebensPunkte = 100
        ziel.istWiederbelebt = true
        println("${ziel.name} wird wieder belebt und seine Lebenspunkte auf ${ziel.lebensPunkte} gesetzt")

        if (ziel2.lebensPunkte <= 0 || !ziel2.istWiederbelebt){
            ziel2.lebensPunkte = 100
            ziel2.istWiederbelebt = true
        }
    } else println("${ziel.name} ist noch am Leben und kann nicht wiederbelebt werden.")


}

fun molotov(ziel: Endgegner) {
    var moli = schadenswert.random()
    ziel.lebensPunkte -= moli
    println("$name wirft einen Molotov und setzt ${ziel.name} in Brand und verursacht $moli Schaden. " +
                            "${ziel.name} hat jetzt noch ${ziel.lebensPunkte} Leben.")
}
fun mpMagazien(ziel: Endgegner){
    var magazinVerschiessen = schadenswert.random()
    ziel.lebensPunkte -= magazinVerschiessen
    println("$name hebt seine MP visiert ${ziel.name} an und verschiesst ein komplettes Magazin und" +
            " verursacht $magazinVerschiessen Schaden. ${ziel.name} hat noch ${ziel.lebensPunkte} Leben.")
}

}
