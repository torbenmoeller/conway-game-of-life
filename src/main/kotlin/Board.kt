package hello

class Board constructor(length: Int) {
    var board = arrayOf<Array<State>>()

    init {
        for (i in 1..length) {
            var array = arrayOf<State>()
            for (j in 1..length) {
                array += State.Dead
            }
            board += array
        }
    }

    fun print() {
        printHorizontalLine()

        for (array in board) {
            print("|")
            for (cell in array) {
                print(cell.toCmdString())
            }
            print("|\r\n")
        }

        printHorizontalLine()
    }

    private fun printHorizontalLine() {
        print("+")
        for (i in 1..board[1].size) {
            print("-")
        }
        print("+\r\n")
    }

    fun getNeighboursAlive(column: Int, row: Int): Int {
        var neighboursAlive = 0
        for (i in -1..1) {
            for (j in -1..1) {
                if (i == 0 && j == 0) {
                    continue
                }
                if (getCellState(column + j, row + i) == State.Alive) {
                    neighboursAlive++
                }
            }
        }
        return neighboursAlive
    }

    fun setCellAlive(column: Int, row: Int) {
        board[row][column] = State.Alive
    }

    fun getCellState(column: Int, row: Int): State {
        if (row < 0
                || column < 0
                || row  >= board.size
                || column >= board[1].size ) {
            return State.Dead
        }
        return board[row][column]
    }


    fun isAlive(state: State, neighboursAlive: Int): State {
        if (neighboursAlive == 2) {
            return state
        } else if (neighboursAlive == 3) {
            return State.Alive
        }
        //else <2 or >3
        return State.Dead
    }
}