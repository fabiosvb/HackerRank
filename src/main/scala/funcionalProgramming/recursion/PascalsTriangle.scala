package funcionalProgramming.recursion

import scala.io.StdIn

object PascalsTriangle {
    def main(args: Array[String]): Unit = {
        val maxLevel = StdIn.readInt();
        triangle(1, maxLevel, Array());
    }
    
    def triangle(level : Int, max : Int, arr : Array[Int]) : Unit = {
        var arr_ : Array[Int] = Array[Int](1)
        if (level > 1){
            for (i <- 0 until arr.length - 1) arr_ +:= arr(i) + arr(i + 1)    
            arr_ +:= 1
        }

        println(arr_.mkString(" "))
        if (level < max){
            triangle(level + 1, max, arr_);
        }
    }
}