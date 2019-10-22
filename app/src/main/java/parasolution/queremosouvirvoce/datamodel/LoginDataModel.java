package parasolution.queremosouvirvoce.datamodel;

public class LoginDataModel {

    private final static String TABELA = "login";
    private final static String id = "id";
    private final static String usuario = "usuario";
    private final static String senha = "senha";

    private static String queryCriarTabela = "";

    public static String criarTabela() {

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela += "(";
        queryCriarTabela += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += usuario + " TEXT NOT NULL, ";
        queryCriarTabela += senha + " TEXT NOT NULL";
        queryCriarTabela += ")";

        return queryCriarTabela;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getId() {
        return id;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static String getSenha() {
        return senha;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        LoginDataModel.queryCriarTabela = queryCriarTabela;
    }
}
