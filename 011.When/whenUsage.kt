class Coordinates {
  var x: Int = 0
    set(value) {
      println("x gets $value")
      field = value
    }
  var y: Int = 0
    set(value) {
      println("y gets $value")
      field = value
    }
  override fun toString() = "($x, $y)"
}

fun processInputs(inputs: List<String>) {
  val coordinates = Coordinates()
  for (input in inputs) {
    when (input) {                   
      "up", "u" -> coordinates.y--   
      "down", "d" -> coordinates.y++
      "left", "l" -> coordinates.x--
      "right", "r" -> {              
        println("Moving right")
        coordinates.x++
      }
      "nowhere" -> {}                
      "exit" -> return            
      else -> println("bad input: $input")
    }
  }
}

// when can be used without args, with boolean
fun bmiMetricWithWhen(
  kg: Double,
  heightM: Double
): String {
  val bmi = kg / (heightM * heightM)
  return when {
    bmi < 18.5 -> "Underweight"
    bmi < 25 -> "Normal weight"
    else -> "Overweight"
  }
}

fun main() {
  println(processInputs(listOf("up", "d", "nowhere",
    "left",  "right", "exit", "r")))

  println(bmiMetricWithWhen(72.57, 1.727))
}