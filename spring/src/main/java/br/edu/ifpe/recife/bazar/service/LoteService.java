package br.edu.ifpe.recife.bazar.service;

import br.edu.ifpe.recife.bazar.domains.Lote;
import br.edu.ifpe.recife.bazar.domains.OrgaoDonatario;
import br.edu.ifpe.recife.bazar.domains.OrgaoFiscalizador;
import br.edu.ifpe.recife.bazar.domains.Produto;
import br.edu.ifpe.recife.bazar.dtos.LoteNewDTO;
import br.edu.ifpe.recife.bazar.dtos.ProdutoNewDTO;
import br.edu.ifpe.recife.bazar.exceptions.EntityNotFound;
import br.edu.ifpe.recife.bazar.exceptions.TempoMinimoAtingidoException;
import br.edu.ifpe.recife.bazar.repository.LoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class LoteService {
    private static final Long MAX_MINUTES = 30L;
    private static final String ERROR_MINUTES_MESSAGE = "Tempo maximo para excluir  o lote ja passou.";

    private final LoteRepository _loteRepository;
    private final OrgaoDonatarioService _orgaoDonatarioService;
    private final OrgaoFiscalizadorService _orgaoFiscalizadorService;

    public LoteService(LoteRepository _loteRepository, OrgaoDonatarioService _orgaoDonatarioService, OrgaoFiscalizadorService _orgaoFiscalizadorService) {
        this._loteRepository = _loteRepository;
        this._orgaoDonatarioService = _orgaoDonatarioService;
        this._orgaoFiscalizadorService = _orgaoFiscalizadorService;
    }

    public Lote criarLote(LoteNewDTO loteNewDTO) {
        OrgaoDonatario orgaoDonatario = this._orgaoDonatarioService.buscarPorId(loteNewDTO.getOrgaoDonatarioId());
        OrgaoFiscalizador orgaoFiscalizador = this._orgaoFiscalizadorService.buscarPorId(loteNewDTO.getOrgaoFiscalizadorId());

        Lote lote = new Lote();
        lote.setId(null);
        lote.setDataEntrega(LocalDateTime.now());
        lote.setOrgaoFiscalizador(orgaoFiscalizador);
        lote.setOrgaoDonatario(orgaoDonatario);
        lote = this._loteRepository.save(lote);

        lote = _addProductsToLote(lote, loteNewDTO.getProdutos());

        return lote;
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


    public Set<Produto> buscarProdutosPorLote(Long id) {
        Lote lote = this._findLoteById(id);

        return lote.getProdutos();
    }

    private Lote _findLoteById(Long id) {
        return this._loteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Lote com id " + id + " nao foi encontrado"));
    }

    private void _verificarTempoDataEntrega(Lote lote) {
        LocalDateTime dataEntrega = lote.getDataEntrega();
        LocalDateTime dataAtual = LocalDateTime.now();

        Long minutes = dataEntrega.until(dataAtual, ChronoUnit.MINUTES);

        if (minutes >= MAX_MINUTES) {
            throw new TempoMinimoAtingidoException(ERROR_MINUTES_MESSAGE);
        }
    }

    private Lote _addProductsToLote(Lote lote, Set<ProdutoNewDTO> produtosDTO) {
        if (produtosDTO.isEmpty()) {
            return lote;
        }

        Produto produto = null;
        Set<Produto> produtos = new HashSet<>();

        for (ProdutoNewDTO produtoDTO : produtosDTO) {
            produto = new Produto();
            produto.setDescricao(produtoDTO.getDescricao());
            produto.setNome(produtoDTO.getNome());
            produto.setLote(lote);
            produtos.add(produto);
        }

        lote.setProdutos(produtos);

        return this._loteRepository.save(lote);
    }
}
