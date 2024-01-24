package com.springai.springai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

  @GetMapping("/ping")
  public String healthCheck (){
    return "pong";
  }
}
