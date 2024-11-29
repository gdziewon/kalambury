package com.dkm.puns.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "game_words")
@Data
public class GameWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "word_id", nullable = false)
    private Word word;

    private Boolean guessed = false;

}
