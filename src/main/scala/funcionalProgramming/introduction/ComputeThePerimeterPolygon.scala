package introduction

import scala.io.StdIn

object ComputeThePerimeterPolygon {
    
    def main(args: Array[String]): Unit = {
        var points : Array[Point] = Array();
        
        io.Source.stdin.getLines().drop(1).map(_.split(" ")).foreach( (x) => points :+= new Point(x(0).toInt, x(1).toInt) )
        
        points :+= points.head
        
        var perim = points.foldLeft(points.head)( (a, p) => new Point(p, a.sum + distance(a, p)))
        
       println(perim.sum)
    }
    
    def distance( p1: Point, p2:Point): Double = {
          math.sqrt(math.pow(p1.x - p2.x, 2) + math.pow(p1.y - p2.y, 2))
    }

}

class Point (px : Int, py : Int){
    var x = px;
    var y = py;
    var sum : Double = 0;
    
    def this(prev : Point, sum : Double){
        this(prev.x, prev.y)
        this.sum = sum
    }
}