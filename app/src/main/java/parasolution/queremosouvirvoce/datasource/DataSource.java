package parasolution.queremosouvirvoce.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import parasolution.queremosouvirvoce.datamodel.CadCliDataModel;
import parasolution.queremosouvirvoce.datamodel.LoginDataModel;
import parasolution.queremosouvirvoce.datamodel.RespostasDataModel;
import parasolution.queremosouvirvoce.datamodel.PerguntasDataModel;
import parasolution.queremosouvirvoce.model.LoginModel;

public class DataSource extends SQLiteOpenHelper {
    private static final String DB_NAME = "bdApp.sqlite";
    private static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public DataSource(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            db.execSQL(CadCliDataModel.criarTabela());
            db.execSQL(LoginDataModel.criarTabela());
            db.execSQL(PerguntasDataModel.criarTabelaPerguntas());
            db.execSQL(RespostasDataModel.criarTabelaRespostas());
            Log.i("AVISO", "DB--->  GERAR TABELAS:");
        } catch (Exception e) {

            Log.e("Erro", "DB---> ERRO AO GERAR TABELAS: " + e.getMessage());

        }

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //alterar a versão ele apaga(DROP TABLE) as tabelas e cria novamente
        db.execSQL("DROP TABLE IF EXISTS login;");
        db.execSQL("DROP TABLE IF EXISTS cliente;");
        db.execSQL("DROP TABLE IF EXISTS tblPerguntas;");
        db.execSQL("DROP TABLE IF EXISTS tblRespostas;");
        onCreate(db);

    }

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

    //LISTAR(BUSCAR)

    public List<LoginModel> getAllUsuarios() {

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
    }

}
