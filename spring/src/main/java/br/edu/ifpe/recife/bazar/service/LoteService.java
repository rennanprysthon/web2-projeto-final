package br.edu.ifpe.recife.bazar.service;

import br.edu.ifpe.recife.bazar.domains.Lote;
import br.edu.ifpe.recife.bazar.domains.OrgaoDonatario;
import br.edu.ifpe.recife.bazar.domains.OrgaoFiscalizador;
import br.edu.ifpe.recife.bazar.dtos.LoteDTO;
import br.edu.ifpe.recife.bazar.exceptions.EntityNotFound;
import br.edu.ifpe.recife.bazar.exceptions.TempoMinimoNaoAtingidoException;
import br.edu.ifpe.recife.bazar.repository.LoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class LoteService {
    private static final Long MAX_MINUTES = 30L;
    private static final String ERROR_MINUTES_MESSAGE = "Tem que aguardar 30 minutos da criacao do lote para poder deleta-lo. So se passaram %s minutos";

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
        lote.setDataEntrega(LocalDateTime.now());
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

        _verificarTempoDataEntrega(lote);

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
        LocalDateTime dataEntrega = lote.getDataEntrega();
        LocalDateTime dataAtual = LocalDateTime.now();

        Long minutes = dataEntrega.until(dataAtual, ChronoUnit.MINUTES);

        if (minutes <= MAX_MINUTES) {
            throw new TempoMinimoNaoAtingidoException(String.format(ERROR_MINUTES_MESSAGE, minutes));
        }
    }
}
