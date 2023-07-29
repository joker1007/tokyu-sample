package com.github.joker1007;

import org.jboss.resteasy.reactive.RestResponse;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/todos")
public class TodoResource {
  @GET
  public List<Todo> list() {
    return Todo.listAll();
  }

  @POST
  @Transactional
  public Todo create(String name) {
    return Todo.create(name);
  }

  @POST
  @Path("/done/{id}")
  @Transactional
  public RestResponse<Todo> done(Long id) {
    Todo todo = Todo.findById(id);
    if (todo != null) {
      todo.done();
      return RestResponse.ResponseBuilder.ok(todo).build();
    } else {
      return RestResponse.ResponseBuilder.<Todo>notFound().build();
    }
  }
}
