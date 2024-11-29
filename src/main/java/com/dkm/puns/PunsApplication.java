package com.dkm.puns;

import com.dkm.puns.model.Word;
import com.dkm.puns.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PunsApplication {

    @Autowired
    private WordService wordService;

    public static void main(String[] args) {
        SpringApplication.run(PunsApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            System.out.println("Aplikacja uruchomiona!");

            Word randomWord = wordService.getRandomWord();
            if (randomWord != null) {
                System.out.println("Wylosowane słowo: " + randomWord.getWord());
            } else {
                System.out.println("Brak słów w bazie danych.");
            }
        };
    }
}