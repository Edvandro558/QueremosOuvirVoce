package parasolution.queremosouvirvoce.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.model.PerguntasModel;

public class PerguntasAdapter extends RecyclerView.Adapter<PerguntasAdapter.PerguntasViewHolder> {
    private ArrayList<PerguntasModel> adapterPerguntasLista;
    private OnItemClickListener adapterListener;

    public interface OnItemClickListener{
        void onEmote1Click(int position);
        void onEmote2Click(int position);
        void onEmote3Click(int position);
        void onEmote4Click(int position);
        void onEmote5Click(int position);
        void onEmote6Click(int position);
        void onEmote7Click(int position);
        void onEmote8Click(int position);
        void onEmote9Click(int position);
        void onEmote10Click(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        adapterListener = listener;
    }

    public static class PerguntasViewHolder extends RecyclerView.ViewHolder{
        public TextView txtPerguntaCerteza;
        public TextView txtPerguntaIncerteza;
        public ToggleButton emote1;
        public ToggleButton emote2;
        public ToggleButton emote3;
        public ToggleButton emote4;
        public ToggleButton emote5;
        public ToggleButton emote6;
        public ToggleButton emote7;
        public ToggleButton emote8;
        public ToggleButton emote9;
        public ToggleButton emote10;

        public PerguntasViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            txtPerguntaCerteza = itemView.findViewById(R.id.txtPerguntaCerteza);
            txtPerguntaIncerteza = itemView.findViewById(R.id.txtPerguntaIncerteza);
            emote1 = itemView.findViewById(R.id.emote1);
            emote2 = itemView.findViewById(R.id.emote2);
            emote3 = itemView.findViewById(R.id.emote3);
            emote4 = itemView.findViewById(R.id.emote4);
            emote5 = itemView.findViewById(R.id.emote5);
            emote6 = itemView.findViewById(R.id.emote6);
            emote7 = itemView.findViewById(R.id.emote7);
            emote8 = itemView.findViewById(R.id.emote8);
            emote9 = itemView.findViewById(R.id.emote9);
            emote10 = itemView.findViewById(R.id.emote10);

            emote1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote1Click(position);
                        }
                    }
                }
            });

            emote2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote2Click(position);
                        }
                    }
                }
            });emote3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote3Click(position);
                        }
                    }
                }
            });emote4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote4Click(position);
                        }
                    }
                }
            });emote5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote5Click(position);
                        }
                    }
                }
            });emote6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote5Click(position);
                        }
                    }
                }
            });emote7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote5Click(position);
                        }
                    }
                }
            });emote8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote5Click(position);
                        }
                    }
                }
            });emote9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote5Click(position);
                        }
                    }
                }
            });emote10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote5Click(position);
                        }
                    }
                }
            });
        }
    }

    public PerguntasAdapter(ArrayList<PerguntasModel> perguntasModelLista){
        adapterPerguntasLista = perguntasModelLista;
    }

    @NonNull
    @Override
    public PerguntasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_perguntas_item, parent, false);
        PerguntasViewHolder perguntasViewHolder = new PerguntasViewHolder(v,adapterListener);
        return perguntasViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PerguntasViewHolder holder, int position) {
        PerguntasModel perguntaAtual = adapterPerguntasLista.get(position);

        holder.txtPerguntaCerteza.setText(perguntaAtual.getTxt_pergunta_certeza());
        holder.txtPerguntaIncerteza.setText(perguntaAtual.getTxt_pergunta_incerteza());
    }

    @Override
    public int getItemCount() {
        return adapterPerguntasLista.size();
    }

}
