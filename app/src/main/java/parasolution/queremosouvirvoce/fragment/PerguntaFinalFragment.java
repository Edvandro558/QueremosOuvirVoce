package parasolution.queremosouvirvoce.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.controller.RespostasController;
import parasolution.queremosouvirvoce.model.Respostas;
import parasolution.queremosouvirvoce.view.FinalActivity;

public class PerguntaFinalFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Intent intent;
    private FragmentManager fragmentTransaction;
    private RadioButton rbZero,rbUm, rbDois, rbTres, rbQuatro, rbCinco, rbSeis, rbSete, rbOito, rbNove, rbDez;
    private Button btnSim, btnNao, btnCadastrado;
    private ImageView btnVoltar2, btnFim;
    private Respostas respostas;
    private ArrayList<Integer> idPerguntas;
    private ArrayList<String> respostasCerteza;
    private ArrayList<String> respostasIncerteza;

    public PerguntaFinalFragment() {
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

        view = inflater.inflate(R.layout.fragment_pergunta_final, container, false);

        btnSim = view.findViewById(R.id.btnSim);
        btnNao = view.findViewById(R.id.btnNao);
        btnCadastrado = view.findViewById(R.id.btnCadastrado);
       // btnVoltar2 = view.findViewById(R.id.btnVoltar2);
        //btnFim = view.findViewById(R.id.btnFim);
        rbZero = view.findViewById(R.id.rbZero);
        rbUm = view.findViewById(R.id.rbUm);
        rbDois = view.findViewById(R.id.rbDois);
        rbTres = view.findViewById(R.id.rbTres);
        rbQuatro = view.findViewById(R.id.rbQuatro);
        rbCinco = view.findViewById(R.id.rbCinco);
        rbSeis = view.findViewById(R.id.rbSeis);
        rbSete = view.findViewById(R.id.rbSete);
        rbOito = view.findViewById(R.id.rbOito);
        rbNove = view.findViewById(R.id.rbNove);
        rbDez = view.findViewById(R.id.rbDez);

        btnSim.setOnClickListener(this);
        btnCadastrado.setOnClickListener(this);
        btnNao.setOnClickListener(this);
       // btnVoltar2.setOnClickListener(this);
        //btnFim.setOnClickListener(this);
        rbZero.setOnClickListener(this);
        rbUm.setOnClickListener(this);
        rbDois.setOnClickListener(this);
        rbTres.setOnClickListener(this);
        rbQuatro.setOnClickListener(this);
        rbCinco.setOnClickListener(this);
        rbSeis.setOnClickListener(this);
        rbSete.setOnClickListener(this);
        rbOito.setOnClickListener(this);
        rbNove.setOnClickListener(this);
        rbDez.setOnClickListener(this);

        respostas = new Respostas();
        idPerguntas = new ArrayList<>();
        try {
            Bundle bundle = getArguments();
            idPerguntas = bundle.getIntegerArrayList("IdPerguntas");
            respostasCerteza = bundle.getStringArrayList("Respostas Certeza");
            respostasIncerteza = bundle.getStringArrayList("Respostas Incerteza");
        }catch (NullPointerException ignored){}

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh");
        respostas.setDataResposta(simpleDateFormat.format(calendar.getTime()));
        int horaAtual = Integer.parseInt(simpleTimeFormat.format(calendar.getTime()));
        if(horaAtual <= 12){
            respostas.setPeriodo("Matutino");
        }else{
            respostas.setPeriodo("Vespertino");
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCadastrado:
                if(checarRb()) {

                    contruirObjetos();

                    intent = new Intent(getActivity(), FinalActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(),"Escolha Uma Alternativa!", Toast.LENGTH_SHORT).show();
                }
                break;
         //   case R.id.btnVoltar2:
           //     fragmentTransaction = getFragmentManager();
            //    fragmentTransaction.beginTransaction().replace(R.id.content_fragment, new CategoriasFragment()).commit();
            //    break;
            case R.id.btnSim:
                if(checarRb()) {

                    contruirObjetos();

                    fragmentTransaction = getFragmentManager();
                    fragmentTransaction.beginTransaction().replace(R.id.content_fragment, new CadastroClienteFragment()).commit();
                }else {
                    Toast.makeText(getContext(),"Escolha Uma Alternativa!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnNao:
                if(checarRb()) {

                    contruirObjetos();

                    intent = new Intent(getActivity(), FinalActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(),"Escolha Uma Alternativa!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.rbZero:
                respostas.setGrupos("Grupo 1");
                break;
            case R.id.rbUm:
                respostas.setGrupos("Grupo 1");
                break;
            case R.id.rbDois:
                respostas.setGrupos("Grupo 1");
                break;
            case R.id.rbTres:
                respostas.setGrupos("Grupo 1");
                break;
            case R.id.rbQuatro:
                respostas.setGrupos("Grupo 1");
                break;
            case R.id.rbCinco:
                respostas.setGrupos("Grupo 1");
                break;
            case R.id.rbSeis:
                respostas.setGrupos("Grupo 1");
                break;
            case R.id.rbSete:
                respostas.setGrupos("Grupo 2");
                break;
            case R.id.rbOito:
                respostas.setGrupos("Grupo 2");
                break;
            case R.id.rbNove:
                respostas.setGrupos("Grupo 3");
                break;
            case R.id.rbDez:
                respostas.setGrupos("Grupo 3");
                break;
        }
    }

    private void contruirObjetos(){
        for (int i = 0; i < idPerguntas.size(); i++) {
            respostas.setIdPergunta(idPerguntas.get(i));
            respostas.setRespostaCerteza(Double.parseDouble(respostasCerteza.get(i)));
            respostas.setRespostaIncerteza(Double.parseDouble(respostasIncerteza.get(i)));
            RespostasController respostasController = new RespostasController(getContext());
            respostasController.salvar(respostas);
        }

    }

    private boolean checarRb(){
        boolean sucesso = false;
        if(rbZero.isChecked()||rbUm.isChecked()||rbDois.isChecked()||rbTres.isChecked()||rbQuatro.isChecked()||rbCinco.isChecked()||rbSeis.isChecked()||
                rbSete.isChecked()||rbOito.isChecked()||rbNove.isChecked()||rbDez.isChecked()) {
            sucesso = true;
        }

        return sucesso;
    }

}
