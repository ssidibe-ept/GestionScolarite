package sn.edu.isepat.tic.dbe.p6.GestionScolarite.dto;

import jakarta.persistence.Column;
import lombok.*;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.entities.Genre;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InscriptionRequestDto {

    private String prenom;

    private String nom;

    private Boolean etranger;

    private Genre genre;

    private String adresse;

    private String telephone;

    private Integer promo;

    private LocalDate dateInscription;

    private Double montant;

    private String adresseRecupBus;

    private String email;
}
