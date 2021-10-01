fun multiplyByThree(x: Int): Int {
  return x*3
}

// Type inference in output
fun multiplyByFour(x: Int) = x*4

fun main(){
  println(multiplyByThree(5))
  println(multiplyByFour(5))
}