package parasolution.queremosouvirvoce.model;

public class Respostas {

    private int id;
    private String dataResposta;
    private Double respostaCerteza;
    private Double respostaIncerteza;
    private String grupos;
    private String periodo;
    private int idPergunta;

    public Respostas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(String dataResposta) {
        this.dataResposta = dataResposta;
    }

    public Double getRespostaCerteza() {
        return respostaCerteza;
    }

    public void setRespostaCerteza(Double respostaCerteza) {
        this.respostaCerteza = respostaCerteza;
    }

    public Double getRespostaIncerteza() {
        return respostaIncerteza;
    }

    public void setRespostaIncerteza(Double respostaIncerteza) {
        this.respostaIncerteza = respostaIncerteza;
    }

    public String getGrupos() {
        return grupos;
    }

    public void setGrupos(String grupos) {
        this.grupos = grupos;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }
}
