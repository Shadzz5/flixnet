package fr.flixnet.filmdetailsservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.flixnet.filmdetailsservice.model.Acteurs;
import fr.flixnet.filmdetailsservice.model.Realisateurs;

public interface RealisateurRepository extends JpaRepository<Realisateurs ,String>{
    
}
