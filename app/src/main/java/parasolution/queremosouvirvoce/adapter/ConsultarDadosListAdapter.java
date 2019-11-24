package parasolution.queremosouvirvoce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.model.Cliente;

public class ConsultarDadosListAdapter extends ArrayAdapter<Cliente> {
    Context context;
    private int ultimaPosicao = -1;

    private static class ViewHolder{
        TextView txtNome;
        TextView txtNascimento;
        TextView txtEmail;
        TextView txtFone;
        TextView txtNotificacao;
        TextView txtMensagem;
    }

    public ConsultarDadosListAdapter(ArrayList<Cliente> dataSet, Context context) {
        super(context, R.layout.fragment_consultar_dados_item, dataSet);

        ArrayList<Cliente> dados = dataSet;

        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View dataSet, @NonNull ViewGroup parent){

        Cliente cliente = getItem(position);

        ViewHolder linha;

        if(dataSet == null){
            linha = new ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            dataSet = layoutInflater.inflate(R.layout.fragment_consultar_dados_item, parent, false);

            linha.txtNome = dataSet.findViewById(R.id.txt_Nome);
            linha.txtNascimento = dataSet.findViewById(R.id.txt_Nascimento);
            linha.txtEmail = dataSet.findViewById(R.id.txt_Email);
            linha.txtFone = dataSet.findViewById(R.id.txt_Fone);
            linha.txtNotificacao = dataSet.findViewById(R.id.txt_Notificacao);
            linha.txtMensagem = dataSet.findViewById(R.id.txt_Mensagem);

            dataSet.setTag(linha);
        }else {
            linha = (ViewHolder) dataSet.getTag();
        }

        linha.txtNome.setText(cliente.getNome());
        linha.txtNascimento.setText(cliente.getNascimento());
        linha.txtEmail.setText(cliente.getEmail());
        linha.txtFone.setText(cliente.getTelefone());
        linha.txtNotificacao.setText(cliente.getNotificacao());
        linha.txtMensagem.setText(cliente.getMensagem());

        return dataSet;
    }
}
