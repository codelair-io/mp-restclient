package io.codelair.microprofile.restclient.client;

import io.codelair.microprofile.restclient.client.api.PinboardApi;
import java.net.URI;
import java.net.URISyntaxException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

/**
 * First variant to create a MicroProfile RESTClient for the generated OpenAPI-classes.
 */
@ApplicationScoped
public class ProgrammaticClient {
  private PinboardApi api;

  @PostConstruct
  private void initClient() {
    try {
      api = RestClientBuilder.newBuilder()
          .baseUri(new URI("http://localhost:9080/app/api"))
          .build(PinboardApi.class);
    } catch (final URISyntaxException ignored) {
      // intentionally ignored, we know the URL is right.
    }
  }

  public PinboardApi getApi() {
    return api;
  }
}
