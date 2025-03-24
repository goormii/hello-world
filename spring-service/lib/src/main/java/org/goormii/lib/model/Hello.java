package org.goormii.lib.model;

public class Hello {
  private String name;

  public Hello(String name) {
    this.name = name;
  }

  public String greet() {
    return "Hello, " + this.name + "!";
  }
}
