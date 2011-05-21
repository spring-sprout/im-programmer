trait ActionType { def desc: String }
case object GoForward extends ActionType { def desc = "Move to" }
case object GoBack extends ActionType { def desc = "Move to" }
case object Push extends ActionType { def desc = "Push   " }
case object Stay extends ActionType { def desc = "Stay at" }

class Bot(val name:String, val location: Int, val buttons: List[(String, Int)]) {

  def action(button:(String, Int)): Bot = {
      val nextBot = nextStep(button) match {
        case GoForward => new Bot(name, location + 1, buttons)
        case GoBack => new Bot(name, location - 1, buttons)
        case Push => new Bot(name, location, buttons.tail)
        case _ => new Bot(name, location, buttons)
      }
      nextBot
  }

  def nextStep(button:(String, Int)): ActionType = {
    if(buttons == Nil) Stay
    else if(location < buttons.head._2) GoForward
    else if(location > buttons.head._2) GoBack
    else if(button == buttons.head) Push
    else Stay
  }

}

class BotTrust(val inputText: String) {

  val logging = true

  private def buttonParsing(input: List[String], output: List[(String, Int)]): List[(String, Int)] = {
    if(input == Nil) output
    else buttonParsing(input.slice(2, input.size), output:+(input.head.toLowerCase, input(1).toInt))
  }

  private def turn(time:Int, buttons: List[(String, Int)], orange:Bot, blue:Bot): Int = {
    if(buttons == Nil) time
    else {
      if(logging) {
        val blue_ = blue.action(buttons.head)
        val orange_ = orange.action(buttons.head)

        print("Time: %s, ".format((time+1).toString.padTo(3, ' ')))
        print("Orange: %s button %d, ".format(orange.nextStep(buttons.head).desc, orange_.location))
        println("Blue: %s button %d".format(blue.nextStep(buttons.head).desc, blue_.location))
      }

      if(blue.nextStep(buttons.head).equals(Push) || orange.nextStep(buttons.head).equals(Push)) 
        turn(time+1, buttons.tail, orange.action(buttons.head), blue.action(buttons.head))
      else
        turn(time+1, buttons, orange.action(buttons.head), blue.action(buttons.head))
    }
  }
  
  def processTime: Int = {
    val inputList = inputText.split(" ").toList
    val buttons = buttonParsing(inputList.tail, List[(String, Int)]())
  
    if(inputList.head.toInt != buttons.size)
      throw new RuntimeException("button count error!")

    if(logging)
      println("input text: %s".format(inputText))

    turn(0, buttons, new Bot("orange", 1, buttons.filter( x => x._1 == "o")), new Bot("blue", 1, buttons.filter( x => x._1 == "b")))
  }

}

object BotTrust {

  import scala.io.Source
  
  def main(args:Array[String]) {
    if (args.length > 0) {
      var input = List[String]() 
      for (line <- Source.fromFile(args(0)).getLines)
        input = input:+line
     
      if(input.head.toInt != input.tail.size)
        throw new RuntimeException("input count error!")
     
      var result = List[String]()

      var caseIdx = 0
      input.tail.foreach( value => {  
        caseIdx = caseIdx + 1
        result = result:+"Case #%d: %d".format(caseIdx, new BotTrust(value).processTime)
      })
      
      println("")
      println("result: ")
      result.foreach( x => println(x) )
    }
    else
      println("ex. scala BotTrust inputFile")
  }

}
