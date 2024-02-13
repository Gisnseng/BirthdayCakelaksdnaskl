// CakeController.java
package cs301.birthdaycake;

import android.util.Log;
import android.view.View;

public class CakeController implements View.OnClickListener {
    private CakeView cakeView;
    private CakeModel cakeModel;

    public CakeController(CakeView view) {
        this.cakeView = view;
        this.cakeModel = cakeView.getCakeModel();
    }

    @Override
    public void onClick(View view) {
        if (cakeModel.hasCandles && cakeModel.candlesLit) {
            cakeModel.candlesLit = false; // Blow out the candles
            cakeView.invalidate(); // Request a redraw of the CakeView
        }
        Log.d("cake", "click!");
    }
}
