class Hamster(val name: String)

class Cage(private val maxCapacity: Int) {
  private val hamsters =
    mutableListOf<Hamster>()
  val capacity: Int
    get() = maxCapacity - hamsters.size
  val full: Boolean
    get() = hamsters.size == maxCapacity
  fun put(hamster: Hamster): Boolean =
    if (full)
      false
    else {
      hamsters += hamster
      true
    }
  fun take(): Hamster =
    hamsters.removeAt(0)
}

fun main() {
  val cage = Cage(2)
  println(cage.full == false)
  println(cage.capacity == 2)
  println(cage.put(Hamster("Alice")) == true)
  println(cage.put(Hamster("Bob")) == true)
  println(cage.full == true)
  println(cage.capacity == 0)
  println(cage.put(Hamster("Charlie")) == false)
  cage.take()
  println(cage.capacity == 1)
}