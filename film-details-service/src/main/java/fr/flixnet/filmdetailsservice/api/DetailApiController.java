package fr.flixnet.filmdetailsservice.api;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.flixnet.filmdetailsservice.model.Acteurs;
import fr.flixnet.filmdetailsservice.model.Details;
import fr.flixnet.filmdetailsservice.model.Realisateurs;
import fr.flixnet.filmdetailsservice.repo.ActeurRepository;
import fr.flixnet.filmdetailsservice.repo.DetailRepository;
import fr.flixnet.filmdetailsservice.repo.RealisateurRepository;
import fr.flixnet.filmdetailsservice.request.CreateOrUpdateDetailRequest;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/detail")
@RequiredArgsConstructor
public class DetailApiController {
    
    public final DetailRepository detailRepository;

    public final ActeurRepository acteurRepository;
    public final RealisateurRepository realisateurRepository;

    @PostMapping("/add/{filmId}")
    public String addDetailFilmWithIdFilm(@PathVariable String filmId) {
        System.out.println(filmId );
        Details detail = new Details();
        detail.setId(filmId);
        detail.setDate_sortie(null);
        detail.setDate_realisation(null);
        detail.setDescription_longue("");
        detail.setRealisateurs(null);
        detail.setActeurs(null);
        this.detailRepository.save(detail);
        return "test = " + detail.getId();
    }

    @PutMapping("/update/{id}")
    public String updateFilmDetails(@RequestBody CreateOrUpdateDetailRequest request, @PathVariable String id)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateRealisationString = request.getDate_realisation();
        String dateSortieString = request.getDate_sortie();
        LocalDateTime dateRealisation = LocalDateTime.parse(dateSortieString, formatter);
        LocalDateTime dateSortie = LocalDateTime.parse(dateRealisationString, formatter);

        Details detail = this.detailRepository.findById(id).orElseThrow();
        detail.setDate_realisation(dateRealisation);    
        detail.setDate_sortie(dateSortie);
        detail.setDescription_longue(request.getDescription_longue());

        List<Acteurs> acteurs = this.acteurRepository.findAllById(request.getActeurs());
        List<Realisateurs> realisateurs = this.realisateurRepository.findAllById(request.getRealisateurs());

        detail.setActeurs(acteurs);
        detail.setRealisateurs(realisateurs);

        this.detailRepository.save(detail);
        return detail.getId();
    }
    @PutMapping("/delete/{id}")
    public String deleteFilmDetails(@RequestBody CreateOrUpdateDetailRequest request, @PathVariable String id)
    {
        Details detail = this.detailRepository.findById(id).orElseThrow();
        this.detailRepository.delete(detail);
        return "delete successfully";
    }
}
