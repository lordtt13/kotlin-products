class Scientist(val name: String){
  override fun toString(): String{
    return "Scientist $name"
  }
}

fun main() {
  val s1 = Scientist("Tanmay")
  println(s1)
}