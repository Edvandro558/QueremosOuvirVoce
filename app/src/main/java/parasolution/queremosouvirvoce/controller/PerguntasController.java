package parasolution.queremosouvirvoce.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import parasolution.queremosouvirvoce.datamodel.PerguntasDataModel;
import parasolution.queremosouvirvoce.datasource.DataSource;
import parasolution.queremosouvirvoce.model.Perguntas;

public class PerguntasController extends DataSource {

    ContentValues dados;

    public PerguntasController(Context context) {
        super(context);
    }

    public ArrayList<Perguntas> getPerguntas(String categoria){
        return getPerguntasLista(categoria);
    }

    //TODO: Remover método listar caso não necessário
    public List<Perguntas> listar(){
        return getAllPerguntas();
    }

    //TODO: Remover método salvar caso não necessário
    /**
     * Método que recebe um objeto Perguntas e prepara para enviar para o DataSource e salvar no
     * banco de dados.
     *
     * @param perguntas é um Objeto Perguntas.
     * @return verdadeiro se salvou com sucesso, falso em caso de erro.
     */
    public boolean salvar(Perguntas perguntas){
        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(PerguntasDataModel.getCategoria(),perguntas.getCategoria());
        dados.put(PerguntasDataModel.getPerguntaCerteza(),perguntas.getPerguntaCerteza());
        dados.put(PerguntasDataModel.getPerguntaIncerteza(),perguntas.getPerguntaIncerteza());

        sucesso = insert(PerguntasDataModel.getTABELA(),dados);

        return sucesso;
    }

    //TODO: Remover método deletar caso não necessário
    public boolean deletar(Perguntas perguntas){
        boolean sucesso = true;

        sucesso = deletar(PerguntasDataModel.getTABELA(), perguntas.getId());

        return sucesso;
    }

    //TODO: Remover método alterar caso não necessário
    public boolean alterar(Perguntas perguntas){
        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(PerguntasDataModel.getId(),perguntas.getId());
        dados.put(PerguntasDataModel.getCategoria(),perguntas.getCategoria());
        dados.put(PerguntasDataModel.getPerguntaCerteza(),perguntas.getPerguntaCerteza());
        dados.put(PerguntasDataModel.getPerguntaIncerteza(),perguntas.getPerguntaIncerteza());

        sucesso = alterar(PerguntasDataModel.getTABELA(),dados);

        return sucesso;
    }

    //REGRA DE NEGÓCIOS
    public String gerarString(List<String> lista) {
        String stringGerada = "";
        Iterator<String> iterator = lista.iterator();
        int i = 1;
        while (iterator.hasNext()) {
            if (i == lista.size()) {
                stringGerada = "'" + stringGerada + iterator.next() + "',";
            } else {
                stringGerada = stringGerada + iterator.next() + "', '";
            }
            i++;
        }

        return stringGerada;
    }

    public ArrayList<Integer> listarIdPerguntas(ArrayList<Perguntas> dataset){
        ArrayList<Integer> idPerguntas = new ArrayList<>();
        for (Perguntas obj: dataset) {
            idPerguntas.add(obj.getId());
        }
        return idPerguntas;
    }
}
