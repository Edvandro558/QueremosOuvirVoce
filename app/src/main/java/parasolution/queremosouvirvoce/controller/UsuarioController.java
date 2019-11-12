package parasolution.queremosouvirvoce.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import parasolution.queremosouvirvoce.datamodel.UsuarioDataModel;
import parasolution.queremosouvirvoce.datasource.DataSource;
import parasolution.queremosouvirvoce.model.Usuario;

public class UsuarioController extends DataSource {

    ContentValues dados;

    public UsuarioController(Context context) {
        super(context);
    }

    public boolean validarLogin(String usuario, String senha){
        if(validarUsuarioSenha(usuario, senha).contains("OK")){
            return true;
        } else {
            return false;
        }
    }

    public List<Usuario> listar(){
        return getAllUsuarios();
    }

    public boolean salvar(Usuario usuario){
        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(UsuarioDataModel.getNome(), usuario.getNome());
        dados.put(UsuarioDataModel.getUsuario(), usuario.getUsuario());
        dados.put(UsuarioDataModel.getSenha(), usuario.getSenha());

        sucesso = insert(UsuarioDataModel.getTABELA(),dados);

        return sucesso;
    }

    //TODO: Remover método deletar caso não necessário
    public boolean deletar(Usuario usuario){
        boolean sucesso = true;

        sucesso = deletar(UsuarioDataModel.getTABELA(), usuario.getId());

        return sucesso;
    }

    //TODO: Remover método alterar caso não necessário
    public boolean alterar(Usuario usuario){
        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(UsuarioDataModel.getId(), usuario.getId());
        dados.put(UsuarioDataModel.getNome(), usuario.getNome());
        dados.put(UsuarioDataModel.getUsuario(), usuario.getUsuario());
        dados.put(UsuarioDataModel.getSenha(), usuario.getSenha());

        sucesso = insert(UsuarioDataModel.getTABELA(),dados);

        return sucesso;
    }
}
