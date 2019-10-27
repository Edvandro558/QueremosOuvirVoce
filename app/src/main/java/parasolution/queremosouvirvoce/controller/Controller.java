package parasolution.queremosouvirvoce.controller;

import android.content.ContentValues;
import android.content.Context;

import parasolution.queremosouvirvoce.datamodel.LoginDataModel;
import parasolution.queremosouvirvoce.datasource.DataSource;
import parasolution.queremosouvirvoce.model.LoginModel;

public class Controller extends DataSource {

    ContentValues dados;

    public Controller(Context context) {
        super(context);
    }

    //salvar usuário e senha
    public boolean salvar(LoginModel objLoginModel) {

        boolean sucesso = true;

        dados = new ContentValues();


        dados.put(LoginDataModel.getUsuario(), objLoginModel.getUsuario());
        dados.put(LoginDataModel.getSenha(), objLoginModel.getSenha());

        sucesso = insert(LoginDataModel.getTABELA(), dados);


        return sucesso;
    }

}


