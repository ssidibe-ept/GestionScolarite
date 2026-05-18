package sn.edu.isepat.tic.dbe.p6.GestionScolarite.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.ApiException;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.entities.Apprenant;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.repositories.ApprenantRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ApprenantService {

    private final ApprenantRepository apprenantRepository;

    public List<Apprenant> getAllApprenants() {
        log.trace("recuperation liste apprenants");
        return apprenantRepository.findAll();
    }

    public Apprenant findById(Integer idApprenant) {
        if(idApprenant == null || idApprenant < 0) {
            throw new ApiException(450, "L'id '"+idApprenant+"' doit être un nombre positif");
        }
        Optional<Apprenant> apprenantDb= apprenantRepository.findById(idApprenant);
        if(apprenantDb.isEmpty()){
            throw new ApiException(454, "L'apprenant dont l'id est '"+idApprenant+"' n'existe pas");
        }
        Apprenant apprenant = apprenantDb.get();
        return apprenant;
    }
}
