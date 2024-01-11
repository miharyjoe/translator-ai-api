package com.springai.springai.controller;



import com.springai.springai.service.TranslatorService;
import lombok.AllArgsConstructor;
import org.springframework.ai.chat.Generation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
@AllArgsConstructor
public class TranslatorController {

    private final TranslatorService translateService;

  /**
   * Endpoint for translating given text into a specified language.
   * Utilizes an AI assistant service to generate a translation response.
   *
   * @param translate  The target language into which the text should be translated.
   * @param sentences  The sentences to be translated into the specified language.
   * @return A Generation object representing the AI-generated translation response.
   *
   * Example usage:
   * <pre>
   * Generation translationResponse = translateService.getTranslator("French", "Hello, how are you?");
   * </pre>
   *
   * The AI assistant will translate the provided sentences into the specified language
   * and generate a response. The response can be accessed through the {@link Generation} object.
   */
    @GetMapping("/translator")
    public Generation translator(@RequestParam(required = true) String translate, @RequestBody String sentences){
        return translateService.getTranslator(translate,sentences);
    }
}

