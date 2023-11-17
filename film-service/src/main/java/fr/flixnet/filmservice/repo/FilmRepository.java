package fr.flixnet.filmservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.flixnet.filmservice.model.Film;

public interface FilmRepository extends JpaRepository<Film,String> {
    
}
