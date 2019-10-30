package parasolution.queremosouvirvoce.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.adapter.PerguntasAdapter;
import parasolution.queremosouvirvoce.model.PerguntasModel;

public class PerguntasFragment extends Fragment implements View.OnClickListener {

    View view;
    ImageView btnVoltar;
    ImageView btnProximo;

    ArrayList<PerguntasModel> perguntasModelLista;
    private RecyclerView recyclerView;
    private PerguntasAdapter perguntasAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private int counter = 0;

    public PerguntasFragment() {
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

        view =  inflater.inflate(R.layout.fragment_perguntas, container, false);

        btnVoltar = view.findViewById(R.id.btnVoltar);
        btnProximo = view.findViewById(R.id.btnProximo);

        perguntasModelLista = new ArrayList<>();
        perguntasModelLista.add(new PerguntasModel("Pergunta Certeza1","Pergunta Incerteza1"));
        perguntasModelLista.add(new PerguntasModel("Pergunta Certeza2","Pergunta Incerteza2"));
        perguntasModelLista.add(new PerguntasModel("Pergunta Certeza3","Pergunta Incerteza3"));

        recyclerView = view.findViewById(R.id.rv_perguntas);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        perguntasAdapter = new PerguntasAdapter(perguntasModelLista);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(perguntasAdapter);
        perguntasAdapter.setOnItemClickListener(new PerguntasAdapter.OnItemClickListener() {
            @Override
            public void onEmote1Click(int position) {
                removeItem(position );
            }

            @Override
            public void onEmote2Click(int position) {
                removeItem(position );
            }

            @Override
            public void onEmote3Click(int position) {
                removeItem(position );
            }

            @Override
            public void onEmote4Click(int position) {
                removeItem(position );
            }

            @Override
            public void onEmote5Click(int position) {
                removeItem(position);
            }

            @Override
            public void onEmote6Click(int position) {
                removeItem(position);
            }

            @Override
            public void onEmote7Click(int position) {
                removeItem(position);
            }

            @Override
            public void onEmote8Click(int position) {
                removeItem(position);
            }

            @Override
            public void onEmote9Click(int position) {
                removeItem(position);
            }

            @Override
            public void onEmote10Click(int position) {
                removeItem(position);
            }
        });

       btnVoltar.setOnClickListener(this);
       btnProximo.setOnClickListener(this);

        return view;
    }


    public void removeItem(int position){
        perguntasModelLista.remove(position);
        perguntasAdapter.notifyItemRemoved(position);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnProximo:
                if(counter < perguntasAdapter.getItemCount()) {
                    plusCounter();

                }
                Toast.makeText(getContext(), "counter: "+counter, Toast.LENGTH_LONG).show();
                break;
            case R.id.btnVoltar:
                if(counter > 0) {
                    minusCounter();

                }
                Toast.makeText(getContext(), "counter: "+counter, Toast.LENGTH_LONG).show();
                break;
        }

    }

    private void plusCounter(){
        counter++;
        recyclerView.smoothScrollToPosition(counter);
    }

    private void minusCounter(){
        counter--;
        recyclerView.smoothScrollToPosition(counter);
    }
}
