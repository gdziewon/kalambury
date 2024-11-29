package com.dkm.puns.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "game_players")
@Data
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int score;

}
