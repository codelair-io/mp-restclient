# RESTClient Example

Shows how to use the Microprofile-RESTClient with OpenAPI-generated model- and API-classes.

This WAR contains both the client and the service just for ease of testing. When calling the invoker
with /client you can add the "useAnnotation=true"-query-param to demo two ways of building a RESTClient
(either programmatic or annotated).

The service's OpenAPI v3-spec is also in the project and is really just a verbatim copy of how the
service presents itself.

For the Annotated client the MP-RESTClient-spec mandates that you use MP-Config to configure the endpoint,
for this application this would be following Java Option: `-Dio.codelair.microprofile.restclient.client.PinboardClient2/mp-rest/url=http://localhost:8080/app/api`.
