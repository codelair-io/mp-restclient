package io.codelair.microprofile.restclient.client;

import io.codelair.microprofile.restclient.client.api.PinboardApi;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * Second variant to create a MicroProfile RESTClient for the OpenAPI-generated classes. Here we just inherit and
 * annotate (thus making it eligible for @RestClient-injection)
 */
@RegisterRestClient
public interface AnnotatedClient extends PinboardApi {
}
