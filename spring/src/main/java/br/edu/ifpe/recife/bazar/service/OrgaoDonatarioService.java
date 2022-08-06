package br.edu.ifpe.recife.bazar.service;

import br.edu.ifpe.recife.bazar.repository.OrgaoDonatarioRepository;
import org.springframework.stereotype.Service;

@Service
public class OrgaoDonatarioService {
    private final OrgaoDonatarioRepository _orgaoDonatarioRepository;

    public OrgaoDonatarioService(OrgaoDonatarioRepository orgaoDonatarioRepository) {
        this._orgaoDonatarioRepository = orgaoDonatarioRepository;
    }

}
