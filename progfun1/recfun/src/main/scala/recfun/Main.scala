package recfun
import scala.collection.mutable.Stack

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if(c < 0 || r < 0) 0 
      else if (r == 0 && c == 0) 1
      else
        pascal(c-1,r-1) + pascal(c,r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def loop(stack: Stack[Char], str: List[Char]): Boolean = {
        if(str.isEmpty){
          if(stack.isEmpty){
            true
          }else{
            false
          }
        }else if(str.head == ')'){
        	if(stack.isEmpty){
        		false
        	}else{
        		stack.pop()
        		loop(stack,str.tail)
        	}
        }else if(str.head == '('){
          stack.push('(')
          loop(stack,str.tail)
        }else{
          loop(stack,str.tail)
        }
      }
      val stack = new Stack[Char] 
      loop(stack, chars)      
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if(money == 0)
        1
      else if(money > 0 && !coins.isEmpty){
        countChange(money-coins.head, coins) + countChange(money,coins.tail)
      }else{
        0
      }
    }
  }
