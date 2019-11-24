package parasolution.queremosouvirvoce.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import parasolution.queremosouvirvoce.datamodel.ClienteDataModel;
import parasolution.queremosouvirvoce.datasource.DataSource;
import parasolution.queremosouvirvoce.model.Cliente;

public class ClienteController extends DataSource {

    ContentValues dados;

    public ClienteController(Context context) {
        super(context);
    }

    public ArrayList<Cliente> listar(){
        return getAllClientes();
    }

    public boolean salvar(Cliente cliente){
        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(ClienteDataModel.getNome(), cliente.getNome());
        dados.put(ClienteDataModel.getNascimento(), cliente.getNascimento());
        dados.put(ClienteDataModel.getTelefone(), cliente.getTelefone());
        dados.put(ClienteDataModel.getEmail(), cliente.getEmail());
        dados.put(ClienteDataModel.getNotificacao(), cliente.getNotificacao());
        dados.put(ClienteDataModel.getMensagem(), cliente.getMensagem());

        sucesso = insert(ClienteDataModel.getTABELA(),dados);

        return sucesso;
    }

    //TODO: Remover método deletar caso não necessário
    public boolean deletar(Cliente cliente){
        boolean sucesso = true;

        sucesso = deletar(ClienteDataModel.getTABELA(), cliente.getId());

        return sucesso;
    }

    //TODO: Remover método alterar caso não necessário
    public boolean alterar(Cliente cliente){
        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(ClienteDataModel.getId(), cliente.getId());
        dados.put(ClienteDataModel.getNome(), cliente.getNome());
        dados.put(ClienteDataModel.getNascimento(), cliente.getNascimento());
        dados.put(ClienteDataModel.getTelefone(), cliente.getTelefone());
        dados.put(ClienteDataModel.getEmail(), cliente.getEmail());
        dados.put(ClienteDataModel.getNotificacao(), cliente.getNotificacao());
        dados.put(ClienteDataModel.getMensagem(), cliente.getMensagem());

        sucesso = insert(ClienteDataModel.getTABELA(),dados);

        return sucesso;
    }

}
