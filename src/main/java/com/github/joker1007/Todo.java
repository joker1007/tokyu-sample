package com.github.joker1007;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.time.Instant;

@Entity
public class Todo extends PanacheEntity {
  public enum Status {
    CREATED,
    DONE
  }

  public String name;
  public Instant createdAt;
  public Status status;

  public static Todo create(String name) {
    var todo = new Todo();
    todo.name = name;
    todo.createdAt = Instant.now();
    todo.status = Status.CREATED;
    todo.persist();
    return todo;
  }

  public void done() {
    this.status = Status.DONE;
  }
}
