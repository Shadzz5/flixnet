package fr.flixnet.filmdetailsservice.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrUpdateActeurOrRealisateurRequest {
    private String nom;
    private String prenom;
}
