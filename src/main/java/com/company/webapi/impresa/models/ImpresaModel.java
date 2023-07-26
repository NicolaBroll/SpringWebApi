package com.company.webapi.impresa.models;

public class ImpresaModel {

    private Integer id;
    private Integer anno;
    private String chiave;
    private String ragioneSociale;
    private String pivaCF;

    public ImpresaModel() { }

    public ImpresaModel(Integer id, Integer anno, String chiave, String ragioneSociale, String pivaCF) {
        this.id = id;
        this.anno = anno;
        this.chiave = chiave;
        this.ragioneSociale = ragioneSociale;
        this.pivaCF = pivaCF;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public String getChiave() {
        return chiave;
    }

    public void setChiave(String chiave) {
        this.chiave = chiave;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getPivaCF() {
        return pivaCF;
    }

    public void setPivaCF(String pivaCF) {
        this.pivaCF = pivaCF;
    }
}