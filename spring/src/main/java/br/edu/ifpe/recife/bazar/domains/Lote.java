package br.edu.ifpe.recife.bazar.domains;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lote")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "data_entrega")
    private LocalDateTime dataEntrega;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_orgao_donatario")
    private OrgaoDonatario orgaoDonatario;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_orgao_fiscalizador")
    private OrgaoFiscalizador orgaoFiscalizador;
    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL)
    private Set<Produto> produtos = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public OrgaoDonatario getOrgaoDonatario() {
        return orgaoDonatario;
    }

    public void setOrgaoDonatario(OrgaoDonatario orgaoDonatario) {
        this.orgaoDonatario = orgaoDonatario;
    }

    public OrgaoFiscalizador getOrgaoFiscalizador() {
        return orgaoFiscalizador;
    }

    public void setOrgaoFiscalizador(OrgaoFiscalizador orgaoFiscalizador) {
        this.orgaoFiscalizador = orgaoFiscalizador;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}
