import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj
import io.vertx.kotlin.coroutines.CoroutineVerticle
import kotlinx.coroutines.launch

class ServerVerticle: CoroutineVerticle() {
    override suspend fun start() {
        val router = router()
        vertx.createHttpServer()
            .requestHandler(router)
            .listen(8081)
        println("Serving on port 8081")
    }

    private fun router(): Router {
        val router = Router.router(vertx)
        router.get("/status").handler { ctx ->
            val response = json {
                obj (
                    "status" to "OK"
                )
            }

            ctx.response()
                .setStatusCode(200)
                .end(response.toString())
        }

        router.mountSubRouter("/cats", catsRouter())
        return router
    }

    private fun catsRouter(): Router {
        val router = Router.router(vertx)
        router.route().handler(BodyHandler.create())
        router.delete("/:id").handler { ctx ->
            launch {
                val id = ctx.request().getParam("id").toInt()
                vertx.eventBus().request<Nothing>("cats:delete", id) {
                    ctx.response().setStatusCode(200).end()
                }
            }
        }
        router.put("/:id").handler { ctx ->
            launch {
                val id = ctx.request().getParam("id").toInt()
                val body = ctx.bodyAsJson.mergeIn(json {
                    obj("id" to id)
                })
                vertx.eventBus().request<Int>("cats:update", body) { res ->
                    ctx.response().setStatusCode(200).end(json {
                        obj("id" to res.result().body())
                    }.toString())
                }
            }
        }
        return router
    }
}