package br.edu.ifpe.recife.bazar.controllers;

import br.edu.ifpe.recife.bazar.service.LoteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "lote")
public class LoteController {
    private final LoteService _loteService;

    public LoteController(LoteService loteService) {
        this._loteService = loteService;
    }
}
