package sn.edu.isepat.tic.dbe.p6.GestionScolarite.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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

    public Optional<Apprenant> findById(Integer idApprenant) {
        return apprenantRepository.findById(idApprenant);
    }
}
