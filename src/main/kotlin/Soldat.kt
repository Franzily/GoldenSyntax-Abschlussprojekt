class Soldat(name: String, lebensPunkte: Int, var schadenswert: IntRange): Helden(name, lebensPunkte){
    init {
        this.name = "Private Paula"
        this.lebensPunkte = 200
        this.schadenswert = 50..80

    }
    override fun attack(boss: Endgegner, zielHelden: Helden) {
        if (lebensPunkte <= 0){
            dead = true
            println("$name ist gefallen und kann keinen weiteren Angriff durch führen")
        }
        else if (this.lebensPunkte > 0 && boss.lebensPunkte > 0) {
            var attacke = readln().toInt()

            when (attacke) {
                1 -> granate(boss)
                2 -> nahkampf(boss)
                3 -> magazin(boss)
                4 -> spatenWerfen(boss)

            }
        }
    }

fun trank(ziel: Soldat){
        ziel.lebensPunkte += 50
}

fun vitamine(ziel: Soldat){
        ziel.schadenswert + 10
}

fun granate(ziel: Endgegner){
    var granateWerfen = schadenswert.random()
    ziel.lebensPunkte -= granateWerfen
    println("$name entsichert die Granate und wirft diese dem ${ziel.name} vor die Füße. " +
            "Die Granate verursacht $granateWerfen Schaden. ${ziel.name} hat noch ${ziel.lebensPunkte}")

}

fun nahkampf(ziel: Endgegner){
    var nahkampf = schadenswert.random()
    ziel.lebensPunkte -= nahkampf
    println("$name pirscht nach vorn und gibt dem ${ziel.name} eins auf den Deckel und verursacht $nahkampf Schaden." +
            "${ziel.name} hat noch ${ziel.lebensPunkte} Leben.")

}

fun magazin(ziel: Endgegner){
    var magazinVerschiessen = schadenswert.random()
    ziel.lebensPunkte -= magazinVerschiessen
    println("$name stützt seine Waffe auf der Hüfte auf und verschießt ein ganzes " +
            "Magazin und verursacht $magazinVerschiessen Schaden. ${ziel.name} hat noch ${ziel.lebensPunkte} Leben")


}

fun spatenWerfen(ziel: Endgegner){
    var spaten = schadenswert.random()
    ziel.lebensPunkte -= spaten
    println("$name wirft seinen Spaten wie ein Boomerang und verursacht $spaten Schaden." +
            "${ziel.name} hat noch ${ziel.lebensPunkte} Leben.")
}
}