package com.springai.springai.controller;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/translate")
public class CorrectorController {
  @Autowired
  ChatClient chatClient;
    @GetMapping("/french")
    public ChatResponse translator(@RequestParam(value = "message") String message){
      PromptTemplate promptTemplate = new PromptTemplate("translate the given english sentence sentence into french {query}");
      Prompt prompt = promptTemplate.create(Map.of("query", message));
      return chatClient.generate(prompt);
    }

}
