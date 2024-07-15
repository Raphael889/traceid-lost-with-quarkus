package org.acme

import io.smallrye.mutiny.Uni
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Path("/hello")
class GreetingResource {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {
        log.info("GreetingResource.hello")
        return "Hello from Quarkus REST"
    }

    @GET
    @Path("/uni")
    @Produces(MediaType.TEXT_PLAIN)
    fun helloWithUni(): Uni<String> {
        log.info("GreetingResource.helloWithUni")
        return Uni.createFrom().item("Hello from Quarkus REST")
    }

}