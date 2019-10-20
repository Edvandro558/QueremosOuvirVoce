package parasolution.queremosouvirvoce.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import parasolution.queremosouvirvoce.R;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 4000;

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

                Intent telaPrincial
                        = new Intent(SplashActivity.this,
                        MainActivity.class);
                startActivity(telaPrincial);

                finish();
            }
        },SPLASH_TIME_OUT);

    }

}
