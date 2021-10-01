fun main(){
  // adding types for verbosity
  val condition: Boolean = true
  println("${if (condition) 'a' else 'b'}")

  // can be used to give var values too 
  val status = 
  if(condition)
  22
  else 
  25

  println("$status")

  val x: Int = 11
  println("$x + 4 = ${x +4}")

  val s = "value"
  println("s = \"$s\".")
  println(""" s = "$s" .""")
}