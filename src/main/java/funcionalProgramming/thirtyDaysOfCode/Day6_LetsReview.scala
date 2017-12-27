package funcionalProgramming.thirtyDaysOfCode

object Day5_Loops {

    def main(args: Array[String]) {
        var s = "Hacker"
        io.Source.stdin.getLines().drop(1).foreach(s => { 
            print(s.zipWithIndex.filter( (x) => x._2 % 2 == 0).map(_._1).mkString)
            print(" ")
            println(s.zipWithIndex.filter( (x) => x._2 % 2 != 0).map(_._1).mkString)
        })
    }


}