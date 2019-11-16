package parasolution.queremosouvirvoce.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import parasolution.queremosouvirvoce.datamodel.ClienteDataModel;
import parasolution.queremosouvirvoce.datamodel.PerguntasDataModel;
import parasolution.queremosouvirvoce.datamodel.RespostasDataModel;
import parasolution.queremosouvirvoce.datamodel.UsuarioDataModel;
import parasolution.queremosouvirvoce.model.Cliente;
import parasolution.queremosouvirvoce.model.Perguntas;
import parasolution.queremosouvirvoce.model.Respostas;
import parasolution.queremosouvirvoce.model.Usuario;

public class DataSource extends SQLiteOpenHelper {
    private static final String DB_NAME = "bdApp.sqlite";
    private static final int DB_VERSION = 1;

    private Cursor cursor;

    private SQLiteDatabase db;

    public DataSource(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        try {

            db.execSQL(PerguntasDataModel.criarTabelaPerguntas());
            db.execSQL(RespostasDataModel.criarTabelaRespostas());
            db.execSQL(ClienteDataModel.criarTabelaCliente());
            db.execSQL(UsuarioDataModel.criarTabelaUsuario());

            Log.i("AVISO", "DB--->  GERAR TABELAS:");
        } catch (Exception e) {

            Log.e("Erro", "DB---> ERRO AO GERAR TABELAS: " + e.getMessage());

        }
        popularTabelaPerguntas();
        inserirAdministrador();
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //alterar a versão ele apaga(DROP TABLE) as tabelas e cria novamente
        db.execSQL("DROP TABLE IF EXISTS " + UsuarioDataModel.getTABELA());
        db.execSQL("DROP TABLE IF EXISTS " + ClienteDataModel.getTABELA());
        db.execSQL("DROP TABLE IF EXISTS " + PerguntasDataModel.getTABELA());
        db.execSQL("DROP TABLE IF EXISTS " + RespostasDataModel.getTABELA());
        onCreate(db);

    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    //POPULAR TABELA PERGUNTAS
    public void popularTabelaPerguntas(){
        Perguntas perguntas1 = new Perguntas("atendimento","O que você achou do nosso atendimento?",
                "Você acha que nosso atendimento poderia melhorar?");
        adcionarPerguntas(perguntas1);

        Perguntas perguntas2 = new Perguntas("ambiente","Você achou nosso ambiente agradável?",
                "Você acha que poderíamos melhorar nosso ambiente?");
        adcionarPerguntas(perguntas2);

        Perguntas perguntas3 = new Perguntas("cafe","Você ficou satisfeito(a) com nosso café?",
                "O nosso café poderia melhorar?");
        adcionarPerguntas(perguntas3);

        Perguntas perguntas4 = new Perguntas("bebidas","O que achou das nossas bebidas?",
                "Você acha que nossas bebidas poderiam ser melhores?");
        adcionarPerguntas(perguntas4);

        Perguntas perguntas5 = new Perguntas("happyhour","Você gostou dos nossos drinks?",
                "Você acha que nossos drinks poderiam ser melhores?");
        adcionarPerguntas(perguntas5);

        Perguntas perguntas6 = new Perguntas("pratos","Você ficou satisfeito(a) em relação aos nossos pratos?",
                "Você acha que nossos pratos poderiam ser melhores?");
        adcionarPerguntas(perguntas6);

        Perguntas perguntas7 = new Perguntas("doces","Você ficou satisfeito(a) com a qualidade dos nossos doces?",
                "Nossos doces poderiam ser melhores de alguma maneira?");
        adcionarPerguntas(perguntas7);

        Perguntas perguntas8 = new Perguntas("salgados","O que achou dos nossos salgados?",
                "Você acha que nossos salgados poderiam ser melhorados?");
        adcionarPerguntas(perguntas8);

        Perguntas perguntas9 = new Perguntas("boutique","O que achou da qualidade dos produtos da Boutique?",
                "Os produtos da Boutique poderiam ser melhores?");
        adcionarPerguntas(perguntas9);
    }

    private void adcionarPerguntas(Perguntas perguntas) {
        ContentValues cv = new ContentValues();
        cv.put(PerguntasDataModel.getCategoria(), perguntas.getCategoria());
        cv.put(PerguntasDataModel.getPerguntaCerteza(),perguntas.getPerguntaCerteza());
        cv.put(PerguntasDataModel.getPerguntaIncerteza(),perguntas.getPerguntaIncerteza());

        db.insert(PerguntasDataModel.getTABELA(), null, cv);
    }

    //INSERIR USUARIO ADMINISTRADOR
    private void inserirAdministrador(){
        Usuario usuario = new Usuario("ADMIN", "admin", "admin");
        adcionarAdministrador(usuario);
    }

    private boolean adcionarAdministrador(Usuario usuario) {
        boolean sucesso = true;

        ContentValues dados = new ContentValues();

        dados.put(UsuarioDataModel.getNome(), usuario.getNome());
        dados.put(UsuarioDataModel.getUsuario(), usuario.getUsuario());
        dados.put(UsuarioDataModel.getSenha(), usuario.getSenha());

        sucesso = insert(UsuarioDataModel.getTABELA(),dados);

        return sucesso;
    }

    //INSERIR
   public boolean insert(String tabela, ContentValues dados) {

        boolean sucesso = true;
        try {
            sucesso = db.insert(tabela, null,
                    dados) > 0;
        } catch (Exception e) {

            sucesso = false;
        }

        return sucesso;
    }

    //DELETAR
    public boolean deletar(String tabela, int id) {

        boolean sucesso = true;

        sucesso = db.delete(tabela, "id=?",
                new String[]{Integer.toString(id)}) > 0;

        return sucesso;
    }

    //ALTERAR
    public boolean alterar(String tabela, ContentValues dados) {

        boolean sucesso = true;

        int id = dados.getAsInteger("id");

        sucesso = db.update(tabela, dados, "id=?",
                new String[]{Integer.toString(id)}) > 0;

        return sucesso;
    }

    //LISTAR (PERGUNTAS)
    public List<Perguntas> getAllPerguntas(){

        Perguntas perguntas;

        List<Perguntas> perguntasList = new ArrayList<>();

        String sql = "SELECT * FROM " + PerguntasDataModel.getTABELA() + " ORDER BY id";

        cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                perguntas = new Perguntas();

                perguntas.setId(cursor.getInt(cursor.getColumnIndex(PerguntasDataModel.getId())));
                perguntas.setCategoria(cursor.getString(cursor.getColumnIndex(PerguntasDataModel.getCategoria())));
                perguntas.setPerguntaCerteza(cursor.getString(cursor.getColumnIndex(PerguntasDataModel.getPerguntaCerteza())));
                perguntas.setPerguntaIncerteza(cursor.getString(cursor.getColumnIndex(PerguntasDataModel.getPerguntaIncerteza())));

                perguntasList.add(perguntas);

            }while (cursor.moveToNext());
        }
        cursor.close();

