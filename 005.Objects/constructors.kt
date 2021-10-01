class MutableNameAlien(var name: String)
// val constructor cannot be changed
class FixedNameAlien(val name: String)

fun main(){
  // val & vars are references to objects
  val alien1 = MutableNameAlien("Anshuman")
  val alien2 = FixedNameAlien("Tanmay")

  println(alien2.name)

  alien1.name = "Anusha"
  println(alien1.name)
}