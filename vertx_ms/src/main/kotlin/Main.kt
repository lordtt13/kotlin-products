import io.vertx.core.Vertx

fun main() {
    val vertx = Vertx.vertx()
    vertx.deployVerticle(ServerVerticle())
    vertx.deployVerticle(CatsVerticle())
}