package com.dkm.puns.service;

import com.dkm.puns.model.Word;
import com.dkm.puns.repo.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    public Word getRandomWord() {
        return wordRepository.findRandomWord();
    }
}
