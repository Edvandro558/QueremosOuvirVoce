package parasolution.queremosouvirvoce.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.controller.ClienteController;
import parasolution.queremosouvirvoce.model.Cliente;
import parasolution.queremosouvirvoce.view.FinalActivity;

public class CadastroClienteFragment extends Fragment implements View.OnClickListener {

    View view;
    Context context;
    Intent intent;
    TextInputLayout txtInputNome, txtInputEmail, txtInputNascimento, txtInputFone, txtInputMensagem;
    EditText editNascimento, editTelefone, editNome, editEmail, editMensagem;
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

        txtInputNome = view.findViewById(R.id.inputlayoutNome);
        txtInputEmail = view.findViewById(R.id.inputlayoutEmail);
        txtInputNascimento = view.findViewById(R.id.inputlayoutNascimento);
        editNome = view.findViewById(R.id.editNome);
        editEmail = view.findViewById(R.id.editEmail);
        editNascimento = view.findViewById(R.id.editNascimento);
        editTelefone = view.findViewById(R.id.editFone);
        editMensagem = view.findViewById(R.id.editMensagem);
        txtInputFone = view.findViewById(R.id.inputlayoutFone);
        txtInputMensagem = view.findViewById(R.id.inputlayoutMensagem);
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
                if(!validarNome() | !validarEmail() | !validarNascimento() | !validarTelefone()) {
                    return;
                } else {
                    builder = new AlertDialog.Builder(context);
                    builder.setTitle("ALERTA");
                    builder.setMessage("Confirmar envio?");
                    builder.setCancelable(true);
                    builder.setIcon(R.drawable.imglogo);

                    builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            checarNotificacao();
                            cliente.setNome(txtInputNome.getEditText().getText().toString());
                            cliente.setEmail(txtInputEmail.getEditText().getText().toString());
                            cliente.setNascimento(editNascimento.getText().toString());
                            cliente.setTelefone(editTelefone.getText().toString());
                            cliente.setMensagem(txtInputMensagem.getEditText().getText().toString());

                            clienteController.salvar(cliente);

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
                builder.setIcon(R.drawable.imglogo);

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
                builder.setIcon(R.drawable.imglogo);

                builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editNome.setText("");
                        editEmail.setText("");
                        editNascimento.setText("");
                        editTelefone.setText("");
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

    private boolean validarNome(){
        String nomeInput = txtInputNome.getEditText().getText().toString().trim();

        if(nomeInput.isEmpty()){
            txtInputNome.setError("Não pode estar vazio");
            return false;
        }else {
            txtInputNome.setError(null);
            return true;
        }
    }

    private boolean validarEmail(){
        String emailInput = txtInputEmail.getEditText().getText().toString().trim();

        if(emailInput.isEmpty()){
            txtInputEmail.setError("Não pode estar vazio");
            return false;
        } else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            txtInputEmail.setError("Por favor insira um endereço de email válido!");
            return false;
        } else {
            txtInputEmail.setError(null);
            return true;
        }
    }

    private boolean validarNascimento(){
        String nascimentoInput = editNascimento.getText().toString().trim();

        if(nascimentoInput.isEmpty()) {
            editNascimento.setError("*");
            return false;
        } else if(nascimentoInput.length() < 10){
            editNascimento.setError("*");
            return false;
        }else {
            editNascimento.setError(null);
            return true;
        }
    }

    private boolean validarTelefone(){
        String telefoneInput = editTelefone.getText().toString().trim();

         if(telefoneInput.length() > 0 && telefoneInput.length() < 15){
            txtInputFone.setError("Insira um telefone válido");
            return false;
        }else {
            txtInputNascimento.setError(null);
            return true;
        }
    }

    private void checarNotificacao(){
        if(rbSim.isChecked()){
            cliente.setNotificacao("Sim");
        }else {
            cliente.setNotificacao("Não");
        }
    }
}
