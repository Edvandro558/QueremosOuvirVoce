package parasolution.queremosouvirvoce.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.controller.UsuarioController;
import parasolution.queremosouvirvoce.model.Usuario;

public class CadastroGerenteFragment extends Fragment implements View.OnClickListener {

    View view;

    private TextInputLayout txtInputNome, txtInputUsuario, txtInputSenha, txtInputConfirmarSenha;
    private TextInputEditText txtEditNome, txtEditUsuario, txtEditSenha, txtEditConfirmarSenha;
    private Button btnCadastrar, btnCancelar, btnLimpar;
    UsuarioController usuarioController;
    Usuario usuario;
    FragmentManager fragmentManager;

    public CadastroGerenteFragment() {
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

        view =  inflater.inflate(R.layout.fragment_cadastro_gerente, container, false);

        txtInputNome = view.findViewById(R.id.txt_Input_Nome);
        txtInputUsuario = view.findViewById(R.id.txt_Input_Usuario);
        txtInputSenha = view.findViewById(R.id.txt_Input_Senha1);
        txtInputConfirmarSenha = view.findViewById(R.id.txt_Input_Senha2);
        txtEditNome = view.findViewById(R.id.edit_Nome);
        txtEditUsuario = view.findViewById(R.id.edit_Usuario);
        txtEditSenha = view.findViewById(R.id.edit_Senha1);
        txtEditConfirmarSenha = view.findViewById(R.id.edit_Senha2);
        btnCadastrar = view.findViewById(R.id.btn_Cadastrar);
        btnCancelar = view.findViewById(R.id.btn_Cancelar);
        btnLimpar = view.findViewById(R.id.btn_Limpar);

        btnCadastrar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);

        return view;
    }

    private boolean validarNome(){
        String nomeInput = txtInputNome.getEditText().getText().toString().trim();

        if(nomeInput.isEmpty()){
            txtInputNome.setError("Informe o nome");
            return false;
        }else {
            txtInputNome.setError(null);
            return true;
        }
    }

    private boolean validarUsuario(){
        String usuarioInput = txtInputUsuario.getEditText().getText().toString().trim();

        if(usuarioInput.isEmpty()){
            txtInputUsuario.setError("Informe o usuário");
            return false;
        } else if(usuarioInput.length() > 15){
            txtInputUsuario.setError("Usuário acima do limite de carácteres");
            return false;
        }else {
            txtInputUsuario.setError(null);
            return true;
        }
    }

    private boolean validarSenha(){
        String senhaInput = txtInputSenha.getEditText().getText().toString().trim();
        String confirmarSenhaInput =txtInputConfirmarSenha.getEditText().getText().toString().trim();

        if(senhaInput.isEmpty()){
            txtInputSenha.setError("Informe a senha");
            return false;
        } else if(!usuarioController.PASSWORD_PATTERN.matcher(senhaInput).matches()) {
            txtInputSenha.setError("Senha muito fraca");
            return false;
        }else if(senhaInput.length() > 12) {
            txtInputSenha.setError("Senha acima do limite de carácteres");
            return false;
        }else if(confirmarSenhaInput.isEmpty()) {
            txtInputConfirmarSenha.setError("Confirme a senha");
            return false;
        }else if(!senhaInput.equals(confirmarSenhaInput)){
            txtInputConfirmarSenha.setError("Senhas não conferem");
            return false;
        } else {
            txtInputSenha.setError(null);
            txtInputConfirmarSenha.setError(null);
            return true;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Cadastrar:
            if (!validarNome() | !validarUsuario() | !validarSenha()) {
                return;
            } else {
                usuario = new Usuario();
                usuarioController = new UsuarioController(getContext());
                usuario.setNome(txtInputNome.getEditText().getText().toString().trim());
                usuario.setUsuario(txtInputUsuario.getEditText().getText().toString().trim());
                usuario.setSenha(txtInputSenha.getEditText().getText().toString().trim());

                if (usuarioController.salvar(usuario)) {
                    Toast.makeText(getContext(), "Novo usuário cadastrado", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(),"Usuário já existe", Toast.LENGTH_SHORT).show();
                }
            }
            break;

            case R.id.btn_Cancelar:
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_fragment, new AdministradorFragment()).commit();
                break;

            case R.id.btn_Limpar:
                txtEditNome.setText("");
                txtEditUsuario.setText("");
                txtEditSenha.setText("");
                txtEditConfirmarSenha.setText("");
                break;
        }

    }
}
