package parasolution.queremosouvirvoce.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import parasolution.queremosouvirvoce.R;

public class CategoriasFragment extends Fragment {

    View view;

    GridLayout gridPrincipal;

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

        return view;
    }

    private void destacarSelecao(GridLayout gridPrincipal) {
        //pegar todos os itens do grid no loop
        for(int i = 0; i<gridPrincipal.getChildCount();i++){
            final CardView cardView = (CardView)gridPrincipal.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cardView.getCardBackgroundColor().getDefaultColor() == -1){
                        //trocar a cor de fundo
                        cardView.setCardBackgroundColor(Color.parseColor("#E04D00"));

                    } else {
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    }
                }
            });
        }
    }

}
