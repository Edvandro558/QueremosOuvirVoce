package parasolution.queremosouvirvoce.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import parasolution.queremosouvirvoce.R;


public class InicialFragment extends Fragment {

    View view;

    ToggleButton togglebtnEua;
    ToggleButton togglebtnBrasil;
    ToggleButton togglebtnEspanhol;
    Button btnIniciar;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    public InicialFragment() {
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

        view =  inflater.inflate(R.layout.fragment_inicial, container, false);

        btnIniciar = view.findViewById(R.id.btnInicial);
        fragmentManager = getFragmentManager();

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.exit_to_right, R.anim.enter_from_right);
                fragmentTransaction.replace(R.id.content_fragment, new CategoriasFragment()).commit();
            }
        });

       /* togglebtnEua = view.findViewById(R.id.togglebtnEua);
        togglebtnBrasil = view.findViewById(R.id.togglebtnBrasil);

        //codigo para o togglebutton
        // TODO Trocar o togglebutton para button normal
        togglebtnEua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((ToggleButton)v).isChecked())
                {
                    //chamando o proximo fragment
                    fragmentTransaction = getFragmentManager();
                    fragmentTransaction.beginTransaction().replace(R.id.content_fragment, new CategoriasFragment()).commit();
                    Toast.makeText(getContext(),"EUA", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(),"EUA", Toast.LENGTH_LONG).show();

                }
            }
        });

        togglebtnBrasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((ToggleButton)v).isChecked())
                {
                    //chamando o proximo fragment
                    fragmentTransaction = getFragmentManager();                                 // era CategoriasTesteBFragmen
                    fragmentTransaction.beginTransaction().replace(R.id.content_fragment, new CategoriasFragment()).commit();
                    Toast.makeText(getContext(),"Brasil", Toast.LENGTH_LONG).show();
                }
            }
        });

        //onEuaToggleClick(view);  */

        return view;
    }
   //outra maneira de fazer o togglebutton, nao está funcionando direito
   // public void onEuaToggleClick(View view) {
   //     Toast.makeText(getContext(),"Custom Toggle", Toast.LENGTH_LONG).show();
   // }
}
