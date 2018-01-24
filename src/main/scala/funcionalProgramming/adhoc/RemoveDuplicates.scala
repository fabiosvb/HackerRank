package funcionalProgramming.adhoc

import scala.io.StdIn

object RemoveDuplicates {
    def main(args: Array[String]): Unit = {
        println(StdIn.readLine().distinct)
    }
    
}