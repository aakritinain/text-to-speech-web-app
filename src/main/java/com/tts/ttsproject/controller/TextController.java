package com.tts.ttsproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tts.ttsproject.model.TextHistory;
import com.tts.ttsproject.service.TextService;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class TextController {

    @Autowired
    private TextService service;

    @PostMapping("/save")
    public TextHistory save(@RequestBody TextHistory text) {

        return service.saveText(text.getText());
    }

    @GetMapping("/history")
    public List<TextHistory> history() {

        return service.getHistory();
    }

}
