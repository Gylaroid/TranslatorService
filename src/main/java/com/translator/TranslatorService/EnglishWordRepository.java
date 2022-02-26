package com.translator.TranslatorService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnglishWordRepository extends JpaRepository<EnglishWord, Long> {
    EnglishWord findEnglishWordByWordBody(String enWordBody);
}