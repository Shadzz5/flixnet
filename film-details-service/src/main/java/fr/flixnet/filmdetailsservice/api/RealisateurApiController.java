package fr.flixnet.filmdetailsservice.api;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.flixnet.filmdetailsservice.model.Acteurs;
import fr.flixnet.filmdetailsservice.model.Realisateurs;
import fr.flixnet.filmdetailsservice.repo.RealisateurRepository;
import fr.flixnet.filmdetailsservice.request.CreateOrUpdateActeurOrRealisateurRequest;
import fr.flixnet.filmdetailsservice.request.CreateOrUpdateDetailRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/realisateur")
@RequiredArgsConstructor
public class RealisateurApiController {
    public final RealisateurRepository realisateurRepository;
    @PostMapping("/add")
    public String addRealisateur(@RequestBody CreateOrUpdateActeurOrRealisateurRequest request){
        Realisateurs realisateur = new Realisateurs();
        BeanUtils.copyProperties(request, realisateur);
        this.realisateurRepository.save(realisateur);
        return realisateur.getId();
    }
    @PutMapping("/update/{id}")
    public String updateRealisateur(@RequestBody CreateOrUpdateActeurOrRealisateurRequest request, @PathVariable String id){
        Realisateurs realisateurs = this.realisateurRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(request, realisateurs);
        this.realisateurRepository.save(realisateurs);
        return "Update successfully.";
    }
    @PutMapping("/delete/{id}")
    public String deleteRealisateur(@RequestBody CreateOrUpdateDetailRequest request, @PathVariable String id)
    {
        Realisateurs realisateurs = this.realisateurRepository.findById(id).orElseThrow();
        this.realisateurRepository.delete(realisateurs);
        return "delete successfully";
    }
}
