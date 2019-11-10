package parasolution.queremosouvirvoce.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.controller.PerguntasController;

public class CategoriasFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Context context;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private boolean cafe, bebidas, happyhour, pratos, doces, salgados, boutique = false;
    private CardView cv_cafe, cv_bebidas, cv_happyhour, cv_pratos, cv_doces, cv_salgados, cv_voltar, cv_boutique,cv_iniciar;

    public CategoriasFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getContext();
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
        cv_boutique = view.findViewById(R.id.cv_boutique);
        cv_iniciar = view.findViewById(R.id.cv_iniciar);

        cv_cafe.setOnClickListener(this);
        cv_bebidas.setOnClickListener(this);
        cv_happyhour.setOnClickListener(this);
        cv_pratos.setOnClickListener(this);
        cv_doces.setOnClickListener(this);
        cv_salgados.setOnClickListener(this);
        cv_voltar.setOnClickListener(this);
        cv_boutique.setOnClickListener(this);
        cv_iniciar.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cv_cafe:
                if(cv_cafe.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_cafe.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    cafe = true;
                }
                else {
                    cv_cafe.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    cafe = false;
                }
                break;
            case R.id.cv_bebidas:
                if(cv_bebidas.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_bebidas.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    bebidas = true;
                }
                else {
                    cv_bebidas.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    bebidas = false;
                }
                break;
            case R.id.cv_happyhour:
                if(cv_happyhour.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_happyhour.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    happyhour = true;
                }
                else {
                    cv_happyhour.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    happyhour = false;
                }
                break;
            case R.id.cv_pratos:
                if(cv_pratos.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_pratos.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    pratos = true;
                }
                else {
                    cv_pratos.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    pratos = false;
                }
                break;
            case R.id.cv_doces:
                if(cv_doces.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_doces.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    doces = true;
                }
                else {
                    cv_doces.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    doces = false;
                }
                break;
            case R.id.cv_salgados:
                if(cv_salgados.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_salgados.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    salgados = true;
                }
                else {
                    cv_salgados.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    salgados = false;
                }
                break;
            case R.id.cv_voltar:
                if(cv_voltar.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_voltar.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_fragment, new InicialFragment()).commit();
                }
                break;
            case R.id.cv_boutique:
                if(cv_boutique.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_boutique.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    boutique = true;
                }
                else {
                    cv_boutique.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    boutique = false;
                }
                break;
            case R.id.cv_iniciar:
                if(cv_iniciar.getCardBackgroundColor().getDefaultColor() == -1) {
                    cv_iniciar.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    adcionarLista();

                    PerguntasController perguntasController = new PerguntasController(context);
                    Bundle bundle = new Bundle();
                    bundle.putString("Categorias", perguntasController.gerarString(adcionarLista()));
                    PerguntasFragment perguntasFragment = new PerguntasFragment();
                    perguntasFragment.setArguments(bundle);
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content_fragment, perguntasFragment).commit();

                    }else {
                        cv_iniciar.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(getContext(),"Selecione a(s) categoria(s)! ",Toast.LENGTH_LONG).show();
                    }


                break;
        }
    }

    private List<String> adcionarLista() {

        List<String> categorias = new ArrayList<>();
        if (cafe) {
            categorias.add("cafe");
        }
        if (bebidas) {
            categorias.add("bebidas");
        }
        if (happyhour) {
            categorias.add("happyhour");
        }
        if (pratos) {
            categorias.add("pratos");
        }
        if (doces) {
            categorias.add("doces");
        }
        if (salgados) {
            categorias.add("salgados");
        }
        if (boutique) {
            categorias.add("boutique");
        }
        return categorias;
    }

}
