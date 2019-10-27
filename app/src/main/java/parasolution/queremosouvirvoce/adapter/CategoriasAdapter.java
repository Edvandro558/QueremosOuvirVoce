package parasolution.queremosouvirvoce.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import parasolution.queremosouvirvoce.Interface.IOnCardItemClickListener;
import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.model.CategoriasItem;
import parasolution.queremosouvirvoce.model.Common;

public class CategoriasAdapter extends RecyclerView.Adapter<CategoriasAdapter.CategoriasViewHolder> {

    Context context;
    List<CategoriasItem> categoriasItemsLista;

    public CategoriasAdapter(Context context, List<CategoriasItem> categoriasItemsLista) {
        this.context = context;
        this.categoriasItemsLista = categoriasItemsLista;
    }

    @NonNull
    @Override
    public CategoriasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_categorias_cardview,parent,false);
        return new CategoriasViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriasViewHolder holder, int position) {
        holder.img_icone.setImageResource(categoriasItemsLista.get(position).getIcone());
        holder.txt_descricao.setText(categoriasItemsLista.get(position).getTxt());

        holder.setiOnCardItemClickListener(new IOnCardItemClickListener() {
            @Override
            public void onCartItemClick(View view, int position) {

                Log.d("SELECAO", "TESTE CONTEUDO SELECAO: "+ categoriasItemsLista.get(position).getTxt());

            }
        });

    }

    @Override
    public int getItemCount() {
        return categoriasItemsLista.size();
    }

    public class CategoriasViewHolder extends RecyclerView.ViewHolder{
        ImageView img_icone;
        TextView txt_descricao;
        IOnCardItemClickListener iOnCardItemClickListener;


        public void setiOnCardItemClickListener(IOnCardItemClickListener iOnCardItemClickListener) {
            this.iOnCardItemClickListener = iOnCardItemClickListener;
        }

        public CategoriasViewHolder(View itemview){
            super(itemview);
            img_icone = (ImageView)itemview.findViewById(R.id.img_icone);
            txt_descricao = (TextView)itemview.findViewById(R.id.txt_descricao);

            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iOnCardItemClickListener.onCartItemClick(v,getAdapterPosition());
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (categoriasItemsLista.size() == 1)
            return 0;
        else{
            if (categoriasItemsLista.size() % Common.NUM_OF_COLUMN == 0)
                return 1;
            else
                return (position > 1 && position == categoriasItemsLista.size()-1)?0:1;
        }
    }
}
