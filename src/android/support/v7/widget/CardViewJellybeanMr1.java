package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

final class CardViewJellybeanMr1
  extends CardViewEclairMr1
{
  public final void initStatic()
  {
    RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectDrawableWithShadow.RoundRectHelper()
    {
      public final void drawRoundRect(Canvas paramAnonymousCanvas, RectF paramAnonymousRectF, float paramAnonymousFloat, Paint paramAnonymousPaint)
      {
        paramAnonymousCanvas.drawRoundRect(paramAnonymousRectF, paramAnonymousFloat, paramAnonymousFloat, paramAnonymousPaint);
      }
    };
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.CardViewJellybeanMr1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */