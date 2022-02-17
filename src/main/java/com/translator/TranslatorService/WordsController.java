package com.translator.TranslatorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WordsController {
    private final GlossaryService glossary;

    WordsController(GlossaryService glossary){
        this.glossary = glossary;
    }

    @RequestMapping(value = "/word", method = RequestMethod.POST)
    public ResponseEntity addWord(@RequestBody WordPair wordPair){
        glossary.addWordPair(wordPair.getEn(), wordPair.getRu());
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @RequestMapping(value = "/word/{word}", method = RequestMethod.GET)
    public ResponseEntity translateWord(@PathVariable("word") String enWord){
        if (glossary.getRuWord(enWord) != null){
            return new ResponseEntity(glossary.getRuWord(enWord), HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
