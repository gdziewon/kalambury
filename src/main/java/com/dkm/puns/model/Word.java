package com.dkm.puns.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "words")
@Data
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String word;
    private String category;
}
