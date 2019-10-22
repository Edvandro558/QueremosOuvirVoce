package parasolution.queremosouvirvoce.datamodel;

public class RespostasDataModel {
    private final static String TABELA = "tblRespostas";

    private final static String id = "id";
    private final static String dataRes = "dataRes";
    private final static String mi = "mi";
    private final static String lambda = "lambda";
    private final static String grupo = "grupo";
    private final static String periodo = "periodo";
    private final static String idPer = "idPer";


    private static String queryCriarTabelaRespostas = "";


    public static String criarTabelaRespostas() {

        queryCriarTabelaRespostas = "CREATE TABLE " + TABELA;
        queryCriarTabelaRespostas += "(";
        queryCriarTabelaRespostas += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabelaRespostas += dataRes + " TEXT, ";
        queryCriarTabelaRespostas += mi + " REAL, ";
        queryCriarTabelaRespostas += lambda + " REAL, ";
        queryCriarTabelaRespostas += grupo + " TEXT, ";
        queryCriarTabelaRespostas += periodo + " REAL, ";
        queryCriarTabelaRespostas += idPer + " INTEGER , FOREIGN KEY (idPer) REFERENCES tblPerguntas (id)); ";
        queryCriarTabelaRespostas += ")";

        return queryCriarTabelaRespostas;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getId() {
        return id;
    }

    public static String getDataRes() {
        return dataRes;
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

    public static String getIdPer() {
        return idPer;
    }

    public static String getQueryCriarTabelaRespostas() {
        return queryCriarTabelaRespostas;
    }

    public static void setQueryCriarTabelaRespostas(String queryCriarTabelaRespostas) {
        RespostasDataModel.queryCriarTabelaRespostas = queryCriarTabelaRespostas;
    }

}
