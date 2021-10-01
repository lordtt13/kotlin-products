class Contact
  (val name: String,
  val phone: String){
    override fun toString(): String{
      return "Contact($name, $phone)"
    }
  }

fun main(){
  val constants: Map<String, Double> = mapOf(
    "Pi" to 3.14,
    "e" to 2.718
  )

  val muts: MutableMap<String, Int> = mutableMapOf(
    "1" to 1,
    "2" to 2
  )

  muts["2"] = 22
  muts += "3" to 3

  val tanmay = Contact("Tanmay", "9140876412")
  val anusha = Contact("Anu", "9999999999")

  val contacts: Map<String, Contact> = mapOf(
    tanmay.phone to tanmay,
    anusha.phone to anusha
  )

  for((key, value) in constants){
    println("$key: $value")
  }

  println()

  for((key, value) in contacts){
    println("$key: $value")
  }
}