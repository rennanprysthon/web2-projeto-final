package br.edu.ifpe.recife.bazar.service;

import br.edu.ifpe.recife.bazar.domains.OrgaoDonatario;
import br.edu.ifpe.recife.bazar.exceptions.EntityNotFound;
import br.edu.ifpe.recife.bazar.repository.OrgaoDonatarioRepository;
import org.springframework.stereotype.Service;

@Service
public class OrgaoDonatarioService {
    private final OrgaoDonatarioRepository _orgaoDonatarioRepository;

    public OrgaoDonatarioService(OrgaoDonatarioRepository orgaoDonatarioRepository) {
        this._orgaoDonatarioRepository = orgaoDonatarioRepository;
    }

    public OrgaoDonatario criarOrgaoDonatario(OrgaoDonatario orgaoDonatario) {
        orgaoDonatario.setId(null);

        return this._orgaoDonatarioRepository.save(orgaoDonatario);
    }

    public OrgaoDonatario buscarPorId(Long id) {
        return this._findById(id);
    }

    private OrgaoDonatario _findById(Long id) {
        return this._orgaoDonatarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Orgao Donatario com id " + id + " nao foi encontrado"));
    }
}
