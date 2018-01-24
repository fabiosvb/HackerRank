package funcionalProgramming.thirtyDaysOfCode

import scala.io.StdIn

object Day8_DictionariesAndMaps {

    def main(args: Array[String]) {
        val map = scala.collection.mutable.Map[String, String]()
        val lines = io.Source.stdin.getLines()
        
        val n = lines.next().toInt
        
        lines.take(n).map(_.split(" ")).foreach(s => {
            map += (s(0) -> s(1))
        })        
        
        lines.take(n).foreach(s => {
            var phone = map.get(s)
            if (phone == None) 
                println("Not found") 
            else
                println(s +"="+phone.get)     
        })        
        
    }
}
