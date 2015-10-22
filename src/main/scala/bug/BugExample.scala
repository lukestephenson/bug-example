package bug

sealed trait Action[A]
case object GetString extends Action[String]
case object GetInteger extends Action[Int]

object BugExample {
  // Both of the matches below show a compilation error in intellij, but the code
  // compiles and runs with no issues
  def execute[A](action: Action[A]): A = action match{
    case GetString => "hello"
    case GetInteger => 5
  }

  def main(args: Array[String]) = {
    println(execute(GetString))
    println(execute(GetInteger))
  }
}
