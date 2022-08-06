package br.edu.ifpe.recife.bazar.dtos;

public class ProdutoNewDTO {
    private Long loteId;
    private String nome;
    private String descricao;
    public ProdutoNewDTO() {}

    public String getDescricao() {
        return descricao;
    }

    public Long getLoteId() {
        return loteId;
    }

    public String getNome() {
        return nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLoteId(Long loteId) {
        this.loteId = loteId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
