package sn.edu.isepat.tic.dbe.p6.GestionScolarite.services;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.ApiException;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.dto.InscriptionRequestDto;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.entities.Apprenant;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.entities.Inscription;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.repositories.ApprenantRepository;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.repositories.InscriptionRepository;

import java.util.Optional;

@Slf4j
@Service
public class InscriptionService {

    private final ApprenantRepository apprenantRepository;
    private final InscriptionRepository inscriptionRepository;

    public InscriptionService(ApprenantRepository apprenantRepository, InscriptionRepository inscriptionRepository) {
        this.apprenantRepository = apprenantRepository;
        this.inscriptionRepository = inscriptionRepository;
    }

    @Transactional
    public void inscrire(InscriptionRequestDto inscriptionDto) {
        String email = inscriptionDto.getEmail();
        if(email == null||email.isBlank()) {
            throw new ApiException(414, "L'email est obligatoire");
        }
        /// recherche apprenant avec cette adresse email
        Optional<Apprenant> apprenantDb = apprenantRepository.findByEmail(email);
        ///apprenantDb.isPresent() return true s'il ya un ap avec cette mail
        //apprenantDb.isEmpty() return true s'il n y a pas d'apprenant avec cette mail
        Apprenant apprenant;
        if (apprenantDb.isPresent()) {
            log.info("apprenant dont l'email est '{}' existe déja", email);
            apprenant=apprenantDb.get();
        }else {
            log.info("apprenant dont l'email est '{}' n'existe pas donc elle sera créée", email);
            apprenant = Apprenant.builder()
                    .prenom(inscriptionDto.getPrenom())
                    .nom(inscriptionDto.getNom())
                    .etranger(inscriptionDto.getEtranger())
                    .adresse(inscriptionDto.getAdresse())
                    .email(inscriptionDto.getEmail())
                    .promo(inscriptionDto.getPromo())
                    .genre(inscriptionDto.getGenre())
                    .telephone(inscriptionDto.getTelephone())
                    .build();
            apprenantRepository.save(apprenant);
        }
        Inscription inscription =Inscription.builder()
                .dateInscription(inscriptionDto.getDateInscription())
                .montant(inscriptionDto.getMontant())
                .adresseRecupBus(inscriptionDto.getAdresseRecupBus())
                .apprenant(apprenant)
                .build();
        inscriptionRepository.save(inscription);

    }

}
