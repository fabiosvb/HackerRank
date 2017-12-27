package funcionalProgramming.thirtyDaysOfCode

import scala.io.StdIn

object Day9_Recursion {

    def factorial(n: Int): Int =  {
        if (n <= 1){
            return n; 
        }
        return n  * factorial(n - 1);        
    }

    def factorial2(n: Int): Int =  {
        return Range.inclusive(1, n).fold(1)(_ * _);        
    }

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var n = sc.nextInt();
        val result = factorial2(n);
        println(result)
    }
}
