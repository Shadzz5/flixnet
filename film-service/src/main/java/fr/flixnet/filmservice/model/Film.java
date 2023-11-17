package fr.flixnet.filmservice.model;

import java.math.BigDecimal;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Film {
    @Id
    @UuidGenerator
    private String id;
    private String titre;
    private String description;
    private BigDecimal prix;
    private String categorie_id;
}
