package br.edu.ifpe.recife.bazar.controllers;

import br.edu.ifpe.recife.bazar.service.OrgaoDonatarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "orgao-donatario")
public class OrgaoDonatarioController {
    private final OrgaoDonatarioService _orgaoDonatarioService;

    public OrgaoDonatarioController(OrgaoDonatarioService orgaoDonatarioService) {
        this._orgaoDonatarioService = orgaoDonatarioService;
    }
}
