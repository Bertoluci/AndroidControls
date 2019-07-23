package cz.seucit.androidcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBarActivity extends AppCompatActivity {

    SeekBar basicSeekBar;
    TextView current;
    TextView start;
    TextView stop;
    TextView diff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        current = findViewById(R.id.tvCurrentValue);
        start = findViewById(R.id.tvStartValue);
        stop = findViewById(R.id.tvStopValue);
        diff = findViewById(R.id.tvDiffValue);

        basicSeekBar = findViewById(R.id.sbBasic);
        basicSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            private int startProgresValue;
            private int progresValue;
            private int stopProgresValue;
            private int difference;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progresValue = progress;
                current.setText(String.valueOf(progresValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                startProgresValue = basicSeekBar.getProgress();
                start.setText(String.valueOf(startProgresValue));

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                stopProgresValue = progresValue;
                stop.setText(String.valueOf(stopProgresValue));
                difference = stopProgresValue - startProgresValue;
                diff.setText((String.valueOf(difference)));
                Toast.makeText(SeekBarActivity.this, "current value: " + progresValue, Toast.LENGTH_LONG).show();
            }
        });
        current.setText(String.valueOf(basicSeekBar.getProgress()));
    }
}
