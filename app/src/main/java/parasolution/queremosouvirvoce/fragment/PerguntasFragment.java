package parasolution.queremosouvirvoce.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.adapter.PerguntasAdapter;
import parasolution.queremosouvirvoce.controller.PerguntasController;
import parasolution.queremosouvirvoce.model.Perguntas;

public class PerguntasFragment extends Fragment implements View.OnClickListener {

    View view;
    ArrayList<Perguntas> dataset;
    private Context context;
    private RecyclerView recyclerView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private ArrayList<String> respostaCerteza;
    private ArrayList<String> respostaIncerteza;
    private int posicaoObjetoCerteza = -1;
    private int posicaoObjetoIncerteza = -1;
    private String valorRespostaCerteza;
    private String valorRespostaIncerteza;
    private PerguntasAdapter perguntasAdapter;
    private int contador = 0;
    private String categoria;
    private ArrayList<Integer> idPerguntas;

    public PerguntasFragment() {
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

        view = inflater.inflate(R.layout.fragment_perguntas, container, false);

        ImageView btnVoltar = view.findViewById(R.id.btnVoltar);
        ImageView btnProximo = view.findViewById(R.id.btnProximo);
        recyclerView = view.findViewById(R.id.rv_perguntas);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        /**
         * aqui está sendo recebida a mensagem passada pela classe CategoriasFragment
         * está dentro do bloco try\catch para caso a String esteja vazia.
         */
        try {
            Bundle bundle = getArguments();
            categoria = bundle.getString("Categorias");
        }catch (NullPointerException ignored){}

        /**
         * aqui é onde os método que geram as perguntas são invocados. Primeiro a String contendo as categorias
         * é passada pra Model, e depois o método da controller que chama a busca no banco é invocado e recebe String de categorias
         * também é invocado um método da controller que pega o id das perguntas que será utilizado para salvar as respostas no DB
         * após isso o objeto da classe adapter recebe o dataset para injetar as perguntas no layout
         * e por último container recycler view recebe o adpter.
         * @see PerguntasAdapter
         * @see PerguntasController
         */
        Perguntas perguntas = new Perguntas();
        perguntas.setCategoria(categoria);
        PerguntasController perguntasController = new PerguntasController(context);
        dataset = new ArrayList<>();
        dataset = perguntasController.getPerguntas(perguntas.getCategoria());
        idPerguntas = new ArrayList<>();
        idPerguntas = perguntasController.listarIdPerguntas(dataset);
        perguntasAdapter = new PerguntasAdapter(dataset);
        recyclerView.setAdapter(perguntasAdapter);

        respostaCerteza = new ArrayList<>();
        respostaIncerteza = new ArrayList<>();

        /**
         * aqui está instaciado o listener da classe adapter para pegar o click nos ícones.
         */
        perguntasAdapter.setOnItemClickListener(new PerguntasAdapter.OnItemClickListener() {
            @Override
            public void onEmote1Click(int position) {
                posicaoObjetoCerteza = position;
                valorRespostaCerteza = "0.0";
            }

            @Override
            public void onEmote2Click(int position) {
                posicaoObjetoCerteza = position;
                valorRespostaCerteza = "0.25";
            }

            @Override
            public void onEmote3Click(int position) {
                posicaoObjetoCerteza = position;
                valorRespostaCerteza = "0.5";
            }

            @Override
            public void onEmote4Click(int position) {
                posicaoObjetoCerteza = position;
                valorRespostaCerteza = "0.75";
            }

            @Override
            public void onEmote5Click(int position) {
                posicaoObjetoCerteza = position;
                valorRespostaCerteza = "1.0";
            }

            @Override
            public void onEmote6Click(int position) {
                posicaoObjetoIncerteza = position;
                valorRespostaIncerteza = "0.0";
            }

            @Override
            public void onEmote7Click(int position) {
                posicaoObjetoIncerteza = position;
                valorRespostaIncerteza = "0.25";
            }

            @Override
            public void onEmote8Click(int position) {
                posicaoObjetoIncerteza = position;
                valorRespostaIncerteza = "0.5";
            }

            @Override
            public void onEmote9Click(int position) {
                posicaoObjetoIncerteza = position;
                valorRespostaIncerteza = "0.75";
            }

            @Override
            public void onEmote10Click(int position) {
                posicaoObjetoIncerteza = position;
                valorRespostaIncerteza = "1.0";
            }

        });

        btnVoltar.setOnClickListener(this);
        btnProximo.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnProximo:
                if (contador == posicaoObjetoCerteza && contador == posicaoObjetoIncerteza) {
                    proximoObjeto();
                    adcionarLista();
                    Log.d("teste", "contador: " + contador);
                } else {
                    Toast.makeText(getContext(), "Escolha uma alternativa!", Toast.LENGTH_SHORT).show();
                }
                if (contador == perguntasAdapter.getItemCount()) {

                    Bundle bundle = new Bundle();
                    bundle.putIntegerArrayList("IdPerguntas", idPerguntas);
                    bundle.putStringArrayList("Respostas Certeza", respostaCerteza);
                    bundle.putStringArrayList("Respostas Incerteza", respostaIncerteza);
                    PerguntaFinalFragment perguntaFinalFragment = new PerguntaFinalFragment();
                    perguntaFinalFragment.setArguments(bundle);
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.exit_to_right, R.anim.enter_from_right);
                    fragmentTransaction.replace(R.id.content_fragment, perguntaFinalFragment).commit();
                }
                break;
            case R.id.btnVoltar:
                if (contador == 0) {
                    fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_fragment, new CategoriasFragment()).commit();
                } else if (contador <= perguntasAdapter.getItemCount()) {
                    objetoAnterior();
                    if (contador == posicaoObjetoCerteza) {
                        removerLista();
                        posicaoObjetoIncerteza--;
                        posicaoObjetoCerteza--;
                    }
                }
                break;
        }

    }

    /**
     * método para fazer o Scroll para o próximo objeto do recyclerView
     */
    private void proximoObjeto() {
        contador++;
        recyclerView.smoothScrollToPosition(contador);
    }

    /**
     * método para fazer o Scroll para o objeto anterior do recyclerView
     */
    private void objetoAnterior() {
        contador--;
        recyclerView.smoothScrollToPosition(contador);
    }

    /**
     * método para adcionar as respostas a lista de repostas
     */
    private void adcionarLista() {
        respostaCerteza.add(valorRespostaCerteza);
        respostaIncerteza.add(valorRespostaIncerteza);
        Log.d("Teste", "Teste Seleção Certeza: " + respostaCerteza + " Teste Seleção Incerteza: " + respostaIncerteza);
    }

    /**
     * método para remover a ultima resposta da lista de repostas
     * usando como referência o tamanho da lista
     */
    private void removerLista() {
        int ultimaPosicao = respostaCerteza.size();
        respostaCerteza.remove(ultimaPosicao - 1);
        respostaIncerteza.remove(ultimaPosicao - 1);
        Log.d("Teste", "Teste Seleção Certeza: " + respostaCerteza + " Teste Seleção Incerteza: " + respostaIncerteza);
    }
}
