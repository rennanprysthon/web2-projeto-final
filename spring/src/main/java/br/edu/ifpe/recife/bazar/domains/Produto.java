package br.edu.ifpe.recife.bazar.domains;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", unique = true)
    private Long codigo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "id_lote")
    private Lote lote;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }
}
