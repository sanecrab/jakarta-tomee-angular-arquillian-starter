package org.lcdevelop.web;

import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lcdevelop.entity.Sample;
import org.lcdevelop.utils.RestGenericParser;

/**
 * Arquillian will start the container, deploy all @Deployment bundles, then run all the @Test methods.
 * <p>
 * A strong value-add for Arquillian is that the test is abstracted from the server.
 * It is possible to rerun the same test against multiple adapters or server configurations.
 * <p>
 * A second value-add is it is possible to build WebArchives that are slim and trim and therefore
 * isolate the functionality being tested. This also makes it easier to swap out one implementation
 * of a class for another allowing for easy mocking.
 */
@ExtendWith(ArquillianExtension.class)
public class SampleResourceTest {

    @Inject
    SampleResource sampleService;

    /**
     * ShrinkWrap is used to create a war file on the fly.
     * <p>
     * The API is quite expressive and can build any possible
     * flavor of war file. It can quite easily return a rebuilt
     * war file as well.
     * <p>
     * More than one @Deployment method is allowed.
     *
     * @return
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "jakarta-tomee-angular-arquillian-starter.war").addClasses(Sample.class, SampleResource.class);
    }

    /**
     * This URL will contain the following URL data
     * <p>
     * - http://<host>:<port>/<webapp>/
     * <p>
     * This allows the test itself to be agnostic of server information or even
     * the name of the webapp
     */
    @ArquillianResource
    private URL webappUrl;

    @Test
    public void getSampleList() throws Exception {
        if (webappUrl == null) {
            System.out.println("WebAppURL: " + webappUrl);
            //return;
            webappUrl = new URL("http://localhost:" + System.getProperty("tomee.httpPort"));
        }

        System.out.println("*********** TESTING " + webappUrl.toString() + "api/sample/list");

        Client rsClient = ClientBuilder.newClient();
        WebTarget webTarget = rsClient.target(webappUrl.toURI()).path("api/sample/list");
        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

        List<Sample> samples = new ArrayList<>();
        try {
            String responseStr = response.readEntity(String.class);
            if (response.getStatus() == 200) {
                samples = RestGenericParser.JSONToEntityList(responseStr, Sample.class);
            } else {
                System.out.println("*********** ERROR: TEST: '" + webTarget.getUri() + "' " + response.getStatus() + " " + response.getStatusInfo().getReasonPhrase());
            }

            System.out.println("WAITING(30sec): ");
            //Thread.sleep(30000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         * Assertions.assertEquals(5, samples.size());
         *
         * final Iterator<? extends Sample> it = samples.iterator();
         * Assertions.assertEquals(Long.valueOf(1), it.next().getId());
         * Assertions.assertEquals(Long.valueOf(2), it.next().getId());
         * Assertions.assertEquals(Long.valueOf(3), it.next().getId());
         * Assertions.assertEquals(Long.valueOf(4), it.next().getId());
         * Assertions.assertEquals(Long.valueOf(5), it.next().getId());
         */
    }
}
