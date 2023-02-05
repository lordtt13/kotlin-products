import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun Routing.cats() {
    route("/cats"){
        get {
            val cats = transaction { CatsTable.selectAll().map {
                    row -> Cat(row[CatsTable.id].value, row[CatsTable.name], row[CatsTable.age])
            } }
            if (cats.isEmpty()){
                call.respond(HttpStatusCode.NotFound)
            } else {
                call.respond(cats)
            }
        }
        get("/{id}") {
            val id = requireNotNull(call.parameters["id"]).toInt()
            val cat = transaction { CatsTable.select(CatsTable.id.eq(id)).firstOrNull() }
            if (cat != null) {
                call.respond(
                    Cat(
                        id,
                        cat[CatsTable.name],
                        cat[CatsTable.age]
                    ))
            }
        }
        post {
            val params = call.receiveParameters()
            val name = requireNotNull(params["name"])
            val age = params["age"]?.toInt() ?: 0
            transaction {
                CatsTable.insert { cat ->
                    cat[CatsTable.name] = name
                    cat[CatsTable.age] = age
                }
            }
            call.respond(HttpStatusCode.Created)
        }
    }
}