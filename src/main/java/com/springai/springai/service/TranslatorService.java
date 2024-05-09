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
public class TranslatorService {

  private final ChatClient chatClient;

  /**
   * Generates a response to translate given text into a specified language.
   * This method utilizes an AI assistant to provide translations in the specified language.
   *
   * @param translate  The target language into which the text should be translated.
   * @param sentences  The sentences to be translated into the specified language.
   * @return A Generation object representing the AI-generated translation response.
   *
   * Example usage:
   * <pre>
   * Generation translationResponse = getTranslator("French", "Hello, how are you?");
   * </pre>
   *
   * The AI assistant will translate the provided sentences into the specified language
   * and generate a response. The response can be accessed through the {@link Generation} object.
   */
  public String getTranslator(String translate, String sentences){
    String systemPrompt = """
                You are a helpful AI assistant that helps people translate given text to %s.
                You should reply to the user's request in the style of a professional.
                """.formatted(translate);
    SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemPrompt);
    Message systemMessage = systemPromptTemplate.createMessage();
    PromptTemplate promptTemplate = new PromptTemplate("translate  into {translate} the given  sentences : {sentences}");
    Message userMessage = promptTemplate.createMessage(Map.of("translate", translate, "sentences", sentences));
    Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
    return chatClient.call(prompt).getResult().getOutput().getContent();
  }
}
