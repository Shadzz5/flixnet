package fr.flixnet.filmdetailsservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.flixnet.filmdetailsservice.model.Details;

public interface DetailRepository extends JpaRepository<Details ,String>{
    
}
