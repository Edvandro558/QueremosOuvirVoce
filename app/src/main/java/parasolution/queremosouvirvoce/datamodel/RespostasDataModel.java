package parasolution.queremosouvirvoce.datamodel;

public class RespostasDataModel {
    private final static String TABELA = "respostas";

    private final static String id = "id";
    private final static String dataResposta = "dataResposta";
    private final static String mi = "mi";
    private final static String lambda = "lambda";
    private final static String grupo = "grupo";
    private final static String periodo = "periodo";
    private final static String idPergunta = "idPergunta";


    private static String queryCriarTabelaRespostas = "";


    public static String criarTabelaRespostas() {

        queryCriarTabelaRespostas = "CREATE TABLE " + TABELA;
        queryCriarTabelaRespostas += "(";
        queryCriarTabelaRespostas += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabelaRespostas += dataResposta + " DATE, ";
        queryCriarTabelaRespostas += mi + " REAL, ";
        queryCriarTabelaRespostas += lambda + " REAL, ";
        queryCriarTabelaRespostas += grupo + " TEXT, ";
        queryCriarTabelaRespostas += periodo + " TEXT, ";
        queryCriarTabelaRespostas += idPergunta + " INTEGER, FOREIGN KEY (" + idPergunta + ") REFERENCES " +
                PerguntasDataModel.getTABELA() + "(" + PerguntasDataModel.getId() + ")" + "ON DELETE CASCADE";
        queryCriarTabelaRespostas += ")";

        return queryCriarTabelaRespostas;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getId() {
        return id;
    }

    public static String getDataResposta() {
        return dataResposta;
    }

    public static String getMi() {
        return mi;
    }

    public static String getLambda() {
        return lambda;
    }

    public static String getGrupo() {
        return grupo;
    }

    public static String getPeriodo() {
        return periodo;
    }

    public static String getIdPergunta() {
        return idPergunta;
    }

    public static String getQueryCriarTabelaRespostas() {
        return queryCriarTabelaRespostas;
    }

    public static void setQueryCriarTabelaRespostas(String queryCriarTabelaRespostas) {
        RespostasDataModel.queryCriarTabelaRespostas = queryCriarTabelaRespostas;
    }

}
