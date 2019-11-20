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

    Button btnRelatorios, btnCadastrarGerente, btnConsultarDados, btnSair;

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
        btnCadastrarGerente = view.findViewById(R.id.btn_Cadastrar_Gerente);
        btnConsultarDados = view.findViewById(R.id.btn_Dados_Clientes);
        btnSair = view.findViewById(R.id.btn_Sair);

        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.admin_content_fragment, new RelatorioFragment()).commit();

        btnRelatorios.setOnClickListener(this);
        btnCadastrarGerente.setOnClickListener(this);
        btnConsultarDados.setOnClickListener(this);
        btnSair.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRelatorios:
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.admin_content_fragment, new RelatorioFragment()).commit();
                break;
            case R.id.btn_Cadastrar_Gerente:
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.admin_content_fragment, new CadastroGerenteFragment()).commit();
                break;
            case R.id.btn_Dados_Clientes:
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.admin_content_fragment, new ConsultarDadosFragment()).commit();
                break;
            case R.id.btn_Sair:
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_fragment, new InicialFragment()).commit();
                break;
        }
    }
}
