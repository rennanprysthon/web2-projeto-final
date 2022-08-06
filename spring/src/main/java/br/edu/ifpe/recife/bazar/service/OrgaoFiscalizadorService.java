package br.edu.ifpe.recife.bazar.service;

import br.edu.ifpe.recife.bazar.domains.OrgaoFiscalizador;
import br.edu.ifpe.recife.bazar.exceptions.EntityNotFound;
import br.edu.ifpe.recife.bazar.repository.OrgaoFiscalizadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgaoFiscalizadorService {
    private final OrgaoFiscalizadorRepository _orgaoFiscalizadorRepository;

    public OrgaoFiscalizadorService(OrgaoFiscalizadorRepository orgaoFiscalizadorRepository) {
        this._orgaoFiscalizadorRepository = orgaoFiscalizadorRepository;
    }

    public OrgaoFiscalizador criarOrgaoFiscalizador(OrgaoFiscalizador orgaoFiscalizador) {
        orgaoFiscalizador.setId(null);

        return this._orgaoFiscalizadorRepository.save(orgaoFiscalizador);
    }

    public OrgaoFiscalizador buscarPorId(Long id) {
        return this._findById(id);
    }

    private OrgaoFiscalizador _findById(Long id) {
        return this._orgaoFiscalizadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Orgao Fiscalizador com id " + id + " nao foi encontrado"));
    }

    public List<OrgaoFiscalizador> buscarTodos() {
        return this._orgaoFiscalizadorRepository.findAll();
    }
}
