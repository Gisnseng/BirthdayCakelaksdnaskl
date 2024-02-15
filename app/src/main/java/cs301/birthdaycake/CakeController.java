package cs301.birthdaycake;

import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private CakeView cakeView;
    private CakeModel cakeModel;

    public CakeController(CakeView view) {
        this.cakeView = view;
        this.cakeModel = cakeView.getCakeModel();
    }

    @Override
    public void onClick(View view) {
        // Check if candles are present and lit, then blow them out
        if (cakeModel.hasCandles && cakeModel.candlesLit) {
            cakeModel.candlesLit = false; // Blow out the candles
            cakeView.invalidate(); // Request a redraw of the CakeView
        }
        Log.d("cake", "click!");
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // Update the model based on the switch's state
        cakeModel.hasCandles = isChecked;
        cakeView.invalidate(); // Request a redraw of the CakeView to reflect the change
    }
}
