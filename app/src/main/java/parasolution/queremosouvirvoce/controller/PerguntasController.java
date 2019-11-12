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

    //MÉTODOS DB

    public void popularTabelaPerguntas(){
        Perguntas perguntas1 = new Perguntas("atendimento","O que você achou do nosso atendimento?",
                "Você acha que nosso atendimento poderia melhorar?");
        salvar(perguntas1);

        Perguntas perguntas2 = new Perguntas("ambiente","Você achou nosso ambiente agradável?",
                "Você acha que poderiamos melhorar nosso ambiente?");
        salvar(perguntas2);

        Perguntas perguntas3 = new Perguntas("cafe","Você ficou satistfeito(a) com nosso café?",
                "O nosso café poderia melhorar?");
        salvar(perguntas3);

        Perguntas perguntas4 = new Perguntas("bebidas","O que achou de nossas bebidas?",
                "Você acha que nossas bebidas poderiam ser melhores?");
        salvar(perguntas4);

        Perguntas perguntas5 = new Perguntas("happyhour","Você gostou dos nossos drinks?",
                "Você acha que nossos drinks poderiam ser melhores?");
        salvar(perguntas5);

        Perguntas perguntas6 = new Perguntas("pratos","Você ficou satisfeito(a) em relação aos nossos pratos",
                "Você acha que nossos pratos poderiam ser melhores?");
        salvar(perguntas6);

        Perguntas perguntas7 = new Perguntas("doces","Você ficou satisfeito(a) com a qualidade dos nossos doces?",
                "Nossos doces poderiam ser melhores de alguma maneira?");
        salvar(perguntas7);

        Perguntas perguntas8 = new Perguntas("salgados","O que achou dos nossos salgados?",
                "Você acha que nossos salgados poderiam ser melhorados?");
        salvar(perguntas8);

        Perguntas perguntas9 = new Perguntas("boutique","O que achou da qualidade dos produtos da Boutique?",
                "Os produtos da Boutique poderiam ser melhores?");
        salvar(perguntas9);
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
