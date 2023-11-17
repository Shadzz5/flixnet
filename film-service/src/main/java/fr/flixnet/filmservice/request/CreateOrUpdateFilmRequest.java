package fr.flixnet.filmservice.request;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrUpdateFilmRequest {
    private String titre;
    private String description;
    private String categorie_id;
    private BigDecimal prix;
}
