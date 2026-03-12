package com.tts.ttsproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.ttsproject.model.TextHistory;
import com.tts.ttsproject.repository.TextRepository;

@Service
public class TextService {

    @Autowired
    private TextRepository repo;

    public TextHistory saveText(String text) {

        TextHistory history = new TextHistory();
        history.setText(text);

        return repo.save(history);
    }

    public List<TextHistory> getHistory() {
        return repo.findAll();
    }

}
