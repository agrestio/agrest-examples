package io.agrest.example;

import io.agrest.cayenne.AgCayenneBuilder;
import io.agrest.cayenne.AgCayenneModule;
import io.agrest.jaxrs3.AgJaxrsFeature;
import io.agrest.runtime.AgRuntime;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api/*")
public class Application extends ResourceConfig {

    public Application() {

        ServerRuntime cayenneRuntime = ServerRuntime.builder()
                .addConfig("cayenne-project.xml")
                .build();

        // configure Cayenne extension
        AgCayenneModule cayenneModule = AgCayenneBuilder.build(cayenneRuntime);

        // Builder Agrest runtime
        AgRuntime runtime = AgRuntime.builder().module(cayenneModule).build();

        // Connect Agrest runtime with JAX RS runtime
        AgJaxrsFeature feature = AgJaxrsFeature.builder().runtime(runtime).build();

        register(feature);
        packages("io.agrest.example.api");
    }
}
