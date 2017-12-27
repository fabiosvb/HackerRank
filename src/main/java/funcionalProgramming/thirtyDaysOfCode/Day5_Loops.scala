package funcionalProgramming.thirtyDaysOfCode

object Day6_LetsReview {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner(System.in);
        var n = sc.nextInt();
        for (i <- 1 to 10) println(n + " x " + i + " = " + (n * i)) 
    }    

} 