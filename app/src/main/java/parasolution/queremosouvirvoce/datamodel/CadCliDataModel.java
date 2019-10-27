package parasolution.queremosouvirvoce.datamodel;

public class CadCliDataModel {

    private final static String TABELA = "cliente";

    private final static String id = "id";
    private final static String nome = "nome";
    private final static String nascimento = "nascimento";
    private final static String telefone = "telefone";
    private final static String email = "email";
    private final static String notificao = "notificao";

    private static String queryCriarTabela = "";

    public static String criarTabela() {

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela += "(";
        queryCriarTabela += id + " INTEGER PRIMARY KEY AUTOINCREMENT,";
        queryCriarTabela += nome + " TEXT NOT NULL,";
        queryCriarTabela += nascimento + " TEXT,";
        queryCriarTabela += telefone + " TEXT,";
        queryCriarTabela += email + " TEXT,";
        queryCriarTabela += notificao + " TEXT "; //ERA INTEGER NOT NULL
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

    public static String getNascimento() {
        return nascimento;
    }

    public static String getTelefone() {
        return telefone;
    }

    public static String getEmail() {
        return email;
    }

    public static String getNotificao() {
        return notificao;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        CadCliDataModel.queryCriarTabela = queryCriarTabela;
    }
}
