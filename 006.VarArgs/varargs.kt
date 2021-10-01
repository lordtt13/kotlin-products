// vararg allows us to put as many args of type mentioned
// with vararg in our call, including 0 of that type
// vararg behaves like an Array
fun sum(vararg number: Int):Int {
  var total = 0
  for (n in number){
    total += n
  }
  return total
}

fun main(){
  println(sum(1,2,3,4,5))

  // * spreads array, though not list
  val array = intArrayOf(4,5)
  println(sum(1,2,3,*array))

  val list = listOf(1,2,3,4,5)
  sum(*list.toIntArray())
}