package sn.edu.isepat.tic.dbe.p6.GestionScolarite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.entities.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
}