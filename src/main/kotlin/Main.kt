fun main() {

    println("Du hast einen weiten Weg gehabt, du stehst kurz davor das Land Syntax von dem bösen zu befreien!")
    println("Du stehst vor dem Friedhof sankt Syntax und siehst in der ferne den mächtigen Friedhofs Wächter.")
    println("Du näherst dich dem Friedhof, mit dem wissen die 3 besten Kämpfer zu haben.")


    var boss = Endgegner("Friedhofs Wächter", 1500, 20..40)
    var miniBoss = `Endgegner Kaempfer`("Demon", 550,)
    var sani = Sanitaeter("Sanitöter", 120, 40..50)
    var sniper = Scharfschuetzen("Hannelore Schreckschuss", 150, 50..80)
    var soldat = Soldat("Private Paula", 200, 100..150)
    var rucksack = mutableListOf<String>("heiltrank", "heiltrank", "heiltrank", "vitamine")

do {
    fight(boss, sani, sniper, soldat, rucksack, )
}
    while (gameOver(boss, sniper, soldat, sani))
}

fun fight(boss: Endgegner, sani: Sanitaeter, sniper: Scharfschuetzen, soldat: Soldat,  rucksack: MutableList<String>){
    var kaempfer = mutableListOf(sani, sniper, soldat)
    do {


        if (!boss.dead && !sani.dead && !sniper.dead && !soldat.dead) {
            var fight = kaempfer.random()
            println(
                "Das Team hat einen Rucksack dabei. in diesem sind 3x Heiltränke die 50 Lebenspunkte geben und 1x Vitamine, für 10%mehr schaden. " +
                        "möchtest du etwas davon wählen? J/N"
            )
            var inhaltNehmen = readln().uppercase()
            if (inhaltNehmen == "J") {
                auswahlTreffen(rucksack, sani, sniper, soldat)
            } else {
                println(
                    "${sani.name} hat noch ${sani.lebensPunkte} Leben. Bitte wähle eine Attacke: \n 1 um Team heilen, " +
                            "\n 2 für einmalige wiederbelebung, \n 3 um Molotov werfen, " +
                            "\n4 für verschieesen eines Magazin mit MP"
                )

                sani.attacke(boss, soldat, sniper)
                println("---------------------------------------")
            }
            println(
                "Das Team hat einen Rucksack dabei. in diesem sind 3x Heiltränke die 50 Lebenspunkte geben und 1x Vitamine, für 10%mehr schaden. " +
                        "möchtest du etwas davon wählen? J/N"
            )
            var inhaltNehmen1 = readln().uppercase()
            if (inhaltNehmen1 == "J") {
                auswahlTreffen(rucksack, sani, sniper, soldat)
            } else {
                println(
                    "${sniper.name} hat noch ${sniper.lebensPunkte} Leben. Bitte wähle eine Attacke: \n 1 für eine Headshot, " +
                            "\n 2 für einen doubleshot, \n 3 um in den Tarnmodus zu gehen, " +
                            "\n4 um ein Wurfmesser zu werfen"
                )
                sniper.attack(boss, sniper)
                println("---------------------------------------")
            }
            println(
                "Das Team hat einen Rucksack dabei. in diesem sind 3x Heiltränke die 50 Lebenspunkte geben und 1x Vitamine, für 10%mehr schaden. " +
                        "möchtest du etwas davon wählen? J/N"
            )
            var inhaltNehmen2 = readln().uppercase()
            if (inhaltNehmen2 == "J") {
                auswahlTreffen(rucksack, sani, sniper, soldat)
            } else {
                println(
                    "${soldat.name} hat noch ${soldat.lebensPunkte} Leben. Bitte wähle eine Attacke: " +
                            "\n 1 um eine Granate zu werfen, \n 2 für einen Nahkampf angriff, " +
                            "\n 3 um ein ganzes Magazin zu verschiessen, \n4 um einen Spaten zu werfen"
                )
                soldat.attack(boss, soldat)
                println("---------------------------------------")
            }
            boss.attacke(boss, fight)
            println("---------------------------------------")
            sniper.tarnModus = false
               /*      if (miniBoss.miniBossSpawned) {
                println(
                    "${sani.name} ist am zug wähle eine Attacke: \n 1 um Team heilen, " +
                            "\n 2 für einmalige wiederbelebung, \n 3 um Molotov werfen, " +
                            "\n4 für verschieesen eines Magazin mit MP"
                )
                sani.attacke(miniBoss, soldat, sniper)
                println(
                    "${sniper.name} ist am zug wähle eine Attacke: \n 1 für eine Headshot, " +
                            "\n 2 für einen doubleshot, \n 3 um in den Tarnmodus zu gehen, " +
                            "\n4 um ein Wurfmesser zu werfen"
                )
                sniper.attack(miniBoss, sniper)
                println(
                    "${soldat.name} ist am zug wähle eine Attacke: " +
                            "\n 1 um eine Granate zu werfen, \n 2 für einen Nahkampf angriff, " +
                            "\n 3 um ein ganzes Magazin zu verschiessen, \n4 um einen Spaten zu werfen"
                )
                soldat.attack(miniBoss, soldat)
                miniBoss.attack(miniBoss, fight)

                */    }

        }
    while (gameOver(boss, sniper, soldat, sani))

}

fun gameOver(ziel1: Endgegner, ziel2: Scharfschuetzen, ziel3: Soldat, ziel4: Sanitaeter):Boolean {
    if (ziel1.lebensPunkte <= 0) {
        println("Der Freidhofs Wächter kommt ins schwanken und fällt zu Boden. Der Boden öffnet sich und der Wächter versinkt. Der Kampf ist gewonnen!")
        return false
    }
    else if (ziel2.lebensPunkte <= 0 && ziel3.lebensPunkte <= 0 && ziel4.lebensPunkte <= 0) {
        println("Der Friedhofs Wächter lacht und sagt 'wieder hat jemand versagt. Nichts und niemand kann mich auf halten'  Game Over")
        return false
    }
    return true
}