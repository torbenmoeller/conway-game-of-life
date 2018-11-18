package hello

fun main(args:Array<String>) {
    var board = Board(35)
    board.setCellAlive(14,14)
    board.setCellAlive(14,13)
    board.setCellAlive(14,12)
    board.setCellAlive(15,12)
    board.setCellAlive(16,14)
    board.setCellAlive(16,13)
    board.setCellAlive(16,12)
    board.setCellAlive(14,16)
    board.setCellAlive(14,17)
    board.setCellAlive(14,18)
    board.setCellAlive(15,18)
    board.setCellAlive(16,18)
    board.setCellAlive(16,17)
    board.setCellAlive(16,16)



    printGeneration(board, 0)
    for (gen in 1..55) {
        val nextboard = nextBoard(board)
        printGeneration(nextboard, gen)
        board = nextboard
        Thread.sleep(500)
    }
}

fun nextBoard(board: Board): Board{
    val nextboard = Board(35)
    for (rowIndex in 0 until board.board.size) {
        val row = board.board[rowIndex]
        for (columnIndex in 0 until row.size) {
            val neighboursAlive = board.getNeighboursAlive(columnIndex, rowIndex)
            val state = board.getCellState(columnIndex, rowIndex)
            if(board.isAlive(state, neighboursAlive ) == State.Alive){
                nextboard.setCellAlive(columnIndex, rowIndex)
            }
        }
    }
    return nextboard
}

fun printGeneration(board: Board, gen: Int){
    println("Generation: $gen")
    board.print()
}
