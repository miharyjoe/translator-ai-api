package com.springai.springai.controller;



import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.ai.prompt.SystemPromptTemplate;
import org.springframework.ai.prompt.messages.Message;
import org.springframework.ai.prompt.messages.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ai")
public class TranslatorController {
  @Autowired
  ChatClient chatClient;
    @GetMapping("/translator")
    public Generation translator(@RequestParam(required = true) String translate, @RequestBody String sentences){
      String systemPrompt = """
                You are a helpful AI assistant that helps people translate given text to %s.
                You should reply to the user's request in the style of a professional.
                """.formatted(translate);
      SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemPrompt);
      Message systemMessage = systemPromptTemplate.createMessage();
      PromptTemplate promptTemplate = new PromptTemplate("translate  into {translate} the given  sentences : {sentences}");
      Message userMessage = promptTemplate.createMessage(Map.of("translate", translate, "sentences", sentences));
      Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
      return chatClient.generate(prompt).getGeneration();
    }
}

