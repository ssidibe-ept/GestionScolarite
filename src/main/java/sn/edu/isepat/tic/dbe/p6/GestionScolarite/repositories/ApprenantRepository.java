package sn.edu.isepat.tic.dbe.p6.GestionScolarite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.entities.Apprenant;

import java.util.List;
import java.util.Optional;

public interface ApprenantRepository extends JpaRepository<Apprenant, Integer> {

    Optional<Apprenant> findByEmail(String email);
}
