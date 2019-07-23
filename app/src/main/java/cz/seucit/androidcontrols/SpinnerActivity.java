package cz.seucit.androidcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cz.seucit.androidcontrols.component.CustomSpinner;
import cz.seucit.androidcontrols.model.SpinnerItems;

public class SpinnerActivity extends AppCompatActivity {

    //<editor-fold desc="Components">
    Spinner basicSpinnerEnum;
    Spinner basicSpinnerList;
    CheckBox cleanModelCheckBox;
    CustomSpinner customSpinner;
    //</editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        //<editor-fold desc="Basic Spinner with model of enum">
        basicSpinnerEnum = findViewById(R.id.spinnerBasicEnum);
        basicSpinnerEnum.setAdapter(new ArrayAdapter<SpinnerItems>(this, android.R.layout.simple_spinner_item, SpinnerItems.values()));
        basicSpinnerEnum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Toast.makeText(SpinnerActivity.this, "Selected: " + selectedItem, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //</editor-fold>

        //<editor-fold desc="Basic Spinner with model of List">
        basicSpinnerList = findViewById(R.id.spinnerBasicList);

        //<editor-fold desc="model">
        final List<String> model = new ArrayList<>();
        model.add("Item 1");
        model.add("Item 2");
        model.add("Item 3");
        cleanModelCheckBox = findViewById(R.id.chbCleanModel);
        cleanModelCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (isChecked) {
                    model.clear();
                    ArrayAdapter<String> adapter = (ArrayAdapter<String>) basicSpinnerList.getAdapter();
                    adapter.notifyDataSetChanged();
                } else {
                    model.clear();
                    model.add("Item 1");
                    model.add("Item 2");
                    model.add("Item 3");
                    ArrayAdapter<String> adapter = (ArrayAdapter<String>) basicSpinnerList.getAdapter();
                    adapter.notifyDataSetChanged();
                }
            }
        });
        //</editor-fold>

        basicSpinnerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, model));
        basicSpinnerList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Toast.makeText(SpinnerActivity.this, "Selected: " + selectedItem, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Object selectedItem = parent.getSelectedItem();
                Toast.makeText(SpinnerActivity.this, "The selected item has been deleted.", Toast.LENGTH_LONG).show();
            }
        });
        //</editor-fold>

        //<editor-fold desc="Custom Spinner with model of enum">
        customSpinner = findViewById(R.id.spinnerCustom);
        customSpinner.setAdapter(new ArrayAdapter<SpinnerItems>(this, android.R.layout.simple_spinner_item, SpinnerItems.values()));
        customSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Toast.makeText(SpinnerActivity.this, "Selected: " + selectedItem, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //</editor-fold>

    }
}
