package com.translator.TranslatorService;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ru_words")
public class RussianWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "ru_word")
    private String wordBody;

    @OneToOne(mappedBy = "ruWord")
    private EnglishWord enWord;

    public RussianWord() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWordBody() {
        return wordBody;
    }

    public void setWordBody(String ruWord) {
        this.wordBody = ruWord;
    }

    public EnglishWord getEnWord() {
        return enWord;
    }

    public void setEnWord(EnglishWord enWord) {
        this.enWord = enWord;
    }

    @Override
    public String toString() {
        return "RussianWord{" +
                "id=" + id +
                ", ruWord='" + wordBody + '\'' +
                ", enWord=" + enWord +
                '}';
    }
}