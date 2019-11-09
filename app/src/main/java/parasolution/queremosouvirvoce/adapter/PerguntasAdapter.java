package parasolution.queremosouvirvoce.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.model.Perguntas;

public class PerguntasAdapter extends RecyclerView.Adapter<PerguntasAdapter.PerguntasViewHolder> {
    private ArrayList<Perguntas> adapterPerguntasLista;
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
        private TextView txtPerguntaCerteza;
        private TextView txtPerguntaIncerteza;
        private RadioGroup radioGroupCerteza;
        private RadioGroup radioGroupIncerteza;
        private RadioButton rbMuitoInsatisfeito;
        private RadioButton rbInsatisfeito;
        private RadioButton rbNeutro;
        private RadioButton rbSatisfeito;
        private RadioButton rbMuitoSatisfeito;
        private RadioButton rbNaoPrecisa;
        private RadioButton rbPrecisaPouco;
        private RadioButton rbTalvez;
        private RadioButton rbPrecisa;
        private RadioButton rbPrecisaMuito;

        public PerguntasViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            txtPerguntaCerteza = itemView.findViewById(R.id.txtPerguntaCerteza);
            txtPerguntaIncerteza = itemView.findViewById(R.id.txtPerguntaIncerteza);
            radioGroupCerteza = itemView.findViewById(R.id.radioGroupCerteza);
            radioGroupIncerteza = itemView.findViewById(R.id.radioGroupIncerteza);
            rbMuitoInsatisfeito =itemView.findViewById(R.id.rbMuitoInsatisfeito);
            rbInsatisfeito =itemView.findViewById(R.id.rbInsatisfeito);
            rbNeutro =itemView.findViewById(R.id.rbNeutro);
            rbSatisfeito =itemView.findViewById(R.id.rbSatisfeito);
            rbMuitoSatisfeito =itemView.findViewById(R.id.rbMuitoSatisfeito);
            rbNaoPrecisa =itemView.findViewById(R.id.rbNaoPrecisa);
            rbPrecisaPouco =itemView.findViewById(R.id.rbPrecisaPouco);
            rbTalvez =itemView.findViewById(R.id.rbTalvez);
            rbPrecisa =itemView.findViewById(R.id.rbPrecisa);
            rbPrecisaMuito =itemView.findViewById(R.id.rbPrecisaMuito);


            rbMuitoInsatisfeito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (listener != null) {
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION) {
                                listener.onEmote1Click(position);
                            }
                        }
                }
            });

            rbInsatisfeito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION) {
                                listener.onEmote2Click(position);
                            }
                        }
                }
            });

            rbNeutro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote3Click(position);
                        }
                    }
                }
            });

            rbSatisfeito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote4Click(position);
                        }
                    }
                }
            });

            rbMuitoSatisfeito.setOnClickListener(new View.OnClickListener() {
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

            rbNaoPrecisa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote6Click(position);
                        }
                    }
                }
            });

            rbPrecisaPouco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote7Click(position);
                        }
                    }
                }
            });

            rbTalvez.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote8Click(position);
                        }
                    }
                }
            });

            rbPrecisa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote9Click(position);
                        }
                    }
                }
            });

            rbPrecisaMuito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onEmote10Click(position);
                        }
                    }
                }
            });

        }
    }

    public PerguntasAdapter(ArrayList<Perguntas> perguntasLista){
        adapterPerguntasLista = perguntasLista;
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
        Perguntas perguntaAtual = adapterPerguntasLista.get(position);

            holder.txtPerguntaCerteza.setText(perguntaAtual.getPerguntaCerteza());
            holder.txtPerguntaIncerteza.setText(perguntaAtual.getPerguntaIncerteza());
            holder.radioGroupCerteza.clearCheck();
            holder.radioGroupIncerteza.clearCheck();

    }

    @Override
    public int getItemCount() {
        return adapterPerguntasLista.size();
    }

}
