package parasolution.queremosouvirvoce.datamodel;

public class UsuarioDataModel {

    private final static String TABELA = "usuario";
    private final static String id = "id";
    private final static String nome = "nome";
    private final static String usuario = "usuario";
    private final static String senha = "senha";

    private static String queryCriarTabela = "";

    public static String criarTabelaUsuario() {

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela += "(";
        queryCriarTabela += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += nome + " TEXT NOT NULL, ";
        queryCriarTabela += usuario + " TEXT NOT NULL UNIQUE, ";
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

    public static String getNome() {
        return nome;
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
        UsuarioDataModel.queryCriarTabela = queryCriarTabela;
    }
}
