package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    }

    public void goodbye(View button) {
        Log.i("button", "Goodbye");
    }
}
