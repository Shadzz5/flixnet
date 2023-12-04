package fr.flixnet.filmdetailsservice.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Details {
    @Id
    private String id;
    private String description_longue;
    private LocalDateTime date_realisation;
    private LocalDateTime date_sortie;
    @ManyToMany
    @JoinTable(name = "details_acteurs", joinColumns = @JoinColumn(name = "detail_id"), inverseJoinColumns = @JoinColumn(name = "acteur_id"))
    private List<Acteurs> acteurs;

    @ManyToMany
    @JoinTable(name = "details_realisateurs", joinColumns = @JoinColumn(name = "detail_id"), inverseJoinColumns = @JoinColumn(name = "realisateur_id"))
    private List<Realisateurs> realisateurs;
}
