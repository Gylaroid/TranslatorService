package com.translator.TranslatorService;

import org.springframework.stereotype.Service;
import java.util.HashMap;


@Service
public class GlossaryService{
    private final HashMap<String, String> allWordPairs;
    
    GlossaryService(){
        allWordPairs = new HashMap<>();
    } 
    
    public void addWordPair(String en, String ru){
        allWordPairs.put(en, ru);
    }
    
    public String getRuWord(String key){
        return allWordPairs.getOrDefault(key, null);
    }
    
}