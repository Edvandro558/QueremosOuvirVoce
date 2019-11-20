package parasolution.queremosouvirvoce.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.controller.PerguntasController;
import parasolution.queremosouvirvoce.controller.UsuarioController;
import parasolution.queremosouvirvoce.model.Perguntas;
import parasolution.queremosouvirvoce.model.Respostas;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        apresentarTelaSplash();
    }

    private void apresentarTelaSplash(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                UsuarioController usuarioController = new UsuarioController(getBaseContext());
                List<Respostas> teste = usuarioController.maximizacao();
                for (Respostas tst:teste) {
                    Log.d("MAXIMIZACAO", "MI: "+ tst.getRespostaCerteza() + " - Lambda: " + tst.getRespostaIncerteza() + " - idPergunta: " + tst.getIdPergunta());
                }

                List<Respostas> teste2 = usuarioController.minimizacao();
                for (Respostas tst:teste2) {
                    Log.d("MINIMIZACAO", "MI: "+ tst.getRespostaCerteza() + " - Lambda: " + tst.getRespostaIncerteza() + " - idPergunta: " + tst.getIdPergunta());
                }

                List<Float> teste3 = usuarioController.grauCertezaGeral();
                for (float grau : teste3) {
                    Log.d("GRAU ","GRAU DE CERTEZA: " + grau );
                }

                List<Float> teste4 = usuarioController.grauContradicaoGeral();
                for (float grau : teste4) {
                    Log.d("GRAU ","GRAU DE CONTRADICAO: " + grau );
                }


                PerguntasController perguntasController = new PerguntasController(getBaseContext());
                 List<Perguntas> objetos = perguntasController.listar();
                 for (Perguntas obj:objetos) {
                   Log.i("CRUD GETALL", "ID: "+obj.getId()+" - Categoria: "+obj.getCategoria()+" - Pergunta Certeza: "+obj.getPerguntaCerteza()+" - Pergunta Incerteza: "+obj.getPerguntaIncerteza()) ;
                }

                Intent telaPrincial
                        = new Intent(SplashActivity.this,
                        MainActivity.class);
                startActivity(telaPrincial);

                finish();
            }
        },SPLASH_TIME_OUT);

    }

}
