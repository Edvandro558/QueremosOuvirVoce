package parasolution.queremosouvirvoce.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import parasolution.queremosouvirvoce.datamodel.PerguntasDataModel;
import parasolution.queremosouvirvoce.datamodel.RespostasDataModel;
import parasolution.queremosouvirvoce.datasource.DataSource;
import parasolution.queremosouvirvoce.model.Respostas;

public class RespostasController extends DataSource {

    ContentValues dados;

    public RespostasController(Context context) {
        super(context);
    }

    public List<Respostas> listar(){
        return getAllRespostas();
    }

    public boolean salvar(Respostas respostas){
        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(RespostasDataModel.getDataResposta(),respostas.getDataResposta());
        dados.put(RespostasDataModel.getMi(),respostas.getRespostaCerteza());
        dados.put(RespostasDataModel.getLambda(),respostas.getRespostaIncerteza());
        dados.put(RespostasDataModel.getGrupo(),respostas.getGrupos());
        dados.put(RespostasDataModel.getPeriodo(),respostas.getPeriodo());
        dados.put(RespostasDataModel.getIdPergunta(),respostas.getIdPergunta());


        sucesso = insert(RespostasDataModel.getTABELA(),dados);

        return sucesso;
    }

    //TODO: Remover método deletar caso não necessário
    public boolean deletar(Respostas respostas){
        boolean sucesso = true;

        sucesso = deletar(RespostasDataModel.getTABELA(), respostas.getId());

        return sucesso;
    }

    //TODO: Remover método alterar caso não necessário
    public boolean alterar(Respostas respostas){
        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(RespostasDataModel.getId(),respostas.getId());
        dados.put(RespostasDataModel.getDataResposta(),respostas.getDataResposta());
        dados.put(RespostasDataModel.getMi(),respostas.getRespostaCerteza());
        dados.put(RespostasDataModel.getLambda(),respostas.getRespostaIncerteza());
        dados.put(RespostasDataModel.getPeriodo(),respostas.getPeriodo());
        dados.put(RespostasDataModel.getGrupo(),respostas.getGrupos());
        dados.put(RespostasDataModel.getIdPergunta(),respostas.getIdPergunta());

        sucesso = alterar(PerguntasDataModel.getTABELA(),dados);

        return sucesso;
    }

}