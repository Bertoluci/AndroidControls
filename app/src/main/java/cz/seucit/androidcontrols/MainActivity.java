package cz.seucit.androidcontrols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_spinner(View view) {
        startActivity(new Intent(this, SpinnerActivity.class));
    }

    public void onClick_seekBar(View view) {
        startActivity(new Intent(this, SeekBarActivity.class));
    }
}