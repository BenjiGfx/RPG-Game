class Team(var helden: MutableList<Held>) {

    fun getRandomHeld(): Held {
        return helden.random()
    }
}