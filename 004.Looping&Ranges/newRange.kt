fun showRange(x: IntProgression){
  for(i in x){
    println("Hey $i")
  }

  println("This was the range: $x")
  println()
}

fun main(){
  // repeat actions
  repeat(2){
    println("HI")
  }

  // includes end, here 5
  for (i in 1..5){
    println("Hey $i")
  }

  // excludes end, here 5
  for (i in 0 until 5){
    println("Hey $i")
  }

  // Reverse
  showRange(5 downTo 1)

  // step
  showRange(0 until 10 step 2)
}