package parasolution.queremosouvirvoce.controller;

import android.content.ContentValues;
import android.content.Context;

import java.text.DecimalFormat;
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

    //-----  MÉTODOS DE MAXIMIZAÇÃO ------
    public List<Respostas> maximizacao() {
        return getMaximizacao();
    }

    public List<Respostas> maximizacaoSemanal() {
        return getMaximizacaoSemanal();
    }

    public List<Respostas> maximizacaoMensal() {
        return getMaximizacaoMensal();
    }

    public List<Respostas> maximizacaoPeriodo(String periodo) {
        return getMaximizacaoPeriodo(periodo);
    }

    public List<Respostas> maximizacaoSemanalPeriodo(String periodo) {
        return getMaximizacaoSemanalPeriodo(periodo);
    }

    public List<Respostas> maximizacaoMensalPeriodo(String periodo) {
        return getMaximizacaoMensalPeriodo(periodo);
    }
    //---------------------------------------------------------

    public List<Respostas> minimizacao(String tipoRelatorio, String periodo){
        List<Respostas> tipoMaximizacao = new ArrayList<>();
        switch (tipoRelatorio){
            case "geral":
                tipoMaximizacao = maximizacao();
                break;
            case "semanal":
                tipoMaximizacao = maximizacaoSemanal();
                break;
            case "mensal":
                tipoMaximizacao = maximizacaoMensal();
                break;
        }
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

        for (Respostas test : tipoMaximizacao) {
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
        if(!mi1.isEmpty()) {
            resposta1.setRespostaCerteza(Collections.min(mi1));
        }
        if(!mi2.isEmpty()) {
            resposta2.setRespostaCerteza(Collections.min(mi2));
        }
        if(!mi3.isEmpty()) {
            resposta3.setRespostaCerteza(Collections.min(mi3));
        }
        if(!mi4.isEmpty()) {
            resposta4.setRespostaCerteza(Collections.min(mi4));
        }
        if(!mi5.isEmpty()) {
            resposta5.setRespostaCerteza(Collections.min(mi5));
        }
        if(!mi6.isEmpty()) {
            resposta6.setRespostaCerteza(Collections.min(mi6));
        }
        if(!mi7.isEmpty()) {
            resposta7.setRespostaCerteza(Collections.min(mi7));
        }
        if(!mi8.isEmpty()) {
            resposta8.setRespostaCerteza(Collections.min(mi8));
        }
        if(!mi9.isEmpty()) {
            resposta9.setRespostaCerteza(Collections.min(mi9));
        }
        if(!lambda1.isEmpty()) {
        resposta1.setRespostaIncerteza(Collections.min(lambda1));
        }
        if(!lambda2.isEmpty()) {
        resposta2.setRespostaIncerteza(Collections.min(lambda2));
        }
        if(!lambda3.isEmpty()) {
        resposta3.setRespostaIncerteza(Collections.min(lambda3));
        }
        if(!lambda4.isEmpty()) {
        resposta4.setRespostaIncerteza(Collections.min(lambda4));
        }
        if(!lambda5.isEmpty()) {
        resposta5.setRespostaIncerteza(Collections.min(lambda5));
        }
        if(!lambda6.isEmpty()) {
        resposta6.setRespostaIncerteza(Collections.min(lambda6));
        }
        if(!lambda7.isEmpty()) {
        resposta7.setRespostaIncerteza(Collections.min(lambda7));
        }
        if(!lambda8.isEmpty()) {
        resposta8.setRespostaIncerteza(Collections.min(lambda8));
        }
        if(!lambda9.isEmpty()) {
            resposta9.setRespostaIncerteza(Collections.min(lambda9));
        }
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

 /*   public List<Float> grausCerteza(){
        List<Respostas> minimizacao = minimizacao();
        List<Float> grauCerteza = new ArrayList<>();

        for (Respostas respostas: minimizacao) {
            grauCerteza.add(respostas.getRespostaCerteza() - respostas.getRespostaIncerteza());
        }
        return grauCerteza;
    }

    public List<Float> grausContradicao(){
        List<Respostas> minimizacao = minimizacao();
        List<Float> grauContradicao = new ArrayList<>();

        for (Respostas respostas: minimizacao) {
            grauContradicao.add(respostas.getRespostaCerteza() + respostas.getRespostaIncerteza() - 1);
        }
        return grauContradicao;
    } */

    public float grauCerteza(float certeza, float contradicao){
        return (certeza - contradicao) *100;
    }

    public float grauContradicao(float certeza, float contradicao){
        return (certeza + contradicao - 1) *100;
    }

    public float certezaGeral(List<Respostas> minimizacao){
        List<Float> grauCerteza = new ArrayList<>();
        for (Respostas respostas: minimizacao) {
            grauCerteza.add(respostas.getRespostaCerteza() - respostas.getRespostaIncerteza());
        }

        float soma = 0f;
        for (float temp : grauCerteza) {
            soma =+ temp;
        }
        return (soma / grauCerteza.size()) *100;
    }

    public float contradicaoGeral(List<Respostas> minimizacao){
        List<Float>grauContradicao = new ArrayList<>();
        for (Respostas respostas: minimizacao) {
            grauContradicao.add(respostas.getRespostaCerteza() + respostas.getRespostaIncerteza() - 1);
        }
        float soma = 0f;
        for (float temp : grauContradicao) {
            soma += temp;
        }
        return (soma / grauContradicao.size()) *100;
    }

    public String situacao(float certezaGeral){
        String situcao = "";
        if (certezaGeral < -70){
            situcao = "Reprovado";
        }else if (certezaGeral > -70 && certezaGeral < 70){
            situcao = "Não conclusivo";
        }else if (certezaGeral > 70){
            situcao = "Aprovado";
        }
        return situcao;
    }

    public String formatarDecimal(float valor){
        DecimalFormat mformat = new DecimalFormat("###,###.00");
        return mformat.format(valor) + "%";
    }
}

