package money.sac.dev.Activities;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import money.sac.dev.Adapters.ListViewAdapter;
import money.sac.dev.Model.BankAccountList;
import money.sac.dev.Model.BankAccountMonth;
import money.sac.dev.Model.ListEntry;
import money.sac.dev.R;
import money.sac.dev.Helpers.SegmentedRadioGroup;

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
        SegmentedRadioGroup segmentedButton = loadSegmentedRadioGroup();
    }

    private SegmentedRadioGroup loadSegmentedRadioGroup() {
        return (SegmentedRadioGroup)findViewById(R.id.segmentedRadioGroup);
    }

    public void segmentedButtonClicked(View v){

        if(v.getId() == R.id.segmentedRadioButtonIn){

        } else if(v.getId() == R.id.segmentedRadioButtonOut){
            //if Out clicked

        } else {
            //represents all other states, showing both.

        }
    }

    private ListView loadListView(){
        ListView listView = (ListView)findViewById(R.id.listViewEntries);
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        Date yesterday = calendar.getTime();

        LinkedList<ListEntry> accountList = new LinkedList<ListEntry>();
        accountList.add(new ListEntry(yesterday, "Schuhe", 100, false));
        accountList.add(new ListEntry(yesterday, "Gehalt", 2000, true));
        accountList.add(new ListEntry(today, "Laptop", 1000, false));
        accountList.add(new ListEntry(today, "Taschengeld", 100, true));
        accountList.add(new ListEntry(today, "Essen", 200, false));

        Date thisMonth = calendar.getTime();

        //save a month just for example
        BankAccountMonth bankAccountMonth = new BankAccountMonth(accountList, thisMonth);
        BankAccountList.addMonthToStorage(this, bankAccountMonth);

        //and load it again
        BankAccountMonth currentMonth = BankAccountList.getMonthFromStorage(this, thisMonth);
        ListViewAdapter listAdapter = new ListViewAdapter(this, currentMonth.getEntries());
        listView.setAdapter(listAdapter);
        return listView;
    }

    private Spinner loadSpinner(){
        Spinner monthSpinner = (Spinner)findViewById(R.id.spinnerMonths);
        ArrayAdapter<String> monthSpinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        List<String> allMonths = getMonths();
        monthSpinnerAdapter.addAll(allMonths);
        monthSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        monthSpinner.setAdapter(monthSpinnerAdapter);
        return monthSpinner;
    }

    private List<String> getMonths() {
        List<String> list = new LinkedList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy", Locale.GERMAN);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        Date thisMonth = calendar.getTime();
        list.add(sdf.format(thisMonth).toString());
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu); //menu is toggled off, turn on if needed!
        return false;
    }
    
}
