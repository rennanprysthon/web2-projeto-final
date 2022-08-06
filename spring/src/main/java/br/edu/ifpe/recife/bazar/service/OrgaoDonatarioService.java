package br.edu.ifpe.recife.bazar.service;

import br.edu.ifpe.recife.bazar.domains.Lote;
import br.edu.ifpe.recife.bazar.domains.OrgaoDonatario;
import br.edu.ifpe.recife.bazar.domains.Produto;
import br.edu.ifpe.recife.bazar.dtos.LoteDTO;
import br.edu.ifpe.recife.bazar.dtos.ProdutoDTO;
import br.edu.ifpe.recife.bazar.exceptions.EntityNotFound;
import br.edu.ifpe.recife.bazar.repository.OrgaoDonatarioRepository;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<LoteDTO> buscarLotesPorOrgao(Long id) {
        OrgaoDonatario orgaoDonatario = this._findById(id);

        return this.fromLoteEntity(orgaoDonatario.getLotes());
    }

    private OrgaoDonatario _findById(Long id) {
        return this._orgaoDonatarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Orgao Donatario com id " + id + " nao foi encontrado"));
    }

    public List<OrgaoDonatario> buscarTodos() {
        return this._orgaoDonatarioRepository.findAll();
    }

    private Set<LoteDTO> fromLoteEntity(Set<Lote> lotes) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

        Set<LoteDTO> loteDTOs = lotes.stream().map(
            lote -> {
                LoteDTO loteDTO = new LoteDTO();
                loteDTO.setOrgaoDonatario(lote.getOrgaoDonatario().getNome());
                loteDTO.setDataEntrega(lote.getDataEntrega().format(timeFormatter));
                loteDTO.setProdutos(this.fromProdutoEntity(lote.getProdutos()));
                return loteDTO;
            }
        ).collect(Collectors.toSet());

        return loteDTOs;
    }

    private Set<ProdutoDTO> fromProdutoEntity(Set<Produto> produtos) {
        Set<ProdutoDTO> produtoDTOS = produtos
            .stream()
            .map(produto -> {
                ProdutoDTO produtoDTO = new ProdutoDTO();
                produtoDTO.setCodigo(produto.getCodigo());
                produtoDTO.setDescricao(produto.getDescricao());
                produtoDTO.setNome(produto.getNome());
                return produtoDTO;
            }).collect(Collectors.toSet());

        return produtoDTOS;
    }
}
