package fr.flixnet.filmdetailsservice.request;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrUpdateDetailRequest {
    private String description_longue;
    private String date_realisation;
    private String date_sortie;
    private List<String> acteurs;
    private List<String> realisateurs;
}