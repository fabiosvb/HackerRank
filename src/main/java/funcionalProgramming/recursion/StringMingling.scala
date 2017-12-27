package funcionalProgramming.recursion

import scala.io.StdIn

object StringMingling {
  
    def main(args: Array[String]): Unit = {
          val word1 = StdIn.readLine()
          val word2 = StdIn.readLine()
          println(word1.zipWithIndex.map( (x) => x._1 + ""+ word2(x._2.asInstanceOf[Int])).mkString);
    }
}