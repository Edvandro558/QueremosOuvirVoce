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
    TextView txtPorcetagemCerteza, txtPorcertagemContradicao, txtSituacao, txtRelatorio;
    String tipoRelatorio = null;
    String periodo = null;

    UsuarioController usuarioController;
    List<Respostas> minimizacao;
    BarChart barChart;
    BarData data;
    BarDataSet barCertezaDataSet, barContradicaoDataSet;
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
        txtRelatorio = view.findViewById(R.id.txt_Relatorio);
        barChart = view.findViewById(R.id.bg_geral);

        spinner_Periodo = view.findViewById(R.id.spinner_Periodo);
        final ArrayAdapter<CharSequence> periodoAdapter = ArrayAdapter.createFromResource(context, R.array.periodo, android.R.layout.simple_spinner_item);
        periodoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Periodo.setAdapter(periodoAdapter);
        spinner_Periodo.setOnItemSelectedListener(this);

        spinner_Prazo = view.findViewById(R.id.spinner_Prazo);
        ArrayAdapter<CharSequence> prazoAdapter = ArrayAdapter.createFromResource(context, R.array.prazo, android.R.layout.simple_spinner_item);
        prazoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Prazo.setAdapter(prazoAdapter);
        spinner_Prazo.setOnItemSelectedListener(this);

        barChart = (BarChart) view.findViewById(R.id.bg_geral);

        barCertezaEntries = new ArrayList<>();
        barIncertezaEntries = new ArrayList<>();

        usuarioController = new UsuarioController(context);
        minimizacao =  new ArrayList<>();
        minimizacao = usuarioController.minimizacao("Geral", null);

        gerarGrafico(minimizacao);

        certezaContradicaoGeral(minimizacao);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tipoRelatorio.contains("Geral") && periodo.isEmpty()){
                    barCertezaEntries = new ArrayList<>();
                    barIncertezaEntries = new ArrayList<>();
                    usuarioController = new UsuarioController(context);
                    minimizacao =  new ArrayList<>();
                    minimizacao = usuarioController.minimizacao(tipoRelatorio, null);
                    gerarGrafico(minimizacao);
                    certezaContradicaoGeral(minimizacao);
                    txtRelatorio.setText("Relatório " + tipoRelatorio);
                }else if(tipoRelatorio.contains("Geral") && !periodo.isEmpty()){
                    barCertezaEntries = new ArrayList<>();
                    barIncertezaEntries = new ArrayList<>();
                    usuarioController = new UsuarioController(context);
                    minimizacao =  new ArrayList<>();
                    minimizacao = usuarioController.minimizacao("Periodo", periodo);
                    gerarGrafico(minimizacao);
                    certezaContradicaoGeral(minimizacao);
                    if(periodo.contains("Matutino")){
                        txtRelatorio.setText("Relatório " + tipoRelatorio + " " + periodo);
                    }else {
                        txtRelatorio.setText("Relatório " + tipoRelatorio + " " +  periodo);
                    }
                }

                if(tipoRelatorio.contains("Semanal") && periodo.isEmpty()){
                    barCertezaEntries = new ArrayList<>();
                    barIncertezaEntries = new ArrayList<>();
                    usuarioController = new UsuarioController(context);
                    minimizacao =  new ArrayList<>();
                    minimizacao = usuarioController.minimizacao(tipoRelatorio, null);
                    gerarGrafico(minimizacao);
                    certezaContradicaoGeral(minimizacao);
                    txtRelatorio.setText("Relatório " + tipoRelatorio);
                }else if(tipoRelatorio.contains("Semanal") && !periodo.isEmpty()){
                    barCertezaEntries = new ArrayList<>();
                    barIncertezaEntries = new ArrayList<>();
                    usuarioController = new UsuarioController(context);
                    minimizacao = new ArrayList<>();
                    minimizacao = usuarioController.minimizacao("SemanalPeriodo", periodo);
                    gerarGrafico(minimizacao);
                    certezaContradicaoGeral(minimizacao);
                    if(periodo.contains("Matutino")){
                        txtRelatorio.setText("Relatório " + tipoRelatorio + " " + periodo);
                    }else {
                        txtRelatorio.setText("Relatório " + tipoRelatorio + " " +  periodo);
                    }
                }

                if(tipoRelatorio.contains("Mensal") && periodo.isEmpty()){
                    barCertezaEntries = new ArrayList<>();
                    barIncertezaEntries = new ArrayList<>();
                    usuarioController = new UsuarioController(context);
                    minimizacao = new ArrayList<>();
                    minimizacao = usuarioController.minimizacao(tipoRelatorio, null);
                    gerarGrafico(minimizacao);
                    certezaContradicaoGeral(minimizacao);
                    txtRelatorio.setText("Relatório " + tipoRelatorio);
                }else if(tipoRelatorio.contains("Mensal") && !periodo.isEmpty()){
                    barCertezaEntries = new ArrayList<>();
                    barIncertezaEntries = new ArrayList<>();
                    usuarioController = new UsuarioController(context);
                    minimizacao = new ArrayList<>();
                    minimizacao = usuarioController.minimizacao("MensalPeriodo", periodo);
                    gerarGrafico(minimizacao);
                    certezaContradicaoGeral(minimizacao);
                    if(periodo.contains("Matutino")){
                        txtRelatorio.setText("Relatório " + tipoRelatorio + " " + periodo);
                    }else {
                        txtRelatorio.setText("Relatório " + tipoRelatorio + " " +  periodo);
                    }
                }
            }
        });

        return view;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        switch (text){
            case "Geral":
                tipoRelatorio = text;
                break;
            case "Semanal":
                tipoRelatorio = text;
                break;
            case "Mensal":
                tipoRelatorio = text;
                break;
            case "Integral":
                periodo = "";
                break;
            case "Matutino":
                periodo = text;
                break;
            case "Vespertino":
                periodo = text;
                break;
        }
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
        float certezaGeral = usuarioController.certezaGeral(minimizacao);
        txtPorcetagemCerteza.setText(usuarioController.formatarDecimal(usuarioController.certezaGeral(minimizacao)));
        txtPorcertagemContradicao.setText(usuarioController.formatarDecimal(usuarioController.contradicaoGeral(minimizacao)));
        txtSituacao.setText(usuarioController.situacao(certezaGeral));
    }

    public class PercentFormatter extends ValueFormatter{
        private DecimalFormat mformat;
        private boolean percentSignSeparated;

        public PercentFormatter(){
            mformat = new DecimalFormat("###,###,#00.0");
            percentSignSeparated = true;
        }

        @Override
        public String getFormattedValue(float value){
            return mformat.format(value) + (percentSignSeparated ? " %" : "%");
        }
    }

    private void gerarGrafico(List<Respostas> minimizacao){
        barCerteza(minimizacao);
        barContradicao(minimizacao);

        barCertezaDataSet = new BarDataSet(barCertezaEntries, "Certeza");
        barCertezaDataSet.setColor(Color.parseColor("#E04D00"));
        barCertezaDataSet.setValueTextSize(12);
        barCertezaDataSet.setValueFormatter(new PercentFormatter());

        barContradicaoDataSet = new BarDataSet(barIncertezaEntries, "Contradição");
        barContradicaoDataSet.setColor(Color.parseColor("#4B392E"));
        barContradicaoDataSet.setValueTextSize(12);
        barContradicaoDataSet.setValueFormatter(new PercentFormatter());

        data = new BarData(barCertezaDataSet, barContradicaoDataSet);

        barChart.setData(data);

        String[] fatores = new String[]{"Atendimento", "Ambiente", "Café", "Bebidas", "HappyHour", "Pratos", "Doces", "Salgados", "Boutique"};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(fatores));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);
        xAxis.setTextSize(15);
        xAxis.setDrawGridLines(false);

        YAxis yAxisLeft = barChart.getAxisLeft();
        yAxisLeft.setTextSize(15);
        yAxisLeft.setDrawGridLines(true);
        yAxisLeft.setValueFormatter(new PercentFormatter());
        yAxisLeft.setAxisMinimum(-110);
        yAxisLeft.setAxisMaximum(110);

        YAxis yAxisRight = barChart.getAxisRight();
        yAxisRight.setTextSize(15);
        yAxisRight.setDrawGridLines(true);
        yAxisRight.setValueFormatter(new PercentFormatter());
        yAxisRight.setAxisMinimum(-110);
        yAxisRight.setAxisMaximum(110);
        yAxisRight.setGranularity(1);

        float groupSpace = 0.1f;
        float barSpace = 0.02f;
        float barWidth = 0.429f;

        data.setBarWidth(barWidth);

        barChart.setDrawBarShadow(false);
        barChart.setPinchZoom(true);
        barChart.setDragEnabled(true);
        barChart.setTouchEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.getXAxis().setAxisMinimum(0);
        barChart.getXAxis().setAxisMaximum(0+barChart.getBarData().getGroupWidth(groupSpace,barSpace)*9);
        barChart.groupBars(0, groupSpace, barSpace);
        barChart.animateXY(2000,2000);
        barChart.invalidate();
    }

}
