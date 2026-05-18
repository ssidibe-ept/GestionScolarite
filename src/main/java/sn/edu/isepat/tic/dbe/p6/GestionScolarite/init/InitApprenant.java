package sn.edu.isepat.tic.dbe.p6.GestionScolarite.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.entities.Apprenant;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.entities.Genre;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.repositories.ApprenantRepository;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor
//@Profile("dev")
@Profile({"dev", "test"})
@Component
public class InitApprenant implements CommandLineRunner {

    private final ApprenantRepository apprenantRepository;
    @Value("${isep.taux.fille}")
    private Double tauxFille;

    @Value("${isep.taux.etranger}")
    private Double tauxEtranger;

    @Value("${isep.dbe.nbreApprenants}")
    private Integer nbApprenants;


    @Override
    public void run(String... args) throws Exception {
        generateApprenants(50,1);
        generateApprenants(40,2);
        generateApprenants(43,3);
        generateApprenants(38,4);
        generateApprenants(25,5);
        generateApprenants(34,6);
        generateApprenants(41,7);
    }

    private String getRandom(String[] tableau){
        Random rand = new Random();
        // genere un nombre entre zero et la taille du tableau
        int indice = rand.nextInt(tableau.length);
        //retourne l'élément qui se trouve à l'indice generee aleatoirement
        return tableau[indice];
    }

    public void generateApprenants(int nbre, int promo){
        for (int i = 0; i < nbre; i++) {
            String nom;
            String prenom;
            Genre genre;
            Boolean etranger;
            double aleaEtranger=Math.random();
            double aleaFille=Math.random();
            log.info("aleaEtranger: {}" , aleaEtranger);
            log.info("aleaFille: {}" , aleaFille);

            if(aleaFille<tauxFille) {
                genre=Genre.FEMININ;
            }else{
                genre=Genre.MASCULIN;
            }

            if(aleaEtranger<tauxEtranger) {
                etranger=true;
            }else {
                etranger=false;
            }

            if (etranger) {
                log.info("on va generer un etranger" );
                nom=getRandom(DataUtils.NOMS_AFRICAINS);
                if(aleaFille < tauxFille) {
                    prenom=getRandom(DataUtils.PRENOMS_FILLES_AFRICAINES);
                }else{
                    prenom=getRandom(DataUtils.PRENOMS_GARCONS_AFRICAINS);
                }
            }else{
                log.info("on va generer un sénégalais" );
                nom=getRandom(DataUtils.NOMS_SENEGAL);
                if(aleaFille<tauxFille) {
                    prenom=getRandom(DataUtils.PRENOMS_FILLES_SN);
                }else{
                    prenom=getRandom(DataUtils.PRENOMS_GARCONS_SN);
                }
            }
            String email=prenom+nom+promo+"_"+i+"@isepat.edu.sn";
            log.info("nom: {}" , nom);
            log.info("prenom: {}" , prenom);
            log.info("etranger: {}" , etranger);
            log.info("genre: {}" , genre);
            Apprenant apprenant=new Apprenant();
            apprenant.setNom(nom);
            apprenant.setPrenom(prenom);
            apprenant.setEtranger(etranger);
            apprenant.setGenre(genre);
            apprenant.setPromo(promo);
            apprenant.setEmail(email);
            apprenantRepository.save(apprenant);
        }
    }
}
