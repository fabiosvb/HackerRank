package funcionalProgramming.thirtyDaysOfCode

import scala.io.StdIn
import scala.collection.mutable.ListBuffer

object Day18_QueuesAndStack {

   var stack = ListBuffer[Char]();
   var queue = ListBuffer[Char]();
   
   def pushCharacter(c : Char){
       
       stack +:= c;
   }
   
   def enqueueCharacter(c : Char){
        queue :+= c;        
   } 
    
   def popCharacter() : Char = {
       val value = stack(0);
       stack.remove(0);
       return value;
   }
   
   def dequeueCharacter() : Char = {
       val value = queue(0);
       queue.remove(0);
       return value;       
   }     
}
