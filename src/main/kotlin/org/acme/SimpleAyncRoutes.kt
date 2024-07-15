package org.acme

import io.quarkus.vertx.web.Route
import io.quarkus.vertx.web.RouteBase
import io.vertx.ext.web.RoutingContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory


@RouteBase(
    path = "simple",
    produces = ["text/plain"]
)
class SimpleAyncRoutes {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Route(
        path = "ping",
        methods = [Route.HttpMethod.GET]
    )
    fun ping(routingContext: RoutingContext) {
        logger.info("SimpleAyncRoutes.ping")
        routingContext
            .response()
            .end("pong")
    }

    @Route(
        path = "fail",
        methods = [Route.HttpMethod.GET]
    )
    fun fail(routingContext: RoutingContext) {
        logger.info("SimpleAyncRoutes.fail")
        routingContext
            .fail(500)
    }
}
