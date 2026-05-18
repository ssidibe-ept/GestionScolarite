package sn.edu.isepat.tic.dbe.p6.GestionScolarite.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Apprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String prenom;

    @Column(length = 50, nullable = false)
    private String nom;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private Boolean etranger;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String adresse;

    private String telephone;

    @Column(nullable = false)
    private Integer promo;
}


