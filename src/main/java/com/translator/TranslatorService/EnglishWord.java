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
    private String enWordBody;

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

    public String getEnWordBody() {
        return enWordBody;
    }

    public void setEnWordBody(String word) {
        this.enWordBody = word;
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
                ", enWord='" + enWordBody + '\'' +
                ", ruWord=" + ruWord +
                '}';
    }
}