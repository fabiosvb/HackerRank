package artificialIntelligence.aStarSearch

import java.util.Scanner
import scala.collection.mutable.ListBuffer

object PacMan_BFS {
    
    val BLOCK = '%'
    val FOOD = '.'
    
    def main(args: Array[String]): Unit = {
        val in = new Scanner(System.in)

        var line = in.nextLine().split(" ")
        val pacman = (line(0).toInt, line(1).toInt)

        line = in.nextLine().split(" ")
        val food = (line(0).toInt, line(1).toInt)

        line = in.nextLine().split(" ")
        val grid = Array.ofDim[Char](line(0).toInt, line(1).toInt)

        for (i <- 0 until grid.length) grid(i) = in.nextLine().toCharArray()

        var board = Board(grid, pacman, food)

        if (board.findFood()) {
            board.printPath
        }
    }

    case class Board(grid: Array[Array[Char]], pacman: (Int, Int), food: (Int, Int)) {

        var map = Map[(Int, Int), (Int, Int)]()
        var queue = List[Node]()
        var explored = List[Node]()
        var foodNode: Node = null

        def findFood(): Boolean = {

            val visited = Array.ofDim[Boolean](grid.length, grid(0).length)

            
            def enqueue(current: (Int, Int), parent: Node): Node = {
                visited(current._1)(current._2) = true
                return Node((current._1, current._2), parent)
            }
            
            queue :+= enqueue(pacman, null)
            
            while (queue.size > 0) {
                var newQueue = List[Node]()
                for (current <- queue){
                    explored :+= current;
                    
                    if (grid(current._1)(current._2) == FOOD) {
                        foodNode = current
                        return true
                    } 
                    
                    if (canMoveUp(current.current) && !visited(current._1 - 1)(current._2)) {
                        newQueue :+= enqueue((current._1 - 1, current._2), current)
                    }
                    
                    if (canMoveLeft(current.current) && !visited(current._1)(current._2 - 1)) {
                        newQueue :+= enqueue((current._1, current._2 - 1), current)
                    }
                    
                    if (canMoveRight(current.current) && !visited(current._1)(current._2 + 1)) {
                        newQueue :+= enqueue((current._1, current._2 + 1), current)
                    }
                    
                    if (canMoveDown(current.current) && !visited(current._1 + 1)(current._2)) {
                        newQueue :+= enqueue((current._1 + 1, current._2), current)
                    }
               }
                queue = newQueue 
            }
            return false;
        }

        def printPath()  {
            println(explored.size)
            explored.foreach( n => println(n._1 + " " + n._2))

            var node = foodNode
            var path = List[Node]()
            while (node != null){
                path :+= node
                node = node.parent
            }
            println(path.size - 1)
            path.reverse.foreach( n => println(n._1 + " " + n._2))
        }

        def canMoveRight(position: (Int, Int)) = position._2 + 1 < grid(position._1).length && grid(position._1)(position._2 + 1) != BLOCK
        def canMoveLeft(position: (Int, Int)) = position._2 - 1 >= 0  && grid(position._1)(position._2 - 1) != BLOCK

        def canMoveDown(position: (Int, Int)) = position._1 + 1 < grid.length && grid(position._1 + 1)(position._2) != BLOCK
        def canMoveUp(position: (Int, Int)) = position._1 - 1 >= 0 && grid(position._1 - 1)(position._2) != BLOCK

    }
    
    case class Node(current : (Int, Int), parent : Node){
        val _1 = current._1
        val _2 = current._2
    }
}