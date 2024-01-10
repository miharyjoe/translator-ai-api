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
public class TranslatorController {
  @Autowired
  ChatClient chatClient;
    @GetMapping("/translator")
    public Generation translator(@RequestParam(required = true) String translate, @RequestBody String sentences){
      PromptTemplate promptTemplate = new PromptTemplate("translate  into {translate} the given  sentences : {sentences}");
      Prompt prompt = promptTemplate.create(Map.of("translate", translate, "sentences", sentences));
      return chatClient.generate(prompt).getGeneration();
    }
}
