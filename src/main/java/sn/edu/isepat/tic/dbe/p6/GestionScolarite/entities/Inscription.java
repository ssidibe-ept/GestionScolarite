package sn.edu.isepat.tic.dbe.p6.GestionScolarite.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cache;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "inscription")
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate dateInscription;

    @Column(nullable = false)
    private Double montant;

    private String adresseRecupBus;

    @JoinColumn( nullable = false)
    @ManyToOne
    private Apprenant apprenant;

}