class Book(val title: String)

// extend functionality on class
fun Book.categorize(category: String) = "title: $title, category: $category"

fun main(){
  print(Book("Atomic Kotlin").categorize("Programming"))
}