package funcionalProgramming.thirtyDaysOfCode

import scala.io.StdIn

object Day2_Operators {
    def main(args: Array[String]) {
        val mealCost : Double = StdIn.readDouble()
        val tipPercent : Int = StdIn.readInt()
        val taxPercent : Int = StdIn.readInt()

        val tip : Double  = mealCost * tipPercent / 100
        val tax : Double  = mealCost * taxPercent / 100

        val cost : Int =  Math.round(mealCost + tip + tax).toInt;

        println(s"The total meal cost is $cost dollars.");

    }
}