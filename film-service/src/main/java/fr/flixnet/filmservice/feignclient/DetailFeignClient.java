package fr.flixnet.filmservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@FeignClient(name = "film-details-service", url = "http://localhost:8081", fallback = DetailFeignClient.Fallback.class)  // Remplacez l'URL par celle de votre service Detail
public interface DetailFeignClient {
    @PostMapping("/api/detail/add/{filmId}")
    public String addDetailFilmWithIdFilm(@PathVariable String filmId);

     @Component
    public static class Fallback implements DetailFeignClient {
        @Override
        public String addDetailFilmWithIdFilm(String filmId) {
            return new String();
        }
    }
}
