package parasolution.queremosouvirvoce.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import parasolution.queremosouvirvoce.R;
import parasolution.queremosouvirvoce.controller.UsuarioController;
import parasolution.queremosouvirvoce.model.Respostas;

public class RelatorioFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    View view;
    Context context;
    Spinner spinner_Periodo, spinner_Prazo;
    Button btnConsultar;
    TextView txtPorcetagemCerteza, txtPorcertagemContradicao, txtSituacao;

    UsuarioController usuarioController;
    List<Respostas> minimizacao;
    BarChart barChart;
    ArrayList<BarEntry> barCertezaEntries, barIncertezaEntries;



    public RelatorioFragment() {
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

        view =  inflater.inflate(R.layout.fragment_relatorios, container, false);

        btnConsultar = view.findViewById(R.id.btn_Consultar);
        txtPorcetagemCerteza = view.findViewById(R.id.txt_Porcentagem_Certeza);
        txtPorcertagemContradicao = view.findViewById(R.id.txt_Porcentagem_Contradicao);
        txtSituacao = view.findViewById(R.id.txt_Situacao);
        barChart = view.findViewById(R.id.bg_geral);

        spinner_Periodo = view.findViewById(R.id.spinner_Periodo);
        ArrayAdapter<CharSequence> periodoAdapter = ArrayAdapter.createFromResource(context, R.array.periodo, android.R.layout.simple_spinner_item);
        periodoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Periodo.setAdapter(periodoAdapter);
        spinner_Periodo.setOnItemSelectedListener(this);

        spinner_Prazo = view.findViewById(R.id.spinner_Prazo);
        ArrayAdapter<CharSequence> prazoAdapter = ArrayAdapter.createFromResource(context, R.array.prazo, android.R.layout.simple_spinner_item);
        prazoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Prazo.setAdapter(prazoAdapter);
        spinner_Prazo.setOnItemSelectedListener(this);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        barChart = (BarChart) view.findViewById(R.id.bg_geral);

        barChart.setDrawBarShadow(false);
        barChart.setPinchZoom(true);
        barChart.setDragEnabled(true);
        barChart.setTouchEnabled(true);
        barChart.setScaleEnabled(true);

        barCertezaEntries = new ArrayList<>();
        barIncertezaEntries = new ArrayList<>();

        usuarioController = new UsuarioController(context);
        minimizacao =  new ArrayList<>();
        minimizacao = usuarioController.minimizacao("geral", null);

        barCerteza(minimizacao);
        barContradicao(minimizacao);

        BarDataSet barCertezaDataSet = new BarDataSet(barCertezaEntries, "Certeza");
        barCertezaDataSet.setColor(Color.parseColor("#E04D00"));
        barCertezaDataSet.setValueTextSize(12);
        barCertezaDataSet.setValueFormatter(new PercentFormatter());

        BarDataSet barContradicaoDataSet = new BarDataSet(barIncertezaEntries, "Contradição");
        barContradicaoDataSet.setColor(Color.parseColor("#4B392E"));
        barContradicaoDataSet.setValueTextSize(12);
        barContradicaoDataSet.setValueFormatter(new PercentFormatter());

        BarData data = new BarData(barCertezaDataSet, barContradicaoDataSet);

        barChart.setData(data);

        String[] fatores = new String[]{"","Atendimento", "Ambiente", "Café", "Bebidas", "HappyHour", "Pratos", "Doces", "Salgados", "Boutique"};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(fatores));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);
        xAxis.setAxisMinimum(1);
        xAxis.setTextSize(12);
        xAxis.setDrawGridLines(false);

        YAxis yAxisLeft = barChart.getAxisLeft();
        yAxisLeft.setTextSize(12);
        yAxisLeft.setDrawGridLines(true);
        yAxisLeft.setValueFormatter(new PercentFormatter());
        yAxisLeft.setAxisMinimum(-100);
        yAxisLeft.setAxisMaximum(100);

        YAxis yAxisRight = barChart.getAxisRight();
        yAxisRight.setTextSize(12);
        yAxisRight.setDrawGridLines(true);
        yAxisRight.setValueFormatter(new PercentFormatter());
        yAxisRight.setAxisMinimum(-100);
        yAxisRight.setAxisMaximum(100);


        float groupSpace = 0.1f;
        float barSpace = 0.02f;
        float barWidth = 0.43f;

        data.setBarWidth(barWidth);
        barChart.groupBars(1, groupSpace, barSpace);
        barChart.animateXY(2000,2000);
        barChart.invalidate();

        certezaContradicaoGeral(minimizacao);

        return view;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void barCerteza(List<Respostas> minimizacao){
        int position = 1;
        for (Respostas respostas: minimizacao) {

            barCertezaEntries.add(new BarEntry(position, usuarioController.grauCerteza(respostas.getRespostaCerteza(), respostas.getRespostaIncerteza())));
            position++;
        }

    }

    private void barContradicao(List<Respostas> minimizacao){
        int position = 1;
        for (Respostas respostas: minimizacao) {

            barIncertezaEntries.add(new BarEntry(position, usuarioController.grauContradicao(respostas.getRespostaCerteza(), respostas.getRespostaIncerteza())));
            position++;
        }
    }

    private void certezaContradicaoGeral(List<Respostas> minimizacao){
        float certezaGeal = usuarioController.certezaGeral(minimizacao);
        txtPorcetagemCerteza.setText(usuarioController.formatarDecimal(usuarioController.certezaGeral(minimizacao)));
        txtPorcertagemContradicao.setText(usuarioController.formatarDecimal(usuarioController.contradicaoGeral(minimizacao)));
        txtSituacao.setText(usuarioController.situacao(certezaGeal));
    }

    public class PercentFormatter extends ValueFormatter{
        private DecimalFormat mformat;
        private boolean percentSignSeparated;

        public PercentFormatter(){
            mformat = new DecimalFormat("###,###,###.#");
            percentSignSeparated = true;
        }

        @Override
        public String getFormattedValue(float value){
            return mformat.format(value) + (percentSignSeparated ? " %" : "%");
        }
    }

}
