package parasolution.queremosouvirvoce.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import parasolution.queremosouvirvoce.R;

public class CategoriasFragment extends Fragment {

    private View view;

    private GridLayout gridPrincipal;

    int[] selecao = new int[6];

    public CategoriasFragment() {
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

        view =  inflater.inflate(R.layout.fragment_categorias, container, false);

        gridPrincipal = view.findViewById(R.id.gridPrincipal);

        destacarSelecao(gridPrincipal);

        verifarSelecao(selecao);

        return view;
    }

    private void destacarSelecao(final GridLayout gridPrincipal) {

        //coloca todos os itens do gridlayout para mapear as posicoes
        for(int i = 0; i<gridPrincipal.getChildCount(); i++)
        {
            final CardView cardView = (CardView)gridPrincipal.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cardView.getCardBackgroundColor().getDefaultColor() == -1)
                    {
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(getContext(),"TESTE SELECAO: "+ finalI,Toast.LENGTH_LONG).show();
                            int i=0;
                            selecao[i]=finalI;
                            Log.d("SELECAO", "TESTE CONTEUDO SELECAO: "+i);
                    }
                    else
                    {
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(getContext(),"TESTE DESSELECAO: "+ finalI,Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    public void verifarSelecao(int[] selecao){
        for(int i = 0; i<= selecao.length; i++){
            Log.d("SELECAO", "TESTE CONTEUDO SELECAO: "+i);
        }
    }
}
