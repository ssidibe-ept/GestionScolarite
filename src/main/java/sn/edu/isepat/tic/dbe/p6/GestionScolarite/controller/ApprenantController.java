package sn.edu.isepat.tic.dbe.p6.GestionScolarite.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.entities.Apprenant;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.services.ApprenantService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/apprenants")
public class ApprenantController {
    private final ApprenantService apprenantService;


    //Get permet de recuperer des infos
    // (ne doit jamais etre utilisée pour enregistrer des données

    @Operation(
            summary = "resumé",
            description = "description",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "liste retournee avec succes",

                            content = {
                                    @Content(
                                            schema =@Schema(implementation = Apprenant.class),
                                            examples = {
                                                    @ExampleObject(
                                                            name = "reponse normale",
                                                            description = "Réponse contenant une liste non vide d'apprenants",
                                                            value = "[\n" +
                                                                    "  {\n" +
                                                                    "    \"id\": 1,\n" +
                                                                    "    \"prenom\": \"Mouhameth\",\n" +
                                                                    "    \"nom\": \"Leye\",\n" +
                                                                    "    \"email\": \"MouhamethLeye1_0@isepat.edu.sn\",\n" +
                                                                    "    \"etranger\": false,\n" +
                                                                    "    \"genre\": \"MASCULIN\",\n" +
                                                                    "    \"adresse\": null,\n" +
                                                                    "    \"telephone\": null,\n" +
                                                                    "    \"promo\": 1\n" +
                                                                    "  },\n" +
                                                                    "  {\n" +
                                                                    "    \"id\": 2,\n" +
                                                                    "    \"prenom\": \"Aissatou\",\n" +
                                                                    "    \"nom\": \"Gningue\",\n" +
                                                                    "    \"email\": \"AissatouGningue1_1@isepat.edu.sn\",\n" +
                                                                    "    \"etranger\": false,\n" +
                                                                    "    \"genre\": \"FEMININ\",\n" +
                                                                    "    \"adresse\": null,\n" +
                                                                    "    \"telephone\": null,\n" +
                                                                    "    \"promo\": 1\n" +
                                                                    "  }\n" +
                                                                    "]"

                                                    ),
                                                    @ExampleObject(
                                                            name = "liste vide",
                                                            description = "Il n'ya pas d'apprenants en base",
                                                            value = "[]"
                                                    )
                                            }
                                    )
                            }
                    )
            }
    )
    @GetMapping
    public List<Apprenant> getAllApprenants() {
        log.trace("recuperation liste des apprenants");
        return apprenantService.getAllApprenants();
    }

    //apprenants/5
    @GetMapping("/{id}")
    public Apprenant findById(@PathVariable Integer id) {
        log.trace("recherche apprenant dont l'id est {}", id);
        Optional<Apprenant> result=apprenantService.findById(id);
        if (result.isPresent()) {
            Apprenant apprenant = result.get();
            return apprenant;
        }
        return null;
    }

}
