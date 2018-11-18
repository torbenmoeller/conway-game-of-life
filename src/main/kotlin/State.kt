package hello

enum class State {
    Alive, Dead;

    fun toCmdString(): Char {
        return if (this == Alive)
            'X'
        else
            ' '
    }
}