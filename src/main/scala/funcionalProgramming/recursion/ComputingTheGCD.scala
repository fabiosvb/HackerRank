package funcionalProgramming.recursion

import java.util.Scanner

object ComputingTheGCD {

    def main(args: Array[String]): Unit = {
        val lines : Scanner = new Scanner(System.in)
        val value1: Int = lines.nextInt()
        val value2: Int = lines.nextInt()

        print(gcd(value1, value2));
    }

    def gcd(x: Int, y: Int): Int = {
        val max = if (x > y)  x else y;
        val min = if (x > y)  y else x;
        val mod = max % min;
        if (mod == 0){
            return min;
        }
        return gcd(min, mod);
    }
}