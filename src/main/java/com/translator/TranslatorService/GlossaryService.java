package com.translator.TranslatorService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GlossaryService extends ArrayList {
    public void add(WordPair wordPair){
        super.add(wordPair);
    }
}