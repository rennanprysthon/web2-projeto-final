package br.edu.ifpe.recife.bazar.dtos;

import java.util.Set;

public class LoteDTO {
    private String dataEntrega;
    private String orgaoDonatario;
    private Set<ProdutoDTO> produtos;

    public LoteDTO() {
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getOrgaoDonatario() {
        return orgaoDonatario;
    }

    public void setOrgaoDonatario(String orgaoDonatario) {
        this.orgaoDonatario = orgaoDonatario;
    }

    public Set<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }
}
