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
    @GetMapping("/translator")
    public Generation translator(@RequestParam(required = true) String translate, @RequestBody String sentences){
        return translateService.getTranslator(translate,sentences);
    }
}