        return perguntasList;
    }

    public ArrayList<Perguntas> getPerguntasLista(String categoria){

        Perguntas perguntas;

        ArrayList<Perguntas> perguntasLista = new ArrayList<>();

        String sql = "SELECT * FROM " + PerguntasDataModel.getTABELA() + " WHERE " + PerguntasDataModel.getCategoria()
                + " IN (" + categoria + " 'ambiente', 'atendimento') ORDER BY id DESC";

        cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                perguntas = new Perguntas();

                perguntas.setId(cursor.getInt(cursor.getColumnIndex(PerguntasDataModel.getId())));
                perguntas.setPerguntaCerteza(cursor.getString(cursor.getColumnIndex(PerguntasDataModel.getPerguntaCerteza())));
                perguntas.setPerguntaIncerteza(cursor.getString(cursor.getColumnIndex(PerguntasDataModel.getPerguntaIncerteza())));

                perguntasLista.add(perguntas);

            }while (cursor.moveToNext());
        }
        cursor.close();

        return perguntasLista;
    }


    //LISTAR (RESPOSTAS)
    public List<Respostas> getAllRespostas(){

        Respostas respostas;

        List<Respostas> respostasLista = new ArrayList<>();

        String sql = "SELECT * FROM " + RespostasDataModel.getTABELA() + " ORDER BY id";

        cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                respostas = new Respostas();

                respostas.setId(cursor.getInt(cursor.getColumnIndex(RespostasDataModel.getId())));
                respostas.setDataResposta(cursor.getString(cursor.getColumnIndex(RespostasDataModel.getDataResposta())));
                respostas.setRespostaCerteza(cursor.getDouble(cursor.getColumnIndex(RespostasDataModel.getMi())));
                respostas.setRespostaIncerteza(cursor.getDouble(cursor.getColumnIndex(RespostasDataModel.getLambda())));
                respostas.setPeriodo(cursor.getString(cursor.getColumnIndex(RespostasDataModel.getPeriodo())));
                respostas.setGrupos(cursor.getString(cursor.getColumnIndex(RespostasDataModel.getGrupo())));
                respostas.setIdPergunta(cursor.getInt(cursor.getColumnIndex(RespostasDataModel.getId())));

                respostasLista.add(respostas);

            }while (cursor.moveToNext());
        }
        cursor.close();

        return respostasLista;
    }

    //LISTAR (CIENTES)
    public List<Cliente> getAllClientes(){

        Cliente cliente;

        List<Cliente> clienteLista = new ArrayList<>();

        String sql = "SELECT * FROM " + ClienteDataModel.getTABELA() + " ORDER BY id";

        cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                cliente = new Cliente();

                cliente.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.getId())));
                cliente.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getNome())));
                cliente.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getEmail())));
                cliente.setNascimento(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getNascimento())));
                cliente.setTelefone(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getTelefone())));
                cliente.setNotificacao(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getNotificacao())));
                cliente.setMensagem(cursor.getString(cursor.getColumnIndex(ClienteDataModel.getMensagem())));


                clienteLista.add(cliente);

            }while (cursor.moveToNext());
        }
        cursor.close();

        return clienteLista;
    }

    //LISTAR(BUSCAR)

    public List<Usuario> getAllUsuarios() {

        Usuario usuario;

        // TIPADA
        List<Usuario> usuariolista = new ArrayList<>();

        String sql = "SELECT * FROM " + UsuarioDataModel.getTABELA();

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                usuario = new Usuario();

                usuario.setId(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.getId())));//passa o  nome da coluna
                usuario.setUsuario(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.getUsuario())));
                usuario.setNome(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.getNome())));
                usuario.setSenha(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.getSenha())));

                usuariolista.add(usuario);

            } while (cursor.moveToNext());

        }

        cursor.close();

        return usuariolista;
    }

    public String validarUsuarioSenha (String usuario, String senha){

        String sql = "SELECT * FROM " + UsuarioDataModel.getTABELA() + " WHERE "
                + UsuarioDataModel.getUsuario() + "=? AND " + UsuarioDataModel.getSenha() + "=?";

        cursor = db.rawQuery(sql, new String[]{usuario, senha});

        if (cursor.getCount() > 0) {
            return "OK";
        }
        return "ERRO";
    }

}
