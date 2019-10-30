package parasolution.queremosouvirvoce.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.model.Categorias;

public class CategoriasFragment extends Fragment implements View.OnClickListener {

    View view;

    FragmentManager fragmentTransaction;

    private Categorias obj;

    private CardView cv_cafe, cv_bebidas, cv_happyhour, cv_pratos, cv_doces, cv_salgados, cv_voltar, cv_metodos,cv_iniciar;


    public CategoriasFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //metodo que monta a view (fragmento)
    //utilizando neste caso uma variavel global para q a view esteja visivel para toda esta classe
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_categorias, container, false);

        cv_cafe = view.findViewById(R.id.cv_cafe);
        cv_bebidas = view.findViewById(R.id.cv_bebidas);
        cv_happyhour = view.findViewById(R.id.cv_happyhour);
        cv_pratos = view.findViewById(R.id.cv_pratos);
        cv_doces = view.findViewById(R.id.cv_doces);
        cv_salgados = view.findViewById(R.id.cv_salgados);
        cv_voltar = view.findViewById(R.id.cv_voltar);
        cv_metodos = view.findViewById(R.id.cv_metodos);
        cv_iniciar = view.findViewById(R.id.cv_iniciar);

        cv_cafe.setOnClickListener(this);
        cv_bebidas.setOnClickListener(this);
        cv_happyhour.setOnClickListener(this);
        cv_pratos.setOnClickListener(this);
        cv_doces.setOnClickListener(this);
        cv_salgados.setOnClickListener(this);
        cv_voltar.setOnClickListener(this);
        cv_metodos.setOnClickListener(this);
        cv_iniciar.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        obj = new Categorias();
        switch (v.getId()){
            case R.id.cv_cafe:
                if(cv_cafe.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_cafe.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    obj.setCafe("cafe");
                }
                else {
                    cv_cafe.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    obj.setCafe(null);
                }
                break;
            case R.id.cv_bebidas:
                if(cv_bebidas.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_bebidas.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    obj.setBebida("bebidas");
                }
                else {
                    cv_bebidas.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    obj.setBebida(null);
                }
                break;
            case R.id.cv_happyhour:
                if(cv_happyhour.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_happyhour.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    obj.setHappyhour("bebidas");
                }
                else {
                    cv_happyhour.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    obj.setHappyhour(null);
                }
                break;
            case R.id.cv_pratos:
                if(cv_pratos.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_pratos.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    obj.setPratos("pratos");
                }
                else {
                    cv_pratos.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    obj.setPratos(null);
                }
                break;
            case R.id.cv_doces:
                if(cv_doces.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_doces.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    obj.setDoces("doces");
                }
                else {
                    cv_doces.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    obj.setDoces(null);
                }
                break;
            case R.id.cv_salgados:
                if(cv_salgados.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_salgados.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    obj.setSalgados("salgados");
                }
                else {
                    cv_salgados.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    obj.setSalgados(null);
                }
                break;
            case R.id.cv_voltar:
                if(cv_voltar.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_voltar.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    fragmentTransaction = getFragmentManager();
                    fragmentTransaction.beginTransaction().replace(R.id.content_fragment, new InicialFragment()).commit();
                }
                break;
            case R.id.cv_metodos:
                if(cv_metodos.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_metodos.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    obj.setMetodos("metodos");
                }
                else {
                    cv_metodos.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    obj.setMetodos(null);
                }
                break;
            case R.id.cv_iniciar:
                if(cv_iniciar.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_iniciar.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    fragmentTransaction = getFragmentManager();
                    fragmentTransaction.beginTransaction().replace(R.id.content_fragment, new PerguntasFragment()).commit();
                }
                break;
        }
    }
}
