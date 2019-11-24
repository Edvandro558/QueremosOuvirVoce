package parasolution.queremosouvirvoce.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import parasolution.queremosouvirvoce.R;

public class FinalActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        apresentarTelaFinal();

    }

    private void apresentarTelaFinal(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent telaPrincial
                        = new Intent(FinalActivity.this,
                        MainActivity.class);
                startActivity(telaPrincial);

                finish();
            }
        },SPLASH_TIME_OUT);

    }

}
