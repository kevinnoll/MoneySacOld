package money.sac.dev;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

    private SegmentedRadioGroup radioGroup;
    private Spinner monthSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    private void load() {
        monthSpinner = (Spinner)findViewById(R.id.spinnerMonths);
        ArrayAdapter<String> monthSpinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        monthSpinnerAdapter.add("October");
        monthSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        monthSpinner.setAdapter(monthSpinnerAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu); //menu is toggled off, turn on if needed!
        return false;
    }
    
}
