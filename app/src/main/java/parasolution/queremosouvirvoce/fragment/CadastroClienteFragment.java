package parasolution.queremosouvirvoce.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.controller.ClienteController;
import parasolution.queremosouvirvoce.model.Cliente;
import parasolution.queremosouvirvoce.view.FinalActivity;

public class CadastroClienteFragment extends Fragment implements View.OnClickListener {

    View view;
    Context context;
    Intent intent;
    EditText editNome, editEmail, editNascimento, editFone, editMensagem;
    RadioGroup radioGroupNotificacao;
    RadioButton rbSim, rbNao;
    Button btnEnviar, btnCancelar, btnLimpar;
    Cliente cliente;
    ClienteController clienteController;
    AlertDialog.Builder builder;
    AlertDialog alert;
    boolean dadosValidados = true;

    public CadastroClienteFragment() {
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

        view =  inflater.inflate(R.layout.fragment_cadastro_cliente, container, false);

        editNome = view.findViewById(R.id.editNome);
        editEmail = view.findViewById(R.id.editEmail);
        editNascimento = view.findViewById(R.id.editNascimento);
        editFone = view.findViewById(R.id.editFone);
        editMensagem = view.findViewById(R.id.editMensagem);
        radioGroupNotificacao = view.findViewById(R.id.radioGroupNotificacao);
        rbSim = view.findViewById(R.id.rbSim);
        rbNao = view.findViewById(R.id.rbNao);
        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnEnviar = view.findViewById(R.id.btnEnviar);
        btnLimpar = view.findViewById(R.id.btnLimpar);

        btnLimpar.setOnClickListener(this);
        btnEnviar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        cliente = new Cliente();
        clienteController = new ClienteController(context);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEnviar:
                if(checarCampos()) {
                    builder = new AlertDialog.Builder(context);
                    builder.setTitle("ALERTA");
                    builder.setMessage("Confirmar envio?");
                    builder.setCancelable(true);
                    builder.setIcon(R.drawable.logo);

                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            intent = new Intent(getActivity(), FinalActivity.class);
                            startActivity(intent);
                        }
                    });

                    builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    alert = builder.create();
                    alert.show();
                }
                break;

            case R.id.btnCancelar:
                builder = new AlertDialog.Builder(context);
                builder.setTitle("ALERTA");
                builder.setMessage("Deseja CANCELAR este cadastro?");
                builder.setCancelable(true);
                builder.setIcon(R.drawable.logo);

                builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(getActivity(), FinalActivity.class);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alert = builder.create();
                alert.show();
                break;

            case R.id.btnLimpar:
                builder = new AlertDialog.Builder(context);
                builder.setTitle("ALERTA");
                builder.setMessage("Deseja LIMPAR este cadastro?");
                builder.setCancelable(true);
                builder.setIcon(R.drawable.logo);

                builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editNome.setText("");
                        editEmail.setText("");
                        editNascimento.setText("");
                        editFone.setText("");
                        editMensagem.setText("");
                    }
                });

                builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alert = builder.create();
                alert.show();
                break;
        }
    }

    public boolean checarCampos(){
        boolean sucesso = false;
        try {
            if(editNome.getText().toString().length() > 0) {
                dadosValidados = true;
            }else{
                dadosValidados = false;
                editNome.setError("*");
                editNome.requestFocus();
                Toast.makeText(context, "Campo obrigatório...", Toast.LENGTH_SHORT).show();
            }

            if(editEmail.getText().toString().length() > 0){
                if(editEmail.getText().toString().contains("@")){
                    dadosValidados = true;
                }else{
                    dadosValidados = false;
                    editEmail.setError("*");
                    editEmail.requestFocus();
                    Toast.makeText(context, "Dados Incorretos...", Toast.LENGTH_SHORT).show();
                }
            }else {
                dadosValidados = false;
                editEmail.setError("*");
                editEmail.requestFocus();
                Toast.makeText(context, "Campo obrigatório...", Toast.LENGTH_SHORT).show();
            }

            if(editNascimento.getText().toString().length() > 0){
                if(editNascimento.getText().toString().length() < 10){
                    dadosValidados = false;
                    editNascimento.setError("*");
                    editNascimento.requestFocus();
                    Toast.makeText(context, "Dados Incorretos...", Toast.LENGTH_SHORT).show();
                }
            }else {
                dadosValidados = false;
                editNascimento.setError("*");
                editNascimento.requestFocus();
                Toast.makeText(context, "Campo obrigatório...", Toast.LENGTH_SHORT).show();
            }

            if(editFone.getText().toString().length() > 0 && editFone.getText().toString().length() < 15) {
                dadosValidados = false;
                editFone.setError("*");
                editFone.requestFocus();
                Toast.makeText(context, "Dados Incorretos...", Toast.LENGTH_SHORT).show();
            }

            if (rbSim.isChecked()){
                cliente.setNotificacao("Sim");
            }else{
                cliente.setNotificacao("Não");
            }

            if (dadosValidados){

                cliente.setNome(editNome.getText().toString());
                cliente.setEmail(editEmail.getText().toString());
                cliente.setNascimento(editNascimento.getText().toString());
                cliente.setTelefone(editFone.getText().toString());
                cliente.setMensagem(editMensagem.getText().toString());

                clienteController.salvar(cliente);
                Log.d("teste", "notificacao: "+cliente.getNotificacao());

                sucesso = true;
            }
        }catch (Exception e){
            Toast.makeText(context, "Informe os dados...", Toast.LENGTH_SHORT).show();
        }
        return sucesso;
    }

}
