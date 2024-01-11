package com.springai.springai.service;

import lombok.AllArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.ai.prompt.SystemPromptTemplate;
import org.springframework.ai.prompt.messages.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CorrectorService {
  private final ChatClient chatClient;
  public Generation getCorrector(String language, String sentences){

    String systemPrompt = """
                You are a helpful AI assistant that helps people Correct the spelling and grammar mistakes.
                You should reply to the user's request in the style of a professional.
                You should give your answer in %s.
                """.formatted(language);
    SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemPrompt);
    Message systemMessage = systemPromptTemplate.createMessage();
    PromptTemplate promptTemplate = new PromptTemplate("Correct the spelling and grammar mistakes in the given  sentences : {sentences}");
    Message userMessage = promptTemplate.createMessage(Map.of("sentences", sentences));
    Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
    return chatClient.generate(prompt).getGeneration();
  }
}
