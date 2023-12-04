package fr.flixnet.filmdetailsservice.model;

import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Realisateurs {
    @Id
    @UuidGenerator
    private String id;

    private String nom;
    private String prenom;

    @ManyToMany(mappedBy = "realisateurs")
    private List<Details> details;

}
