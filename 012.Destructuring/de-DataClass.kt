// data classes are special, having inbuilt
// extension functions like copy or equals
data class Computation(
  val data: Int,
  val info: String
)

fun evaluate(input: Int) =
  if (input > 5)
    Computation(input * 2, "High")
  else
    Computation(input * 2, "Low")

fun main() {
  val (value, description) = evaluate(7)
  println(value == 14)
  println(description == "High")
}