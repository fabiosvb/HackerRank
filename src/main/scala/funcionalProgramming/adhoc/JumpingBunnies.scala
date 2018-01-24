package funcionalProgramming.adhoc

object JumpingBunnies {
    def main(args: Array[String]): Unit = {
        val list = io.Source.stdin.getLines().drop(1).take(1).mkString.split(" ").map(_.toInt)
        val result = list.foldLeft(1.toLong)( lcm(_,_) )
        println(result)
    }
    
    def lcm (a : Long, b : Long) : Long = {
        return a * (b / gcd(a, b));
    }
    
    def gcd (value1 : Long, value2 : Long) : Long = {
        var a = value1
        var b = value2
        while (b > 0){
            var temp = b;
            b = a % b; 
            a = temp;
        }
        return a;
    }
}