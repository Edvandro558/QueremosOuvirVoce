package parasolution.queremosouvirvoce.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import parasolution.queremosouvirvoce.datamodel.PerguntasDataModel;
import parasolution.queremosouvirvoce.datamodel.RespostasDataModel;
import parasolution.queremosouvirvoce.model.Perguntas;
import parasolution.queremosouvirvoce.model.Respostas;

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

            Log.i("AVISO", "DB--->  GERAR TABELAS:");
        } catch (Exception e) {

            Log.e("Erro", "DB---> ERRO AO GERAR TABELAS: " + e.getMessage());

        }
        popularTabelaPerguntas();
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       /* //alterar a versão ele apaga(DROP TABLE) as tabelas e cria novamente
        db.execSQL("DROP TABLE IF EXISTS login;");
        db.execSQL("DROP TABLE IF EXISTS cliente;");
        db.execSQL("DROP TABLE IF EXISTS " + PerguntasDataModel.getTABELA());
        db.execSQL("DROP TABLE IF EXISTS " + RespostasDataModel.getTABELA());
        onCreate(db); */

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
                "Você acha que poderiamos melhorar nosso ambiente?");
        adcionarPerguntas(perguntas2);

        Perguntas perguntas3 = new Perguntas("cafe","Você ficou satistfeito(a) com nosso café?",
                "O nosso café poderia melhorar?");
        adcionarPerguntas(perguntas3);

        Perguntas perguntas4 = new Perguntas("bebidas","O que achou de nossas bebidas?",
                "Você acha que nossas bebidas poderiam ser melhores?");
        adcionarPerguntas(perguntas4);

        Perguntas perguntas5 = new Perguntas("happyhour","Você gostou dos nossos drinks?",
                "Você acha que nossos drinks poderiam ser melhores?");
        adcionarPerguntas(perguntas5);

        Perguntas perguntas6 = new Perguntas("pratos","Você ficou satisfeito(a) em relação aos nossos pratos",
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

        String sql = "SELECT * FROM " + PerguntasDataModel.getTABELA() + " WHERE "
                + PerguntasDataModel.getCategoria() + " IN ("+categoria+" 'ambiente', 'atendimento') ORDER BY id DESC";

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

    //LISTAR(BUSCAR)

    /*public List<LoginModel> getAllUsuarios() {

        LoginModel objLoginModel;

        // TIPADA
        List<LoginModel> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + LoginDataModel.getTABELA();

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                objLoginModel = new LoginModel();

                objLoginModel.setId(cursor.getInt(cursor.getColumnIndex(LoginDataModel.getId())));//passa o  nome da coluna
                objLoginModel.setUsuario(cursor.getString(cursor.getColumnIndex(LoginDataModel.getUsuario())));
                objLoginModel.setSenha(cursor.getString(cursor.getColumnIndex(LoginDataModel.getSenha())));

                lista.add(objLoginModel);

            } while (cursor.moveToNext());

        }

        cursor.close();

        return lista;
    } */

}
