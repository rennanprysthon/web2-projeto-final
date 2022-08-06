package br.edu.ifpe.recife.bazar.service;

import br.edu.ifpe.recife.bazar.repository.OrgaoFiscalizadorRepository;
import org.springframework.stereotype.Service;

@Service
public class OrgaoFiscalizadorService {
    private final OrgaoFiscalizadorRepository _orgaoFiscalizadorRepository;

    public OrgaoFiscalizadorService(OrgaoFiscalizadorRepository orgaoFiscalizadorRepository) {
        this._orgaoFiscalizadorRepository = orgaoFiscalizadorRepository;
    }
}
