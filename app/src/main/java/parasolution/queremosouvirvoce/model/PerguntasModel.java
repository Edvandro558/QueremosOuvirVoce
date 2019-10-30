package parasolution.queremosouvirvoce.model;

public class PerguntasModel {

    private String txt_pergunta_certeza;
    private String txt_pergunta_incerteza;
    private Double pessimo;
    private Double ruim;
    private Double neutro;
    private Double bom;
    private Double otimo;
    private Double precisaMuito;
    private Double precisa;
    private Double talvez;
    private Double precisaPouco;
    private Double naoPrecisa;

    public PerguntasModel(String txt_pergunta_certeza, String txt_pergunta_incerteza) {
        this.txt_pergunta_certeza = txt_pergunta_certeza;
        this.txt_pergunta_incerteza = txt_pergunta_incerteza;
    }

    public String getTxt_pergunta_certeza() {
        return txt_pergunta_certeza;
    }

    public void setTxt_pergunta_certeza(String txt_pergunta_certeza) {
        this.txt_pergunta_certeza = txt_pergunta_certeza;
    }

    public String getTxt_pergunta_incerteza() {
        return txt_pergunta_incerteza;
    }

    public void setTxt_pergunta_incerteza(String txt_pergunta_incerteza) {
        this.txt_pergunta_incerteza = txt_pergunta_incerteza;
    }

    public Double getPessimo() {
        return pessimo;
    }

    public void setPessimo(Double pessimo) {
        this.pessimo = pessimo;
    }

    public Double getRuim() {
        return ruim;
    }

    public void setRuim(Double ruim) {
        this.ruim = ruim;
    }

    public Double getNeutro() {
        return neutro;
    }

    public void setNeutro(Double neutro) {
        this.neutro = neutro;
    }

    public Double getBom() {
        return bom;
    }

    public void setBom(Double bom) {
        this.bom = bom;
    }

    public Double getOtimo() {
        return otimo;
    }

    public void setOtimo(Double otimo) {
        this.otimo = otimo;
    }

    public Double getPrecisaMuito() {
        return precisaMuito;
    }

    public void setPrecisaMuito(Double precisaMuito) {
        this.precisaMuito = precisaMuito;
    }

    public Double getPrecisa() {
        return precisa;
    }

    public void setPrecisa(Double precisa) {
        this.precisa = precisa;
    }

    public Double getTalvez() {
        return talvez;
    }

    public void setTalvez(Double talvez) {
        this.talvez = talvez;
    }

    public Double getPrecisaPouco() {
        return precisaPouco;
    }

    public void setPrecisaPouco(Double precisaPouco) {
        this.precisaPouco = precisaPouco;
    }

    public Double getNaoPrecisa() {
        return naoPrecisa;
    }

    public void setNaoPrecisa(Double naoPrecisa) {
        this.naoPrecisa = naoPrecisa;
    }
}
