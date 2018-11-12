package io.codelair.microprofile.restclient.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/pinboard")
public class PinboardResource {
  private final List<Note> notes = Collections.synchronizedList(new ArrayList<Note>());

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Note> doGet() {
    return notes;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public void doPost(final Note note) {
    notes.add(note);
  }
}
