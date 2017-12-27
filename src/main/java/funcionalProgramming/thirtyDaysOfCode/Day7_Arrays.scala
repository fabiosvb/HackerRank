package funcionalProgramming.thirtyDaysOfCode

object Day7_Arrays {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var n = sc.nextInt();
        var arr = new Array[Int](n);
        for(arr_i <- 0 until n) {
           arr(arr_i) = sc.nextInt();
        }
        arr.reverse.foreach(value => print(value + " "))
    }
}
