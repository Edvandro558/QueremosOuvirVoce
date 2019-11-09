package parasolution.queremosouvirvoce.datamodel;

public class  PerguntasDataModel {

    private final static String TABELA = "perguntas";

    private final static String id = "id";
    private final static String categoria = "categoria";
    private final static String perguntaCerteza = "perguntaCerteza";
    private final static String perguntaIncerteza = "perguntaIncerteza";

    private static String queryCriarTabela = "";

    public static String criarTabelaPerguntas(){
        queryCriarTabela = "CREATE TABLE "+TABELA;
        queryCriarTabela += " (";
        queryCriarTabela += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += perguntaCerteza + " TEXT, ";
        queryCriarTabela += perguntaIncerteza + " TEXT, ";
        queryCriarTabela += categoria + " TEXT ";
        queryCriarTabela += " )";

        return queryCriarTabela;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getId() {
        return id;
    }

    public static String getCategoria() {
        return categoria;
    }

    public static String getPerguntaCerteza() {
        return perguntaCerteza;
    }

    public static String getPerguntaIncerteza() {
        return perguntaIncerteza;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        PerguntasDataModel.queryCriarTabela = queryCriarTabela;
    }
}
