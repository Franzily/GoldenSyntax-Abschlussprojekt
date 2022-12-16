import java.util.Scanner

fun auswahlTreffen(rucksack: MutableList<String>, sani: Sanitaeter, sniper: Scharfschuetzen, soldat: Soldat){
    try {
            println("In dem Rucksack befinden sich noch: $rucksack Bitte wähle einen Gegenstand.")
            var gegenstand = readln().lowercase()
            if (rucksack.contains(gegenstand))

                println(
                    "Du hast $gegenstand gewählt. \n " +
                            "wähle einen Held der $gegenstand verwenden soll." +
                            "\n 1 für Sanitöter" +
                            "\n 2 für Hannelore Schreckschuss" +
                            "\n 3 für Private Paula"
                )
            else {
                println("Der $gegenstand ist nicht mehr verfügbar.")
            }
            var ausgewaehlterHeld = readln().toInt()
            if (ausgewaehlterHeld == 1 && gegenstand == "heiltrank") {
                sani.trank(sani)
                rucksack.remove("heiltrank")
            }
            if (ausgewaehlterHeld == 2 && gegenstand == "heiltrank") {
                sniper.trank(sniper)
                rucksack.remove("heiltrank")
            }
            if (ausgewaehlterHeld == 3 && gegenstand == "heiltrank") {
                soldat.trank(soldat)
                rucksack.remove("heiltrank")
            }
            if (ausgewaehlterHeld == 1 && gegenstand == "vitamine") {
                sani.vitamine(sani)
                rucksack.remove("vitamine")
            }
            if (ausgewaehlterHeld == 2 && gegenstand == "vitamine") {
                sniper.vitamine(sniper)
                rucksack.remove("vitamine")
            }
            if (ausgewaehlterHeld == 3 && gegenstand == "vitamine") {
                soldat.vitamine(soldat)
                rucksack.remove("vitamine")
            }
    } catch (ex: Exception) {
        println("Die Eingabe ist falsch. Bitte wiederhole deine Eingabe")
    }
}