package com.springai.springai.service;

import lombok.AllArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CorrectorService {
  private final ChatClient chatClient;

  /**
   * Generates a response to correct spelling and grammar mistakes in the given sentences.
   * This method utilizes an AI assistant to provide corrections in the specified language.
   *
   * @param language   The language in which the correction response should be provided.
   * @param sentences  The sentences containing spelling and grammar mistakes to be corrected.
   * @return A Generation object representing the AI-generated correction response.
   *
   * Example usage:
   * <pre>
   * Generation correctionResponse = getCorrector("English", "This is an example sentence with mistkes.");
   * </pre>
   *
   * The AI assistant will correct the mistakes in the provided sentences and generate a response.
   * The response can be accessed through the {@link Generation} object.
   */
  public String getCorrector(String language, String sentences){

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
    return chatClient.call(prompt).getResult().getOutput().getContent();
  }
}
