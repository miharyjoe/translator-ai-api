package com.springai.springai.controller;

import com.springai.springai.service.CorrectorService;
import lombok.AllArgsConstructor;
import org.springframework.ai.chat.Generation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
@AllArgsConstructor
public class CorrectorController {

  private final CorrectorService correctorService;

  /**
   * Endpoint for correcting spelling and grammar mistakes in the given sentences.
   * Utilizes an AI assistant service to generate a correction response.
   *
   * @param language   The language in which the correction response should be provided.
   *                   (Default value: "english" if not specified)
   * @param sentences  The sentences containing spelling and grammar mistakes to be corrected.
   * @return A Generation object representing the AI-generated correction response.
   *
   * Example usage:
   * <pre>
   * Generation correctionResponse = correctorService.getCorrector("English", "This is an example sentence with mistkes.");
   * </pre>
   *
   * The AI assistant will correct the mistakes in the provided sentences and generate a response.
   * The response can be accessed through the {@link Generation} object.
   */
  @GetMapping("/corrector")
  public Generation translator(@RequestParam(required = true, defaultValue = "english") String language, @RequestBody String sentences){
    return correctorService.getCorrector(language, sentences);
  }
}
