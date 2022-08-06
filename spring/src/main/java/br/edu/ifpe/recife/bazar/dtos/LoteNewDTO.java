package br.edu.ifpe.recife.bazar.dtos;

import java.util.HashSet;
import java.util.Set;

public class LoteNewDTO {
    private Long orgaoDonatarioId;
    private Long orgaoFiscalizadorId;
    private Set<ProdutoNewDTO> produtos = new HashSet<>();

    public LoteNewDTO() {}

    public Long getOrgaoDonatarioId() {
        return orgaoDonatarioId;
    }

    public void setOrgaoDonatarioId(Long orgaoDonatarioId) {
        this.orgaoDonatarioId = orgaoDonatarioId;
    }

    public Long getOrgaoFiscalizadorId() {
        return orgaoFiscalizadorId;
    }

    public void setOrgaoFiscalizadorId(Long orgaoFiscalizadorId) {
        this.orgaoFiscalizadorId = orgaoFiscalizadorId;
    }

    public Set<ProdutoNewDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<ProdutoNewDTO> produtos) {
        this.produtos = produtos;
    }
}
