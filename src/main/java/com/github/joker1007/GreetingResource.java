package com.github.joker1007;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/tokyu")
public class GreetingResource {

  @GET
  @Path("/hello")
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "Hello Tokyu Ruby Kaigi";
  }

  @GET
  @Path("/self-introduction")
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, Object> introduction() {
    return Map.of("name", "joker1007", "age", 38, "favorite", "ジョジョの奇妙な冒険");
  }
}
