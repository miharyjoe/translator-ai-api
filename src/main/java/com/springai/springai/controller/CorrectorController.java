package com.springai.springai.controller;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ai")
public class CorrectorController {
  @Autowired
  ChatClient chatClient;
  @GetMapping("/corrector")
  public Generation translator(@RequestBody String sentences){
    PromptTemplate promptTemplate = new PromptTemplate("Correct the spelling and grammar mistakes in the given  sentences : {sentences}");
    Prompt prompt = promptTemplate.create(Map.of( "sentences", sentences));
    return chatClient.generate(prompt).getGeneration();
  }
}
