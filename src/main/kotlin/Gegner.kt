open class Gegner(name: String, hp: Int, skills: List<Skill>, item: List<Item>) : Held(name, hp, skills, item) {

    fun attackieren(skill: Skill, team: Team) {
        if (skill.fleachenschaden) {
            for (held in team.helden) {
                held.hp -= skill.damage
            }
            println("${this.name} hat Flächenschaden basierenden Skill, namens '${skill.name}' verwendet. Alle noch lebenden Helden wurden mit ${skill.damage} Schaden getroffen.")
        } else {
            val held = team.helden.random()
            held.hp -= skill.damage
            println("${this.name} attackiert ${held.name} mit '${skill.name}' und verursacht ${skill.damage} Schaden.")
        }
    }
}