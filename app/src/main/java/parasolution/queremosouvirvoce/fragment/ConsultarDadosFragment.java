package parasolution.queremosouvirvoce.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.adapter.ConsultarDadosListAdapter;
import parasolution.queremosouvirvoce.controller.ClienteController;
import parasolution.queremosouvirvoce.model.Cliente;

public class ConsultarDadosFragment extends Fragment {

    View view;
    ArrayList<Cliente> dataset;
    ListView listView;
    ClienteController clienteController;

    public ConsultarDadosFragment() {
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

        view =  inflater.inflate(R.layout.fragment_consultar_dados, container, false);

        clienteController = new ClienteController(getContext());

        listView = view.findViewById(R.id.listview);

        dataset = clienteController.getAllClientes();

        ConsultarDadosListAdapter adapter = new ConsultarDadosListAdapter(dataset, getContext());

        listView.setAdapter(adapter);



        return view;
    }

}
