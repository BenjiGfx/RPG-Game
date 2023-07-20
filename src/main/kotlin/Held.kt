open class Held(var name: String, var hp: Int, var skills: List<Skill>, var item: List<Item>) {
    var hasVitamine = true

    // Mit this. spreche ich die var an, welche in dieser Class gespeichert wurde. (Im Falle, dass die gleiche var in einer anderen Class existiert.)

    fun attackieren(skill: Skill, gegner: Gegner) {
        if (this.hasVitamine) {
            gegner.hp -= (skill.damage.toDouble() * 1.1).toInt()
        } else {
            gegner.hp -= skill.damage
        }
    }

    fun wasted(): Boolean {
        if (this.hp <= 0)
            return true
        else return false
    }

    fun useItem(item: Item) {
        if (item.name == "Heiltrank") {
            this.hp += item.wert
        } else if (item.name == "Vitamin") {
            this.hasVitamine = true

        }
    }
}