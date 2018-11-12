package io.codelair.microprofile.restclient.client;

import io.codelair.microprofile.restclient.client.api.PinboardApi;
import io.codelair.microprofile.restclient.client.model.Note;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
@WebServlet(urlPatterns = {"/client"})
public class Invoker extends HttpServlet {

  @Inject
  private ProgrammaticClient programmaticClient;

  @Inject
  @RestClient
  private AnnotatedClient annotatedClient;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    boolean useAnnotation = Boolean.parseBoolean(req.getParameter("useAnnotation"));
    final PinboardApi api;
    if (useAnnotation) {
      api = annotatedClient;
    } else {
      api = programmaticClient.getApi();
    }

    try (final PrintWriter writer = resp.getWriter()) {
      final List<Note> notes = api.doGet();
      notes.forEach(note -> {
        writer.write("<p>" + note.getMessage() + " - " + note.getAuthor() + "</p>");
      });
      writer.write("<p>To add a new note, call the REST-service with and post a JSON containing \"message\" and \"author\".</p>");
    }
  }
}
