package funcionalProgramming.thirtyDaysOfCode

import scala.io.StdIn

object Day3_IntroToConditionalStatements {
    def main(args: Array[String]) {
        val n: Int = StdIn.readInt();
        var ans = "";
        if (n % 2 == 1) {
            ans = "Weird";
        } else if (n >= 2 && n <= 5) {
            ans = "Not Weird";
        } else if (n >= 6 && n <= 20) {
            ans = "Weird";
        } else {
            ans = "Not Weird";
        }
        println(ans);

    }
}