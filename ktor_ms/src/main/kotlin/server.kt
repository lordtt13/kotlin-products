import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    embeddedServer(CIO, port = 8080, module = Application::serverApplicationModule).start(wait = true)
    println("Server running on port 8080")
}

fun Application.serverApplicationModule() {
    DB.connect()
    transaction {
        SchemaUtils.create(CatsTable)
    }

    install(ContentNegotiation) {
        json()
    }
    routing {
        get("/status") {
            call.respond(mapOf("status" to "OK"))
        }
        cats()
    }
}