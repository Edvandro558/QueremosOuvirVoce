package parasolution.queremosouvirvoce.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import parasolution.queremosouvirvoce.R;

public class RelatorioFragment extends Fragment {

    View view;
    BarChart barChart;

    ArrayList<String> dates;
    Random random;
    ArrayList<BarEntry> barEntries;

    public RelatorioFragment() {
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

        view =  inflater.inflate(R.layout.fragment_relatorios, container, false);

        barChart = (BarChart)view.findViewById(R.id.bargraph);

        createRandomBarGraph("2019/05/06", "2019/06/01");

        return view;
    }

    private void createRandomBarGraph(String date1, String date2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

        try {
            Date Date1 = simpleDateFormat.parse(date1);
            Date Date2 = simpleDateFormat.parse(date2);

            Calendar mDate1 = Calendar.getInstance();
            Calendar mDate2 = Calendar.getInstance();

            mDate1.clear();
            mDate1.clear();

            mDate1.setTime(Date1);
            mDate2.setTime(Date2);

            dates = new ArrayList<>();
            dates = getList(mDate1,mDate2);

            barEntries = new ArrayList<>();
            random = new Random();
            float max = 0f;
            float value = 0f;
            for(int j = 0; j< dates.size(); j++){
                max = 100f;
                value = random.nextFloat()*max;
                barEntries.add(new BarEntry(value, j));
            }

        }catch (ParseException e){
            e.printStackTrace();
        }

        BarDataSet barDataSet = new BarDataSet(barEntries, "Dates");
        BarData barData = new BarData(dates, barDataSet);
        barChart.setData(barData);
        barChart.setDescription("My firts Bar Graph!");
    }

    private ArrayList<String> getList(Calendar startDate, Calendar endDate) {
        ArrayList<String> list = new ArrayList<>();
        while (startDate.compareTo(endDate)<=0){
            list.add(getDate(startDate));
            startDate.add(Calendar.DAY_OF_MONTH, 1);
        }
        return list;
    }

    private String getDate(Calendar cld) {
        String curDate = cld.get(Calendar.YEAR) + "/" + (cld.get(Calendar.MONTH) + 1) + "/"
                +cld.get(Calendar.DAY_OF_MONTH);

        try {
            Date date = new SimpleDateFormat("yyyy/MM/dd").parse(curDate);
            curDate = new SimpleDateFormat("yyyy/MM/dd").format(date);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return curDate;
    }

}
