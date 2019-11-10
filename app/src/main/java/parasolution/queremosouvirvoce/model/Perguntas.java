package parasolution.queremosouvirvoce.model;

public class Perguntas {

    private int id;
    private String categoria;
    private String perguntaCerteza;
    private String perguntaIncerteza;

    public Perguntas() {

    }

    public Perguntas(String categoria, String perguntaCerteza, String perguntaIncerteza) {
        this.categoria = categoria;
        this.perguntaCerteza = perguntaCerteza;
        this.perguntaIncerteza = perguntaIncerteza;
    }

    public Perguntas(String perguntaCerteza, String perguntaIncerteza) {
        this.perguntaCerteza = perguntaCerteza;
        this.perguntaIncerteza = perguntaIncerteza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPerguntaCerteza() {
        return perguntaCerteza;
    }

    public void setPerguntaCerteza(String perguntaCerteza) {
        this.perguntaCerteza = perguntaCerteza;
    }

    public String getPerguntaIncerteza() {
        return perguntaIncerteza;
    }

    public void setPerguntaIncerteza(String perguntaIncerteza) {
        this.perguntaIncerteza = perguntaIncerteza;
    }
}
