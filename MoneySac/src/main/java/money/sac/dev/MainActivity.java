package money.sac.dev;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    private void load() {
        Spinner monthSpinner = loadSpinner();
        ListView listView = loadListView();
    }

    private ListView loadListView(){
        ListView listView = (ListView)findViewById(R.id.listViewEntries);
        ListEntry[] listEntries = new ListEntry[5];
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 0);
        Date today = calendar.getTime();
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();

        listEntries[0] = new ListEntry(yesterday, "Schuhe", 100, false);
        listEntries[1] = new ListEntry(yesterday, "Gehalt", 2000, true);
        listEntries[2] = new ListEntry(today, "Laptop", 1000, false);
        listEntries[3] = new ListEntry(today, "Taschengeld", 100, true);
        listEntries[4] = new ListEntry(today, "Essen", 200, false);

        ListViewAdapter listAdapter = new ListViewAdapter(this, listEntries);
        listView.setAdapter(listAdapter);
        return listView;
    }

    private Spinner loadSpinner(){
        Spinner monthSpinner = (Spinner)findViewById(R.id.spinnerMonths);
        ArrayAdapter<String> monthSpinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        monthSpinnerAdapter.add("September 2013");
        monthSpinnerAdapter.add("Oktober 2013");
        monthSpinnerAdapter.add("November 2013");
        monthSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        monthSpinner.setAdapter(monthSpinnerAdapter);
        return monthSpinner;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu); //menu is toggled off, turn on if needed!
        return false;
    }
    
}
