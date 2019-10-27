package parasolution.queremosouvirvoce.datamodel;

public class PerguntasDataModel {

    private final static String TABELA = "tblPerguntas";

    private final static String id = "id";
    private final static String perguntas = "materia";

    private static String queryCriarTabelaPerguntas = "";

    // Criar dinamicamente uma query SQL para criar
    // a tabela Média Escolar no Banco de Dados

    public static String criarTabelaPerguntas() {

        queryCriarTabelaPerguntas = "CREATE TABLE " + TABELA;
        queryCriarTabelaPerguntas += "(";
        queryCriarTabelaPerguntas += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabelaPerguntas += perguntas + " TEXT ";
        queryCriarTabelaPerguntas += ")";

        return queryCriarTabelaPerguntas;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getId() {
        return id;
    }

    public static String getPerguntas() {
        return perguntas;
    }

    public static String getQueryCriarTabelaPerguntas() {
        return queryCriarTabelaPerguntas;
    }

    public static void setQueryCriarTabelaPerguntas(String queryCriarTabelaPerguntas) {
        PerguntasDataModel.queryCriarTabelaPerguntas = queryCriarTabelaPerguntas;
    }
}
