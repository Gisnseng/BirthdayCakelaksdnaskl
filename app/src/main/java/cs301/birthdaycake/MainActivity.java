package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Lock the screen orientation to Landscape for this Activity
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Set the content of this Activity. This will create the Views defined in the XML.
        setContentView(R.layout.activity_main);

        // Retrieve a reference to the CakeView object from the GUI
        CakeView cakeView = findViewById(R.id.cakeview);

        // Create a new CakeController object, passing in the CakeView reference
        CakeController cakeController = new CakeController(cakeView);

        // Retrieve a reference to the "Blow Out" button and set the CakeController as its click listener
        Button blowOutButton = findViewById(R.id.button_blow_out); // Ensure this ID matches your layout
        blowOutButton.setOnClickListener(cakeController);

        // Retrieve a reference to the Candles switch and set the CakeController as its change listener
        Switch candlesSwitch = findViewById(R.id.switch_candles); // Ensure this ID matches your layout
        candlesSwitch.setOnCheckedChangeListener(cakeController);

        // Retrieve a reference to the SeekBar for candles and set the CakeController as its change listener
        SeekBar seekBarCandles = findViewById(R.id.seekBar_candles); // Ensure this ID matches your layout
        seekBarCandles.setOnSeekBarChangeListener(cakeController);

        //part 2 Lab 4
        cakeView.setOnTouchListener(cakeController);
    }

    public void goodbye(View button) {
        Log.i("button", "Goodbye");
    }
}
