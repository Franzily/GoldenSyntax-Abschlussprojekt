class `Endgegner Kaempfer`(name: String, lebensPunkte: Int): Endgegner(name, lebensPunkte, schadenswert= 20..40) {
    var angriffe = mutableListOf("stachel", "schockwelle", "giftkugel", "schwert angriff")
    init {
        this.name = "Demon"
        this.lebensPunkte = 550
        this.miniBossSpawned = false

    }
fun attack(miniBoss: `Endgegner Kaempfer`, ziel: Helden) {
        if (this.lebensPunkte > 0 && miniBoss.lebensPunkte > 0) {
            var attacke = angriffe.random()

            when (attacke) {
                "stachel" -> stachel(ziel)
                "schockwelle" -> schockwelle(ziel)
                "giftkugel" -> giftKugel(ziel)
                "schwert angriff" -> schwertAngriff(ziel)
            }
        }
    }
fun stachel(ziel: Helden){
    var stachel = schadenswert.random()
    var schaden = ziel.lebensPunkte - stachel
    println("$name lässt Stacheln um ${ziel.name} aus dem Boden kommen und verursacht $stachel Schaden." +
            "${ziel.name} hat noch ${ziel.lebensPunkte} Leben")
}

fun schockwelle(ziel: Helden){
    var schock = schadenswert.random()
    var schaden = ziel.lebensPunkte - schock
    println("$name schlägt mit Faust auf den Boden und eine Schockwelle trifft ${ziel.name}. " +
            "Die Welle verursacht $schock Schaden. ${ziel.name} hat noch ${ziel.lebensPunkte} Leben")
}
fun giftKugel(ziel: Helden){
    var gift = schadenswert.random()
    var schaden = ziel.lebensPunkte - gift
    println("$name spuckt eine Giftkugel auf ${ziel.name} und verursacht $gift Schaden." +
            "${ziel.name} hat noch ${ziel.lebensPunkte} Leben.")
}
fun schwertAngriff(ziel: Helden){
    var schwert = schadenswert.random()
    var zielSchaden = ziel.lebensPunkte - schwert
    println("$name zieht sein Schwert wirbelt es um sich und trifft ${ziel.name} und verursacht$schwert Schaden." +
            "${ziel.name} hat noch ${ziel.lebensPunkte} Leben.")
}
}