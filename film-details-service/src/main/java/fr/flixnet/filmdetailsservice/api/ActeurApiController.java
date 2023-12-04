package fr.flixnet.filmdetailsservice.api;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.flixnet.filmdetailsservice.model.Acteurs;
import fr.flixnet.filmdetailsservice.repo.ActeurRepository;
import fr.flixnet.filmdetailsservice.request.CreateOrUpdateActeurOrRealisateurRequest;
import fr.flixnet.filmdetailsservice.request.CreateOrUpdateDetailRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/acteur")
@RequiredArgsConstructor
public class ActeurApiController {
    public final ActeurRepository acteurRepository;
    @PostMapping("/add")
    public String addActeur(@RequestBody CreateOrUpdateActeurOrRealisateurRequest request){
        Acteurs acteur = new Acteurs();
        BeanUtils.copyProperties(request, acteur);
        this.acteurRepository.save(acteur);
        return acteur.getId();
    }
    @PutMapping("/update/{id}")
    public String updateActeur(@RequestBody CreateOrUpdateActeurOrRealisateurRequest request, @PathVariable String id){
        Acteurs acteurs = this.acteurRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(request, acteurs);
        this.acteurRepository.save(acteurs);
        return "Update successfully.";
    }
    @PutMapping("/delete/{id}")
    public String deleteActeur(@RequestBody CreateOrUpdateDetailRequest request, @PathVariable String id)
    {
        Acteurs acteur = this.acteurRepository.findById(id).orElseThrow();
        this.acteurRepository.delete(acteur);
        return "delete successfully";
    }
}
