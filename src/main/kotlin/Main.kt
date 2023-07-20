import kotlin.Exception

fun main() {
    // Erstelle ein Team bestehend aus drei Helden
    val team = Team(
        mutableListOf(
            Teemo("Teemo", 100, teemoSkills, inventar),
            Ashe("Ashe", 120, asheSkills, inventar),
            Lux("Lux", 130, luxSkills, inventar)
        )
    )

    // Erstelle einen Gegner
    val gegner = Gegner("Baron Nashor", 400, gegnerSkills, inventar)

    // Starte leichte Informationsausgabe
    println("Es kämpfen heute folgende Helden:")

    // Gehe durch das Team und gebe den Namen und HP Wert jedes einzelnen Helden aus
    for (i in team.helden) {

        println("${SchriftFarben.BLUE}${i.name} - HP: ${i.hp}${SchriftFarben.RESET}")
    }

    println("__________________________________")

    println("Sie kämpfen gegen folgenden Gegner:")

    println("${SchriftFarben.RED}${gegner.name} - HP: ${gegner.hp}${SchriftFarben.RESET}")

    println("__________________________________")

    Thread.sleep(1500)

    println("Nun kann der Kamp beginnen.")

    println("__________________________________")

    Thread.sleep(1000)

    println("${SchriftFarben.GREEN_BOLD}FIGHT${SchriftFarben.RESET}")

    println("__________________________________")


    do {

        if (team.helden.isEmpty()) {
            println("Alle Helden sind tot!\nDer Gegner hat gewonnen.")
            break
        }

        if (gegner.wasted()) {
            println("Der Gegner ist tot!\nDie Helden haben gewonnen.")
            break
        }
        var counter = 0

        println("Bitte wähle einen Helden aus!")

        for (i in team.helden) {

            counter++

            println("[$counter] - Name: ${i.name} - HP: ${i.hp}")
        }

        var indexHeld = 0
        var ausgewählterHeld: Held

        do {
            try {
                indexHeld = readln().toInt()
                if (indexHeld > team.helden.size || indexHeld < 1)
                    throw Exception("Held nicht verfügbar - Try again!")
            } catch (exception: Exception) {
                println(exception.message) //Es wird der String der Exeption ausgegeben.
            }
        } while (indexHeld > team.helden.size || indexHeld < 1) //Die Bedingung für die do-Schleife für die Exeption.

        ausgewählterHeld = team.helden[indexHeld - 1]

        println("Inventar = 1\nSkills = 2")

        var auswahl = readln() //Die ausgewählte Option wird eingelesen.

        if (auswahl == "1") {

            counter = 0

            for (i in ausgewählterHeld.item) {

                counter++
                println("[$counter] - Itemname: ${i.name} - Wert:[${i.wert}]")
            }
            var indexItem = 0
            var ausgewähltesItem: Item

            do {
                try {
                    indexItem = readln().toInt()
                    if (indexItem > ausgewählterHeld.item.size || indexItem < 1) {
                        throw Exception("Skill nicht verfügbar - Try again!")
                    }
                } catch (exception: Exception) {
                    println(exception.message) // Es wird der String der Exeption ausgegeben.
                }
            } while (indexItem > ausgewählterHeld.item.size || indexItem < 0) // Bedingung der do-Schleife für die Exeption.

            //Item ausgewählt
            ausgewähltesItem = ausgewählterHeld.item[indexItem - 1]

            println("-------------------")

            //Das ausgewählte Item wird angewendet.

            ausgewählterHeld.useItem(ausgewähltesItem)

            println("-------------------")

            println("${ausgewählterHeld.name} wendet ${ausgewähltesItem.name} an.")

            println("-------------------")

            println("${gegner.name}'s HP: ${gegner.hp}")

            println("---------------------------")

            //Wenn der Gegner nicht besiegt ist attackiert er einen zufälligen Helden.
            if (!gegner.wasted()) {
                gegner.attackieren(gegner.skills.random(), team)
            }
            //removeIf durchläuft meine Liste mit der Lambda-Funktion, welche an die Bedingung wasted gekoppelt ist.
            //Ist wasted() = true wird der damit angesprochene Held aus meiner Liste entfernt. Kleine Hilfe von ChatGBT war da für die removeIF-Funktion.
            team.helden.removeIf { it.wasted() }  // removeIF habe ich von ChatGBT

        } else if (auswahl == "2") //Die ausgewählte Option wird eingelesen.

        // Skill-Schleife
            try {

                counter = 0

                for (i in ausgewählterHeld.skills) {

                    counter++
                    println("[$counter] - Skillname: ${i.name} - DMG:[${i.damage}]")
                }

                var indexSkill = 0
                var ausgewählterSkill: Skill

                // Der Index wird eingelesen und es wird eine Fehlermeldung abgefangen.

                do {
                    try {
                        indexSkill = readln().toInt()
                        if (indexSkill > ausgewählterHeld.skills.size || indexSkill < 1) {
                            throw Exception("Skill nicht verfügbar - Try again!")  //Wenn die Index-Auswahl größer als die Liste oder kleiner als 1 ist -> Falsche Auswahl.
                        }
                    } catch (exception: Exception) {
                        println(exception.message) // String der Exeption wird ausgegeben.
                    }
                } while (indexSkill > ausgewählterHeld.skills.size || indexSkill < 0) // Bedingung für do-Schleife.

                //Der Index wird von ausgewähltem Skill wird ausgewählt.
                ausgewählterSkill = ausgewählterHeld.skills[indexSkill - 1]

                println("-------------------")

                //Held greift Gegner mit ausgewähltem Skill an.
                ausgewählterHeld.attackieren(ausgewählterSkill, gegner)

                println("-------------------")

                println("${ausgewählterHeld.name} attackiert ${gegner.name} mit ${ausgewählterSkill.name} und fügt ihm ${ausgewählterSkill.damage} zu.")

                println("${gegner.name}'s HP: ${gegner.hp}")

                println("---------------------------")

                //Wenn der Gegner nicht besiegt ist attackiert er einen zufälligen Helden.
                if (!gegner.wasted()) {
                    gegner.attackieren(gegner.skills.random(), team)
                }
                //Held wird aus der Liste entfernt, wenn er besiegt ist.
                team.helden.removeIf { it.wasted() }
            } catch (ex: Exception) {  // Das ist der Catch, für den allgemeine Code vom try für die Skill-Schleife.
                println("try again")
            }
    } while (true) // Das ist die Bedingung für die allgemeine do-Schleife des Spiels, damit der Code ausgeführt wird. Deshalb ist der Boolean auf true gesetzt.
}



