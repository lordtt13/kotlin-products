val <T> List<T>.firstOrNull: T?
  get() = if (isEmpty()) null else this[0]

val List<*>.indices: IntRange
  get() = 0 until size

fun main() {
    // if I don't want to specify type in parametrization, use *,
    // although we wouldn't know any info when accessing the element
    val list: List<*> = listOf(1, 2)
    val any: Any? = list[0]
    println(any==1)

    println(listOf<String>("Anusha").firstOrNull=="Anusha")

    println(listOf('a', 'b', 'c', 'd').indices==0..3)
}