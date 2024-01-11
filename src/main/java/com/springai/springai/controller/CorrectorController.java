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
  @GetMapping("/corrector")
  public Generation translator(@RequestParam(required = true, defaultValue = "english") String language, @RequestBody String sentences){
    return correctorService.getCorrector(language, sentences);
  }
}
