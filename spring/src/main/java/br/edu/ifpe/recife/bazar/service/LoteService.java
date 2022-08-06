package br.edu.ifpe.recife.bazar.service;

import br.edu.ifpe.recife.bazar.domains.Lote;
import br.edu.ifpe.recife.bazar.domains.OrgaoDonatario;
import br.edu.ifpe.recife.bazar.domains.OrgaoFiscalizador;
import br.edu.ifpe.recife.bazar.dtos.LoteDTO;
import br.edu.ifpe.recife.bazar.exceptions.EntityNotFound;
import br.edu.ifpe.recife.bazar.repository.LoteRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class LoteService {
    private final LoteRepository _loteRepository;
    private final OrgaoDonatarioService _orgaoDonatarioService;
    private final OrgaoFiscalizadorService _orgaoFiscalizadorService;

    public LoteService(LoteRepository _loteRepository, OrgaoDonatarioService _orgaoDonatarioService, OrgaoFiscalizadorService _orgaoFiscalizadorService) {
        this._loteRepository = _loteRepository;
        this._orgaoDonatarioService = _orgaoDonatarioService;
        this._orgaoFiscalizadorService = _orgaoFiscalizadorService;
    }

    public Lote criarLote(LoteDTO loteDTO) {
        OrgaoDonatario orgaoDonatario = this._orgaoDonatarioService.buscarPorId(loteDTO.getOrgaoDonatarioId());
        OrgaoFiscalizador orgaoFiscalizador = this._orgaoFiscalizadorService.buscarPorId(loteDTO.getOrgaoFiscalizadorId());

        Lote lote = new Lote();
        lote.setId(null);
        lote.setDataEntrega(new Timestamp(new Date().getTime()));
        lote.setOrgaoFiscalizador(orgaoFiscalizador);
        lote.setOrgaoDonatario(orgaoDonatario);

        return this._loteRepository.save(lote);
    }

    public void editarLote(Lote lote, Long id) {
        Lote loteOld = this._findLoteById(id);

        lote.setId(id);

        _loteRepository.save(lote);
    }

    public Lote buscarLotePorId(Long id) {
        return _findLoteById(id);
    }

    public void deletarLote(Long id) {
        Lote lote = this._findLoteById(id);

        this._loteRepository.delete(lote);
    }

    public List<Lote> buscarTodos() {
        return this._loteRepository.findAll();
    }

    private Lote _findLoteById(Long id) {
        return this._loteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Lote com id " + id + " nao foi encontrado"));
    }

    private void _verificarTempoDataEntrega(Lote lote) {
        Timestamp dataEntrega = lote.getDataEntrega();
        Timestamp dataAtual = new Timestamp(new Date().getTime());
        Long diferenca = dataAtual.getTime() - dataEntrega.getTime();

        System.out.println(diferenca);
    }
}
