package parasolution.queremosouvirvoce.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import parasolution.queremosouvirvoce.R;

public class AdministradorFragment extends Fragment implements View.OnClickListener {

    View view;
    FragmentManager fragmentManager;

    Button btnRelatorios;

    public AdministradorFragment() {
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

        view =  inflater.inflate(R.layout.fragment_adminstrador, container, false);

        btnRelatorios = view.findViewById(R.id.btnRelatorios);

        fragmentManager = getChildFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.admin_content_fragment, new RelatorioFragment()).commit();

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (getId()){
            case R.id.btnRelatorios:
                fragmentManager.beginTransaction().replace(R.id.admin_content_fragment, new RelatorioFragment()).commit();

                break;
        }
    }
}
