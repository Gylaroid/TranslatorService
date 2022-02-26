package com.translator.TranslatorService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RussianWordRepository extends JpaRepository<RussianWord, Long> {
    RussianWord findRussianWordByWordBody(String wordBody);
}