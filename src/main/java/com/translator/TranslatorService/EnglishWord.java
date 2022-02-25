package com.translator.TranslatorService;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "en_words")
public class EnglishWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "en_word")
    private String enWord;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ru_word_id", referencedColumnName = "id")
    private RussianWord ruWord;

    public EnglishWord() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEnWord() {
        return enWord;
    }

    public void setEnWord(String word) {
        this.enWord = word;
    }

    public RussianWord getRuWord() {
        return ruWord;
    }

    public void setRuWord(RussianWord ruWord) {
        this.ruWord = ruWord;
    }

    @Override
    public String toString() {
        return "EnglishWord{" +
                "id=" + id +
                ", enWord='" + enWord + '\'' +
                ", ruWord=" + ruWord +
                '}';
    }
}