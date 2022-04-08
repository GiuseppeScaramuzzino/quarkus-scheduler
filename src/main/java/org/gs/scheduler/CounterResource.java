package org.gs.scheduler;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/counter")
public class CounterResource {

    @Inject
    CounterScheduler counter;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getCounter() {
        return "The value of the counter is " + counter.get();
    }
}
