package com.translator.TranslatorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WordsController {
    private GlossaryService glossary;

    WordsController(){
        this.glossary = new GlossaryService();
    }

    @RequestMapping(value = "/word", method = RequestMethod.POST)
    public ResponseEntity addWord(@RequestBody WordPair wordPair){
        this.glossary.add(wordPair);
        System.out.println("En: " + wordPair.getEn() + " Ru: " + wordPair.getRu());
        return new ResponseEntity(HttpStatus.CREATED);

    }


    @RequestMapping(value = "/word/{word}", method = RequestMethod.GET)
    public ResponseEntity translateWord(@PathVariable("word") String word){
        for (int i = 0; i < glossary.size(); i++){
            WordPair pair = (WordPair) glossary.get(i);
            if (word.equals(pair.getEn())){
                return new ResponseEntity(pair.getRu(), HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
