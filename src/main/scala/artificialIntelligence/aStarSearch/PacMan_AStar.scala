package artificialIntelligence.aStarSearch

import java.util.Scanner
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.SortedSet
import java.security.cert.Extension

object PacMan_AStar {
    
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
        var queue = ListBuffer[Node]()
        var explored = ListBuffer[Node]()
        var foodNode: Node = null

        def manhattanDistance(a : (Int, Int), b : (Int, Int)) : Int = {
            return Math.abs(a._1 - b._1) + Math.abs(a._2 - b._2)
        }
        
        
        def findFood(): Boolean = {

            val visited = Array.ofDim[Boolean](grid.length, grid(0).length)

            
            def enqueue(current: (Int, Int), parent: Node, score: Int): Node = {
                visited(current._1)(current._2) = true
                return Node((current._1, current._2), parent, score)
            }
            
            queue :+= enqueue(pacman, null, 0)
            
            while (queue.size > 0) {
                var sortedQueue = List[Node]()
                for (current <- queue){
                    explored :+= current;
                    
                    if (grid(current._1)(current._2) == FOOD) {
                        foodNode = current
                        return true
                    } 
                    
                    if (canMoveUp(current.current) && !visited(current._1 - 1)(current._2)) {
                        val next = (current._1 - 1, current._2)
                        sortedQueue :+= enqueue(next, current, current.score + manhattanDistance(food, next))
                    }
                    
                    if (canMoveLeft(current.current) && !visited(current._1)(current._2 - 1)) {
                        val next = (current._1, current._2 - 1)
                        sortedQueue :+= enqueue(next, current, current.score + manhattanDistance(food, next))
                    }
                    
                    if (canMoveRight(current.current) && !visited(current._1)(current._2 + 1)) {
                        val next = (current._1, current._2 + 1)
                        sortedQueue :+= enqueue(next, current, current.score + manhattanDistance(food, next))
                    }
                    
                    if (canMoveDown(current.current) && !visited(current._1 + 1)(current._2)) {
                        val next = (current._1 + 1, current._2)
                        sortedQueue :+= enqueue(next, current, current.score + manhattanDistance(food, next))
                    }
               }
               sortedQueue.sortWith(_.score > _.score) 
                
               queue.clear();
               queue ++= sortedQueue
            }
            return false;
        }

        def printPath()  {
//            println(explored.size)
//            explored.foreach( n => println(n._1 + " " + n._2))

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
    
    case class Node(current : (Int, Int), parent : Node, score : Int = 1) {
        val _1 = current._1
        val _2 = current._2
        
    }
}