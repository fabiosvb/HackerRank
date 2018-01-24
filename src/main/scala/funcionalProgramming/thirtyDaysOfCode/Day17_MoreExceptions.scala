package funcionalProgramming.thirtyDaysOfCode

import scala.io.StdIn

object Day17_MoreExceptions {

    class Calculator {
        def power (n : Int, p : Int) : Int = {
            if (n < 0 || p < 0){
                throw new Exception("n and p should be non-negative");
            } 
            return Math.pow(n, p).toInt;
        }    
    }
    
    
    def main(args: Array[String]): Unit = {
        var myCalculator = new Calculator();
        var T=scala.io.StdIn.readLine().toInt

        while(T>0){
            val Array(n,p) = scala.io.StdIn.readLine().split(" ").map(_.toInt);
            try{
                  var ans=myCalculator.power(n,p);
                  println(ans);
            }
            catch{
                case e: Exception => {
                    println(e.getMessage());
                }
            }
            T-=1;
        }
    }
}
