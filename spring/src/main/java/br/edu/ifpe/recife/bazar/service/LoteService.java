package br.edu.ifpe.recife.bazar.service;

import br.edu.ifpe.recife.bazar.repository.LoteRepository;
import org.springframework.stereotype.Service;

@Service
public class LoteService {
    private final LoteRepository _loteRepository;

    public LoteService(LoteRepository loteRepository) {
        this._loteRepository = loteRepository;
    }
}
