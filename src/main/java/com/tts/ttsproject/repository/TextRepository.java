package com.tts.ttsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tts.ttsproject.model.TextHistory;

public interface TextRepository extends JpaRepository<TextHistory, Long> {

}
