package cs301.birthdaycake;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import java.util.ArrayList;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
    private CakeView cakeView;
    private CakeModel cakeModel;

    public CakeController(CakeView view) {
        this.cakeView = view;
        this.cakeModel = cakeView.getCakeModel();
    }
//
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

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // Update the number of candles based on the SeekBar's progress
        cakeModel.numCandles = progress;
        cakeView.invalidate(); // Redraw the CakeView to show the updated number of candles
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // Do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // Do nothing
    }

    @Override
    public boolean onTouch(View v, MotionEvent m)
    {
        cakeModel.balloon = true;
        cakeModel.touch = true;
        float x = m.getX();
        float y = m.getY();
        cakeModel.balloonX = x;
        cakeModel.balloonY = y;

        cakeModel.touch = true;
        cakeModel.touchX = x;
        cakeModel.touchY = y;
        cakeView.invalidate();
        return true;
    }
}
