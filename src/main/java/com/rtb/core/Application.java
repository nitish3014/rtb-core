package com.rtb.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  protected Application() {

  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
