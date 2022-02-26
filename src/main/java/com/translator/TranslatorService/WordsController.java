package com.translator.TranslatorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/words/add", method = RequestMethod.POST)
    public ResponseEntity addWordPair(@RequestBody WordPair wordPair){
        RussianWord russianWord = new RussianWord();
        EnglishWord englishWord = new EnglishWord();

        russianWord.setWordBody(wordPair.getRuWord());

        englishWord.setWordBody(wordPair.getEnWord());
        englishWord.setRuWord(russianWord);

        if(!englishWord.getWordBody().isBlank() && !russianWord.getWordBody().isBlank()){
            englishWordRepo.save(englishWord);
            return new ResponseEntity(englishWord.getWordBody() + " " + russianWord.getWordBody(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Ошибка в передаче данных", HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/words/translate/en/{word}", method = RequestMethod.GET)
    public ResponseEntity translateEnWord(@PathVariable("word") String enWordBody){
        EnglishWord englishWord = englishWordRepo.findEnglishWordByWordBody(enWordBody);
        RussianWord russianWord = englishWord.getRuWord();

        if (russianWord != null){
            return new ResponseEntity(russianWord.getWordBody(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/words/translate/ru/{word}", method = RequestMethod.GET)
    public ResponseEntity translateRuWord(@PathVariable("word") String wordBody){
        RussianWord russianWord = russianWordRepo.findRussianWordByWordBody(wordBody);
        EnglishWord englishWord = russianWord.getEnWord();

        if (englishWord != null){
            return new ResponseEntity(englishWord.getWordBody(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/words", method = RequestMethod.GET)
    public ResponseEntity allWords(){
        StringBuilder stringBuilder = new StringBuilder();
        String response;
        List<RussianWord> ruWords = russianWordRepo.findAll();
        List<EnglishWord> enWords = englishWordRepo.findAll();

        for(int i = 0; i < ruWords.size(); i++){
            stringBuilder.append(ruWords.get(i).getWordBody());
            stringBuilder.append("<br>");
        }
        for(int i = 0; i < enWords.size(); i++){
            stringBuilder.append(enWords.get(i).getWordBody());
            stringBuilder.append("<br>");
        }

        response = stringBuilder.toString();

        if (!response.isBlank()){
            return new ResponseEntity(response, HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/words/en", method = RequestMethod.GET)
    public ResponseEntity allEnWords(@PathVariable("word") String enWordBody){
        StringBuilder stringBuilder = new StringBuilder();
        String response;
        List<EnglishWord> enWords = englishWordRepo.findAll();

        for(int i = 0; i < enWords.size(); i++){
            stringBuilder.append(enWords.get(i).getWordBody());
            stringBuilder.append("<br>");
        }

        response = stringBuilder.toString();

        if (!response.isBlank()){
            return new ResponseEntity(response, HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/words/ru", method = RequestMethod.GET)
    public ResponseEntity allRuWords(@PathVariable("word") String wordBody){
        StringBuilder stringBuilder = new StringBuilder();
        String response;
        List<RussianWord> ruWords = russianWordRepo.findAll();

        for(int i = 0; i < ruWords.size(); i++){
            stringBuilder.append(ruWords.get(i).getWordBody());
            stringBuilder.append("<br>");
        }

        response = stringBuilder.toString();

        if (!response.isBlank()){
            return new ResponseEntity(response, HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
