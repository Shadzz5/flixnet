package fr.flixnet.filmservice.api;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.flixnet.filmservice.model.Film;
import fr.flixnet.filmservice.repo.FilmRepository;
import fr.flixnet.filmservice.request.CreateOrUpdateFilmRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/film")
@RequiredArgsConstructor
public class FilmApiController {
    
    public final FilmRepository filmRepository;

    @PostMapping("/add")
    public String addFilm(@RequestBody CreateOrUpdateFilmRequest request){
        Film film = new Film();
        BeanUtils.copyProperties(request, film);

        this.filmRepository.save(film);
        return film.getId();
    }

    @PutMapping("/update/{id}")
    public String updateFilm(@RequestBody CreateOrUpdateFilmRequest request, @PathVariable String id){
        Film film = this.filmRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(request, film);

        this.filmRepository.save(film);
        return film.getId();
    }

    @PutMapping("/delete/{id}")
    public String deleteFilm(@PathVariable String id){
        Film film = this.filmRepository.findById(id).orElseThrow();

        this.filmRepository.delete(film);
        return "delete successfully";
    }
}
