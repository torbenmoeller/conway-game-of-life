import hello.Board
import hello.nextBoard
import org.junit.Test

class BoardTest {


    @Test
    fun foo() {
        val board = Board(3)
        board.setCellAlive(1,0)
        board.setCellAlive(1,1)
        board.setCellAlive(1,2)

        board.print()

        nextBoard(board).print()

    }
}