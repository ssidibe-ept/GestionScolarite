package sn.edu.isepat.tic.dbe.p6.GestionScolarite.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.services.InscriptionService;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.dto.InscriptionRequestDto;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.entities.Genre;

import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
@Component
public class TestInscriptionService implements CommandLineRunner {

    private final InscriptionService inscriptionService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Test Inscription service started");
        InscriptionRequestDto inscriptAbdou=InscriptionRequestDto.builder()
                .prenom("Abdou")
                .nom("DIOP")
                .etranger(false)
                .telephone("T56DF")
                .genre(Genre.MASCULIN)
                .promo(6)
                .montant(75000.0)
                .dateInscription(LocalDate.now())
                .adresseRecupBus("Médina")
                .email("adiop@isepat.com")
                .build();
        inscriptionService.inscrire(inscriptAbdou);
        log.info("Test Inscription service finished");
    }
}
