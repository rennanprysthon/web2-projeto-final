package br.edu.ifpe.recife.bazar.dtos;

public class LoteDTO {
    private Long orgaoDonatarioId;
    private Long orgaoFiscalizadorId;

    public LoteDTO() {}

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
