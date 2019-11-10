package parasolution.queremosouvirvoce.datamodel;

public class ClienteDataModel {

    private final static String TABELA = "cliente";

    private final static String id = "id";
    private final static String nome = "nome";
    private final static String nascimento = "nascimento";
    private final static String telefone = "telefone";
    private final static String email = "email";
    private final static String notificacao = "notificacao";
    private final static String mensagem = "mensagem";

    private static String queryCriarTabela = "";

    public static String criarTabelaCliente() {

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela += "(";
        queryCriarTabela += id + " INTEGER PRIMARY KEY AUTOINCREMENT,";
        queryCriarTabela += nome + " TEXT NOT NULL,";
        queryCriarTabela += nascimento + " TEXT,";
        queryCriarTabela += telefone + " TEXT,";
        queryCriarTabela += email + " TEXT,";
        queryCriarTabela += mensagem + " TEXT,";
        queryCriarTabela += notificacao + " TEXT "; //ERA INTEGER NOT NULL
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

    public static String getNotificacao() {
        return notificacao;
    }

    public static String getMensagem() {
        return mensagem;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        ClienteDataModel.queryCriarTabela = queryCriarTabela;
    }
}
