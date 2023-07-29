package com.github.joker1007;

import java.util.List;
import javax.transaction.Transactional;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class TodoGraphQLResource {
  @Query("allItems")
  public List<Todo> list() {
    return Todo.listAll();
  }

  @Mutation
  @Transactional
  public Todo create(String name) {
    return Todo.create(name);
  }

  @Mutation
  @Transactional
  public Todo done(Long id) {
    Todo todo = Todo.findById(id);
    if (todo != null) {
      todo.done();
      return todo;
    } else {
      return null;
    }
  }
}
