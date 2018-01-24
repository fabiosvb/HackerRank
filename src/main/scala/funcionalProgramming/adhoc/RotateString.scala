package funcionalProgramming.adhoc

object RotateString {
    def main(args: Array[String]): Unit = {
        io.Source.stdin.getLines().drop(1).foreach((line) => rotate(line));
    }
    
    def rotate(string: String) {
        var value = string
        var arr : Array[String] = Array();
        for (i <- 1 to string.length()){ 
            value = value.tail + value.head
            arr :+= value
        }
        println(arr.mkString(" "))
    }
}