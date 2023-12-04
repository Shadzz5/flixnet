package fr.flixnet.filmdetailsservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.flixnet.filmdetailsservice.model.Acteurs;

public interface ActeurRepository extends JpaRepository<Acteurs ,String>{
    
}
