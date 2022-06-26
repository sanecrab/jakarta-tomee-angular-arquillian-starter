package org.lcdevelop.web;

import jakarta.ejb.Lock;
import static jakarta.ejb.LockType.READ;
import jakarta.ejb.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.lcdevelop.entity.Sample;

@Path("/sample")
@Singleton
@Lock(READ)
public class SampleResource {

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSamples() {
        List<Sample> results = Arrays.asList(
                new Sample(1L, 11, 11L, new BigDecimal(11), new Date(), "Motorola XOOM(tm) with Wi-Fi", "The Next, Next Generation\r\n\r\nExperience the future with Motorola XOOM with Wi-Fi, the world's first tablet powered by Android 3.0 (Honeycomb)."),
                new Sample(2L, 22, 22L, new BigDecimal(22), new Date(), "MOTOROLA XOOM(tm)", "The Next, Next Generation\n\nExperience the future with MOTOROLA XOOM, the world's first tablet powered by Android 3.0 (Honeycomb)."),
                new Sample(3L, 33, 33L, new BigDecimal(33), new Date(), "Samsung Galaxy Tab(tm)", "Feel Free to Tab(tm). The Samsung Galaxy Tab(tm) brings you an ultra-mobile entertainment experience through its 7\" display, high-power processor and Adobe(R) Flash(R) Player compatibility."),
                new Sample(4L, 44, 44L, new BigDecimal(44), new Date(), "DROID(tm) Pro by Motorola", "The next generation of DOES."),
                new Sample(5L, 55, 55L, new BigDecimal(55), new Date(), "T-Mobile G2", "The T-Mobile G2 with Google is the first smartphone built for 4G speeds on T-Mobile's new network. Get the information you need, faster than you ever thought possible.")
        );
        GenericEntity<List<Sample>> wrappedResult = new GenericEntity<List<Sample>>(results) {
        };
        return Response.ok(wrappedResult).build();
    }

}
