package com.translator.TranslatorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordsController {
    //    @Autowired
    EnglishWordRepository englishWordRepo;
    //    @Autowired
    RussianWordRepository russianWordRepo;

    public WordsController(EnglishWordRepository englishWordRepo, RussianWordRepository russianWordRepo){
        this.russianWordRepo = russianWordRepo;
        this.englishWordRepo = englishWordRepo;
    }

    @RequestMapping(value = "/word", method = RequestMethod.POST)
    public ResponseEntity addWordPair(@RequestBody EnglishWord englishWord, RussianWord russianWord){
        russianWordRepo.save(russianWord);
        englishWordRepo.save(englishWord);
        return new ResponseEntity("Успех", HttpStatus.CREATED);
    }

//    @RequestMapping(value = "/word/{word}", method = RequestMethod.GET)
//    public ResponseEntity translateWord(@PathVariable("word") String enWord){
//        if (!glossary.getRuWord(enWord).isBlank()){
//            return new ResponseEntity(glossary.getRuWord(enWord), HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//    }
}
