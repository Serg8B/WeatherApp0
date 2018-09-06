package app.sergio8.com.weatherapp0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvForecast;
    private Spinner spTowns;

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // spTowns = findViewById(R.id.menu_add);

        tvForecast = findViewById(R.id.tvShow_forecast);
        spTowns = findViewById(R.id.spTown);
        spTowns.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Settings.setChangeTown(MainActivity.this, (String) spTowns.getSelectedItem());
                tvForecast.setText(getResources().getStringArray(R.array.forecast)[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spTowns.setSelection(getChangedTownIndex(Settings.getChangeTown(this)));

    }
    private int getChangedTownIndex(String townName)
    {
         String allTowns[]=getResources().getStringArray(R.array.towns);
        for (int index = 0; index < allTowns.length ; index++) {
            if(allTowns[index].equals(townName)) return index;
            }
            return 0;

    }
}