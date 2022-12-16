import java.util.HexFormat

open class Endgegner(var name: String, var lebensPunkte: Int, var schadenswert: IntRange) {
    var miniBossSpawned = false
    var dead = false
    var angriff = mutableListOf("pupsAngriff", "seelenraub", "teleportAngriff", "beschwoerung", "zombiebiss", "kette" )
    init {
        this.name = "Friedhofs Wächter"
        this.lebensPunkte = 1500
        this.schadenswert = 20..40

    }
fun attacke(boss: Endgegner, zielHeld: Helden) {
      //  if (boss.lebensPunkte <= 750){
       //     miniBossSpawned = true}
        if (zielHeld is Scharfschuetzen && zielHeld.tarnModus){
            println("Der Friedhofs Wächter sieht sich um und sieht sein Ziel nicht. Der Angriff ging ins leere.")
        }
        else if (this.lebensPunkte > 0 && boss.lebensPunkte > 0) {
            var attacke = angriff.random()


            when (attacke) {
                "pupsangriff" -> pupsAngriff(zielHeld)
                "seelenraub" -> seelenraub(zielHeld)
                "teleportangriff" -> teleportAngriff(zielHeld)
                "beschwörung" -> beschwoerung(zielHeld)
                "zombiebiss" -> zombiebiss(zielHeld)
                "kette" -> kette(zielHeld)
            }
            }
    }

fun pupsAngriff(ziel: Helden){
    var pups = schadenswert.random()
    ziel.lebensPunkte -= pups
    println("Der Friedhofs Wächter nähert sich ${ziel.name} und pupst, ${ziel.name} steht in einer Giftwolke, " +
            "diese verursacht $pups Schaden , ${ziel.name} hat jetzt noch ${ziel.lebensPunkte} Leben.")

}
//Todo lebenspunkte auf 20% reduzieren
fun seelenraub(ziel: Helden){
    var schaden = ziel.lebensPunkte / 100
    var restLeben = schaden * 20
    println("Der Friedhofs Wächter entzieht dem ${ziel.name} die Seele, " +
            "die ${ziel.name} Leben verringert sich um 80%. ${ziel.name} hat jetzt noch $restLeben Leben ")

}

fun teleportAngriff(ziel: Helden){
    var teleport = schadenswert.random()
    ziel.lebensPunkte -= teleport
    println("Der Friedhofs Wächter teleportiert sich hinter Held, hebt ihn hoch und wirft ${ziel.name} zu Boden " +
            "und verursacht $teleport Schaden, ${ziel.name} hat jetzt noch ${ziel.lebensPunkte} Leben.")
}

fun beschwoerung(ziel: Helden){
    var beschwoerung = schadenswert.random()
    ziel.lebensPunkte -= beschwoerung
    println("Um den Friedhofs Wächter graben sich Zombies aus und greifen ${ziel.name} an," +
            " die Zombie verursachen $beschwoerung Schaden, ${ziel.name} hat jetzt noch ${ziel.lebensPunkte} Leben")
}

fun zombiebiss(ziel: Helden){
    var biss = schadenswert.random()
    ziel.lebensPunkte -= biss
    println("Der Friedhofs Wächter beißt ${ziel.name} und verursacht $biss Schaden, " +
            "${ziel.lebensPunkte} Leben hat ${ziel.name} noch.")
}
//todo mini Boss einmalig spawnen lassen
fun kette(ziel: Helden){
    var kette = schadenswert.random()
    ziel.lebensPunkte -= kette
    println("Der Friedhofs Wächter schleudert seine Kette und peischt auf ${ziel.name} und verursacht $kette Schaden" +
            "${ziel.name} hat jetzt noch ${ziel.lebensPunkte} Leben")
    }
}
