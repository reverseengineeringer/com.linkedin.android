package android.support.design.widget;

import android.graphics.Outline;

class CircularBorderDrawableLollipop
  extends CircularBorderDrawable
{
  public void getOutline(Outline paramOutline)
  {
    copyBounds(mRect);
    paramOutline.setOval(mRect);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.CircularBorderDrawableLollipop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */