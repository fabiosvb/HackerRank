package artificialIntelligence.botBuilding
import scala.io.StdIn
import java.util.Scanner
import scala.util.Random
import scala.collection.mutable.ArrayBuffer


// I believe to win the game is necessary to save the state in a file.
object BotCleanPartiallyObservable {
    val DIRTY = 'd'

    def main(args: Array[String]): Unit = {
        val in = new Scanner(System.in)

        var line = in.nextLine().split(" ")
        var bot = (line(0).toInt, line(1).toInt)

        val grid = Array.ofDim[Char](5, 5)

        for (i <- 0 until 5) grid(i) = in.nextLine().toCharArray()

        var board = Board(grid)
        println(board.move(bot).movement.name())

    }

    sealed trait Movement {
        def name(): String
    }
    case object LEFT extends Movement { def name() = "LEFT" }
    case object RIGHT extends Movement { def name() = "RIGHT" }
    case object UP extends Movement { def name() = "UP" }
    case object DOWN extends Movement { def name() = "DOWN" }
    case object CLEAN extends Movement { def name() = "CLEAN" }
    case object NONE extends Movement { def name() = "NONE" }

    case class Board(grid: Array[Array[Char]]) {
        var movement: Movement = NONE

        def this(grid: Array[Array[Char]], mov: Movement) {
            this(grid)
            this.movement = mov
        }

        def move(bot: (Int, Int)): Board = {

            if (grid(bot._1)(bot._2) == DIRTY) {
                return new Board(this.grid, CLEAN)
            }

            while (this.movement == NONE) {
                var dirty = findObject(bot)

                if (!isValidPosition(dirty)) {
                    dirty = randomPosition(bot)
                }

                if (shouldMoveRight(bot, dirty) && canMoveRight(bot)) {
                    movement = RIGHT
                } else if (shouldMoveLeft(bot, dirty) && canMoveLeft(bot)) {
                    movement = LEFT
                } else if (shouldMoveUp(bot, dirty) && canMoveUp(bot)) {
                    movement = UP
                } else if (shouldMoveDown(bot, dirty) && canMoveDown(bot)) {
                    movement = DOWN
                }
            }
            return new Board(grid, this.movement)
        }

        private def findObject(robot: (Int, Int)): (Int, Int) = {
            
            def manhattanDistance(a : (Int, Int), b : (Int, Int)) : Int = {
                return Math.abs(a._1 - b._1) + Math.abs(a._2 - b._2)
            }
            var position = (grid.length * 3, grid.length * 3);

            for (i <- 0 until grid.length; j <- 0 until grid(i).length)
                if (grid(i)(j) == DIRTY) {
                    val delta = manhattanDistance(robot, position)
                    val deltaDirty = manhattanDistance(robot, (i,j))
                    if (deltaDirty < delta) {
                        position = (i, j)
                    }
                }
            return position
        }

        private def randomPosition(bot: (Int, Int)): (Int, Int) = {
            val position = bot match {
                case (1, 1) => (1, 3)
                case (1, 3) => (3, 3)
                case (3, 3) => (3, 1)
                case (3, 1) => (1, 1)
                case _ => randomPosition()
            }
            return position
        }

        private def randomPosition(): (Int, Int) = {
            val random = new Random().nextInt(4) + 1
            val position = random match {
                case 1 => (1, 1)
                case 2 => (1, 3)
                case 3 => (3, 3)
                case 4 => (1, 3)
            }
            return position
        }

        def shouldMoveUp(from: (Int, Int), to: (Int, Int)) = from._1 > to._1
        def shouldMoveDown(from: (Int, Int), to: (Int, Int)) = from._1 < to._1

        def shouldMoveLeft(from: (Int, Int), to: (Int, Int)) = from._2 > to._2
        def shouldMoveRight(from: (Int, Int), to: (Int, Int)) = from._2 < to._2

        def canMoveRight(position: (Int, Int)) = position._2 + 1 < grid(position._1).length
        def canMoveLeft(position: (Int, Int)) = position._2 - 1 >= 0

        def canMoveDown(position: (Int, Int)) = position._1 + 1 < grid.length
        def canMoveUp(position: (Int, Int)) = position._1 - 1 >= 0

        def isValidPosition(position: (Int, Int)) = position._1 >= 0 && position._2 >= 0 && position._1 < grid.length && position._2 < grid(position._1).length

    }

}

