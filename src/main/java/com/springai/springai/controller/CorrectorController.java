package com.springai.springai.controller;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.ai.prompt.SystemPromptTemplate;
import org.springframework.ai.prompt.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ai")
public class CorrectorController {
  @Autowired
  ChatClient chatClient;
  @GetMapping("/corrector")
  public Generation translator(@RequestBody String sentences){
    String systemPrompt = """
                You are a helpful AI assistant that helps people Correct the spelling and grammar mistakes.
                You should reply to the user's request in the style of a professional.
                """;
    SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemPrompt);
    Message systemMessage = systemPromptTemplate.createMessage();
    PromptTemplate promptTemplate = new PromptTemplate("Correct the spelling and grammar mistakes in the given  sentences : {sentences}");
    Message userMessage = promptTemplate.createMessage(Map.of("sentences", sentences));
    Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
    return chatClient.generate(prompt).getGeneration();
  }
}
