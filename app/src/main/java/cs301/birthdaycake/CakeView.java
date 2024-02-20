package cs301.birthdaycake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class CakeView extends SurfaceView {
    private CakeModel cakeModel;

    /* Paint objects for drawing the various components of the cake */
    private Paint cakePaint = new Paint();
    private Paint frostingPaint = new Paint();
    private Paint candlePaint = new Paint();
    private Paint outerFlamePaint = new Paint();
    private Paint innerFlamePaint = new Paint();
    private Paint wickPaint = new Paint();

    /* Constants for the cake drawing */
    public static final float cakeTop = 400.0f;
    public static final float cakeLeft = 100.0f;
    public static final float cakeWidth = 1200.0f;
    public static final float layerHeight = 200.0f;
    public static final float frostHeight = 50.0f;
    public static final float candleHeight = 300.0f;
    public static final float candleWidth = 40.0f;
    public static final float wickHeight = 30.0f;
    public static final float wickWidth = 6.0f;
    public static final float outerFlameRadius = 50.0f;
    public static final float innerFlameRadius = 25.0f;

    public CakeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        cakeModel = new CakeModel();

        setWillNotDraw(false); // This call is essential to ensure onDraw() is called

        // Setup our palette
        cakePaint.setColor(0xFFFFD700);  // Gold
        frostingPaint.setColor(0xFFFFFACD);  // Lemon chiffon
        candlePaint.setColor(0xFF32CD32);  // Lime green
        outerFlamePaint.setColor(0xFFFFD700);  // Gold
        innerFlamePaint.setColor(0xFF00A5FF);  // Orange
        wickPaint.setColor(Color.BLACK);  // Black

        setBackgroundColor(Color.WHITE);  // Set the background to white
    }

    public CakeModel getCakeModel() {
        return cakeModel;
    }

    public void drawCandle(Canvas canvas, float left, float bottom) {
        if (cakeModel.hasCandles) {
            // Draw the candle body
            canvas.drawRect(left, bottom - candleHeight, left + candleWidth, bottom, candlePaint);

            if (cakeModel.candlesLit) {
                // Draw the outer flame
                float flameCenterX = left + candleWidth / 2;
                float flameCenterY = bottom - wickHeight - candleHeight - outerFlameRadius / 3;
                canvas.drawOval(flameCenterX, flameCenterY, flameCenterX + outerFlameRadius + 30, flameCenterY + outerFlameRadius, outerFlamePaint);

                // Draw the inner flame
                flameCenterY += outerFlameRadius / 3;
                canvas.drawOval(flameCenterX, flameCenterY, flameCenterX + innerFlameRadius + 30, flameCenterY + innerFlameRadius, innerFlamePaint);
            }

            // Draw the wick
            float wickLeft = left + candleWidth / 2 - wickWidth / 2;
            float wickTop = bottom - wickHeight - candleHeight;
            canvas.drawRect(wickLeft, wickTop, wickLeft + wickWidth, wickTop + wickHeight, wickPaint);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw the cake
        float top = cakeTop;
        float bottom = cakeTop + layerHeight;
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, cakePaint);
        top = bottom;
        bottom += frostHeight;
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, frostingPaint);

        // Calculate the positions for candles based on the current number of candles
        for (int i = 0; i < cakeModel.numCandles; i++) {
            float candleGap = cakeWidth / (cakeModel.numCandles + 1);
            float candleLeft = cakeLeft + candleGap * (i + 1) - candleWidth / 2;
            drawCandle(canvas, candleLeft, cakeTop);
        }
    }
}
