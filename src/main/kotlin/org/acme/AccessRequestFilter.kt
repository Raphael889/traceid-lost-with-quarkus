package org.acme

import io.opentelemetry.api.trace.Span
import io.quarkus.vertx.web.RouteFilter
import io.vertx.ext.web.RoutingContext
import jakarta.ws.rs.ext.Provider
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Provider
class AccessRequestFilter {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    @RouteFilter(100)
    fun filter(routingContext: RoutingContext) {
        val startTime = System.currentTimeMillis()
        val spanContext = Span.current().spanContext.isSampled
        log.info("AccessRequestFilter.filter start")

        routingContext.addEndHandler { _ ->
            log.info("AccessRequestFilter.filter stop ({} ms)", System.currentTimeMillis() - startTime)
        }

        routingContext.next()
    }

}
