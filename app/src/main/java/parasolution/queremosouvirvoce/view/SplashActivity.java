package parasolution.queremosouvirvoce.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.controller.PerguntasController;
import parasolution.queremosouvirvoce.model.Perguntas;

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

               PerguntasController perguntasController = new PerguntasController((getBaseContext()));
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
