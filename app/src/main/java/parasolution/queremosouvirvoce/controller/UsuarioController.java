package parasolution.queremosouvirvoce.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import parasolution.queremosouvirvoce.datamodel.UsuarioDataModel;
import parasolution.queremosouvirvoce.datasource.DataSource;
import parasolution.queremosouvirvoce.model.Respostas;
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

    public List<Respostas> maximizacao() {
        return getMaximizacao();
    }

    public List<Respostas> minimizacao(){
      List<Respostas> teste = maximizacao();
      List<Respostas> minimizacao = new ArrayList<>();
        List<Float> mi1 = new ArrayList<>();
        List<Float> mi2 = new ArrayList<>();
        List<Float> mi3 = new ArrayList<>();
        List<Float> mi4 = new ArrayList<>();
        List<Float> mi5 = new ArrayList<>();
        List<Float> mi6 = new ArrayList<>();
        List<Float> mi7 = new ArrayList<>();
        List<Float> mi8 = new ArrayList<>();
        List<Float> mi9 = new ArrayList<>();
        List<Float> lambda1 = new ArrayList<>();
        List<Float> lambda2 = new ArrayList<>();
        List<Float> lambda3 = new ArrayList<>();
        List<Float> lambda4 = new ArrayList<>();
        List<Float> lambda5 = new ArrayList<>();
        List<Float> lambda6 = new ArrayList<>();
        List<Float> lambda7 = new ArrayList<>();
        List<Float> lambda8 = new ArrayList<>();
        List<Float> lambda9 = new ArrayList<>();
        Respostas resposta1 = new Respostas();
        Respostas resposta2 = new Respostas();
        Respostas resposta3 = new Respostas();
        Respostas resposta4 = new Respostas();
        Respostas resposta5 = new Respostas();
        Respostas resposta6 = new Respostas();
        Respostas resposta7 = new Respostas();
        Respostas resposta8 = new Respostas();
        Respostas resposta9 = new Respostas();

        for (Respostas test : teste) {
          if(test.getIdPergunta() == 1){
              mi1.add(test.getRespostaCerteza());
              lambda1.add(test.getRespostaIncerteza());
              resposta1.setIdPergunta(test.getIdPergunta());
          } else if(test.getIdPergunta() == 2){
              mi2.add(test.getRespostaCerteza());
              lambda2.add(test.getRespostaIncerteza());
              resposta2.setIdPergunta(test.getIdPergunta());
          } else if(test.getIdPergunta() == 3){
              mi3.add(test.getRespostaCerteza());
              lambda3.add(test.getRespostaIncerteza());
              resposta3.setIdPergunta(test.getIdPergunta());
          } else if(test.getIdPergunta() == 4) {
              mi4.add(test.getRespostaCerteza());
              lambda4.add(test.getRespostaIncerteza());
              resposta4.setIdPergunta(test.getIdPergunta());
          } else if(test.getIdPergunta() == 5) {
              mi5.add(test.getRespostaCerteza());
              lambda5.add(test.getRespostaIncerteza());
              resposta5.setIdPergunta(test.getIdPergunta());
          } else if(test.getIdPergunta() == 6) {
              mi6.add(test.getRespostaCerteza());
              lambda6.add(test.getRespostaIncerteza());
              resposta6.setIdPergunta(test.getIdPergunta());
          } else if(test.getIdPergunta() == 7) {
              mi7.add(test.getRespostaCerteza());
              lambda7.add(test.getRespostaIncerteza());
              resposta7.setIdPergunta(test.getIdPergunta());
          } else if(test.getIdPergunta() == 8) {
              mi8.add(test.getRespostaCerteza());
              lambda8.add(test.getRespostaIncerteza());
              resposta8.setIdPergunta(test.getIdPergunta());
          } else if(test.getIdPergunta() == 9) {
              mi9.add(test.getRespostaCerteza());
              lambda9.add(test.getRespostaIncerteza());
              resposta9.setIdPergunta(test.getIdPergunta());
          }
          }
        resposta1.setRespostaCerteza(Collections.min(mi1));
        resposta2.setRespostaCerteza(Collections.min(mi2));
        resposta3.setRespostaCerteza(Collections.min(mi3));
        resposta4.setRespostaCerteza(Collections.min(mi4));
        resposta5.setRespostaCerteza(Collections.min(mi5));
        resposta6.setRespostaCerteza(Collections.min(mi6));
        resposta7.setRespostaCerteza(Collections.min(mi7));
        resposta8.setRespostaCerteza(Collections.min(mi8));
        resposta9.setRespostaCerteza(Collections.min(mi9));
        resposta1.setRespostaIncerteza(Collections.min(lambda1));
        resposta2.setRespostaIncerteza(Collections.min(lambda2));
        resposta3.setRespostaIncerteza(Collections.min(lambda3));
        resposta4.setRespostaIncerteza(Collections.min(lambda4));
        resposta5.setRespostaIncerteza(Collections.min(lambda5));
        resposta6.setRespostaIncerteza(Collections.min(lambda6));
        resposta7.setRespostaIncerteza(Collections.min(lambda7));
        resposta8.setRespostaIncerteza(Collections.min(lambda8));
        resposta9.setRespostaIncerteza(Collections.min(lambda9));
        minimizacao.add(resposta1);
        minimizacao.add(resposta2);
        minimizacao.add(resposta3);
        minimizacao.add(resposta4);
        minimizacao.add(resposta5);
        minimizacao.add(resposta6);
        minimizacao.add(resposta7);
        minimizacao.add(resposta8);
        minimizacao.add(resposta9);
        return minimizacao;
    }

    public List<Float> grauCertezaGeral(){
        List<Respostas> minimizacao = minimizacao();
        List<Float> grauCerteza = new ArrayList<>();

        for (Respostas respostas: minimizacao) {
            grauCerteza.add(respostas.getRespostaCerteza() - respostas.getRespostaIncerteza());
        }
        return grauCerteza;
    }

    public List<Float> grauContradicaoGeral(){
        List<Respostas> minimizacao = minimizacao();
        List<Float> grauContradicao = new ArrayList<>();

        for (Respostas respostas: minimizacao) {
            grauContradicao.add(respostas.getRespostaCerteza() + respostas.getRespostaIncerteza() - 1);
        }
        return grauContradicao;
    }

    public float grauCerteza(float certeza, float contradicao){
        return certeza - contradicao;
    }

    public float grauContradicao(float certeza, float contradicao){
        return certeza + contradicao - 1;
    }

}

