package br.edu.ifpe.recife.bazar.dtos;

public class LoteNewDTO {
    private Long orgaoDonatarioId;
    private Long orgaoFiscalizadorId;

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
}
