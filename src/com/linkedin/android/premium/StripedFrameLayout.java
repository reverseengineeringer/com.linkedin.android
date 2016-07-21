package com.linkedin.android.premium;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.linkedin.android.R.styleable;
import com.linkedin.android.infra.shared.KitKatUtils;
import java.util.concurrent.TimeUnit;

public class StripedFrameLayout
  extends FrameLayout
{
  private static final int DEFAULT_COLOR = Color.argb(127, 255, 255, 255);
  private Bitmap composite;
  private boolean debug;
  private Canvas intoComposite;
  private PointF position0;
  private PointF position1;
  private Paint stripe;
  public final ObjectAnimator stripeAnimator;
  private RectF stripeBounds;
  private int stripeColor;
  private float stripeDirection;
  private float stripePosition;
  private float stripeSize;
  private float stripeSpacing;
  private PorterDuff.Mode stripeXferMode = PorterDuff.Mode.SRC_ATOP;
  
  public StripedFrameLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public StripedFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StripedFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.StripedFrameLayout, 0, 0);
    try
    {
      debug = paramContext.getBoolean(2, false);
      stripeColor = paramContext.getColor(1, DEFAULT_COLOR);
      stripeDirection = paramContext.getInt(3, -20);
      stripePosition = paramContext.getFraction(5, 1, 1, 0.0F);
      stripeSize = paramContext.getDimension(6, 100.0F);
      if (stripeSize < 0.0F) {
        throw new IllegalArgumentException("stripeSize " + stripeSize);
      }
    }
    finally
    {
      paramContext.recycle();
    }
    stripeSpacing = paramContext.getFraction(7, 1, 1, 1.0F);
    if (stripeSpacing < 0.0F) {
      throw new IllegalArgumentException("stripeSpacing " + stripeSpacing);
    }
    paramAttributeSet = paramContext.getString(8);
    if (paramAttributeSet != null) {
      stripeXferMode = PorterDuff.Mode.valueOf(paramAttributeSet);
    }
    stripeAnimator = ObjectAnimator.ofFloat(this, "stripePosition", new float[] { 0.0F, 1.0F });
    stripeAnimator.setDuration(Math.round(TimeUnit.SECONDS.toMillis(1L) * paramContext.getFloat(4, 2.0F)));
    stripeAnimator.setInterpolator(new LinearInterpolator());
    stripeAnimator.setRepeatCount(-1);
    stripeAnimator.setRepeatMode(1);
    if (paramContext.getBoolean(0, false)) {
      stripeAnimator.start();
    }
    paramContext.recycle();
  }
  
  private static void drawOutline(Canvas paramCanvas, Paint paramPaint, RectF paramRectF)
  {
    paramCanvas.drawLines(new float[] { left, top, right, top, right, top, right, bottom, right, bottom, left, bottom, left, bottom, left, top }, paramPaint);
  }
  
  private void drawStripes(Canvas paramCanvas)
  {
    float f5 = stripePosition % 1.0F;
    float f7 = position1.x - position0.x;
    float f6 = position1.y - position0.y;
    float f3 = position0.x + f5 * f7;
    float f4 = position0.y + f5 * f6;
    float f1 = f3;
    float f2 = f4;
    if (debug)
    {
      paramCanvas.save();
      paramCanvas.scale(0.5F, 0.5F);
      paramCanvas.translate(getWidth() * 0.5F, getHeight() * 0.5F);
      f2 = f4;
      f1 = f3;
    }
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.translate(f1, f2);
      paramCanvas.drawRect(stripeBounds.left, stripeBounds.top, stripeBounds.right, stripeBounds.bottom, stripe);
      paramCanvas.restore();
      f1 += f7;
      f2 += f6;
      Object localObject = stripeBounds;
      if ((left + f1 < getWidth()) && (top + f2 < getHeight()) && (right + f1 > 0.0F) && (bottom + f2 > 0.0F)) {}
      for (int i = 1; i == 0; i = 0)
      {
        if (debug)
        {
          localObject = new Paint();
          ((Paint)localObject).setColor(-65536);
          paramCanvas.drawCircle(position0.x, position0.y, 6.0F, (Paint)localObject);
          paramCanvas.drawCircle(position1.x, position1.y, 6.0F, (Paint)localObject);
          ((Paint)localObject).setStrokeWidth(2.0F);
          drawOutline(paramCanvas, (Paint)localObject, new RectF(0.0F, 0.0F, getWidth(), getHeight()));
          ((Paint)localObject).setStrokeWidth(4.0F);
          ((Paint)localObject).setPathEffect(new DashPathEffect(new float[] { 12.0F, 12.0F }, 0.0F));
          RectF localRectF = stripeBounds;
          f1 = position0.x + f5 * f7;
          f2 = position0.y + f5 * f6;
          drawOutline(paramCanvas, (Paint)localObject, new RectF(left + f1, top + f2, f1 + right, bottom + f2));
          paramCanvas.restore();
        }
        return;
      }
    }
  }
  
  private PointF mirrorPosition(PointF paramPointF, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramPointF;
    case 1: 
      return new PointF(getWidth() - x, y);
    case 2: 
      return new PointF(getWidth() - x, getHeight() - y);
    }
    return new PointF(x, getHeight() - y);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((stripeSize <= 0.0F) || ((stripePosition == 0.0F) && (stripeSpacing >= 1.0F)) || (getHeight() <= 0) || (getWidth() <= 0))
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    if (composite == null)
    {
      composite = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
      intoComposite = new Canvas(composite);
    }
    Paint localPaint;
    float f2;
    float f1;
    int i;
    if (stripe == null)
    {
      localPaint = new Paint();
      localPaint.setDither(true);
      f2 = stripeDirection % 360.0F;
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = f2 + 360.0F;
      }
      i = (int)Math.floor(f1 / 90.0F);
      f2 = f1 % 90.0F;
      if (i % 2 != 1) {
        break label1005;
      }
      f2 = 90.0F - f2;
    }
    label328:
    label356:
    label428:
    label670:
    label1005:
    for (;;)
    {
      float f3;
      float f4;
      double d1;
      double d2;
      Object localObject1;
      Object localObject2;
      if (f2 > 85.0F)
      {
        f1 = Float.POSITIVE_INFINITY;
        f3 = getWidth();
        f4 = getHeight();
        if (f1 == Float.POSITIVE_INFINITY) {
          break label670;
        }
        stripeBounds = new RectF(-((float)(stripeSize / Math.cos(Math.toRadians(f2))) + f4 * f1), -f4, 0.0F, 0.0F);
        f2 = stripeSpacing;
        position1 = new PointF((f3 + stripeBounds.width()) * f2, f4);
        d1 = stripeSize;
        d2 = f1;
        f2 = (float)Math.sqrt(d1 * d1 / (d2 * d2 + 1.0D));
        localObject1 = new PointF(-f2, f1 * f2);
        switch (i)
        {
        default: 
          position0 = mirrorPosition(new PointF(0.0F, getHeight()), i);
          position1 = mirrorPosition(position1, i);
          localObject2 = stripeBounds;
          switch (i)
          {
          default: 
            stripeBounds = ((RectF)localObject2);
            localObject2 = stripeXferMode;
            i = stripeColor;
            switch (StripedFrameLayout.1.$SwitchMap$android$graphics$PorterDuff$Mode[localObject2.ordinal()])
            {
            default: 
              i = Color.argb(0, Color.red(i), Color.green(i), Color.blue(i));
            }
            break;
          }
          break;
        }
      }
      for (;;)
      {
        f1 = x;
        f2 = y;
        int j = stripeColor;
        localObject1 = Shader.TileMode.CLAMP;
        localPaint.setShader(new LinearGradient(0.0F, 0.0F, f1, f2, new int[] { i, j, i }, null, (Shader.TileMode)localObject1));
        localPaint.setXfermode(new PorterDuffXfermode(stripeXferMode));
        stripe = localPaint;
        super.dispatchDraw(intoComposite);
        drawStripes(intoComposite);
        paramCanvas.drawBitmap(composite, 0.0F, 0.0F, null);
        return;
        f3 = (float)Math.tan(Math.toRadians(f2));
        f1 = f3;
        if (getHeight() * f3 <= getWidth()) {
          break;
        }
        f1 = Float.POSITIVE_INFINITY;
        break;
        f1 = (float)Math.tan(Math.toRadians(90.0F - f2));
        stripeBounds = new RectF(0.0F, 0.0F, f3, (float)(stripeSize / Math.sin(Math.toRadians(f2))) + f3 * f1);
        position1 = new PointF(0.0F, f4 - stripeSpacing * (stripeBounds.height() + f4));
        d1 = stripeSize;
        d2 = f1;
        f2 = (float)Math.sqrt(d1 * d1 / (d2 * d2 + 1.0D));
        localObject1 = new PointF(-f1 * f2, f2);
        break label328;
        localObject1 = new PointF(-x, y);
        break label356;
        localObject1 = new PointF(-x, -y);
        break label356;
        localObject1 = new PointF(x, -y);
        break label356;
        localObject2 = new RectF(-right, top, -left, bottom);
        break label428;
        localObject2 = new RectF(-right, -bottom, -left, -top);
        break label428;
        localObject2 = new RectF(left, -bottom, right, -top);
        break label428;
        i = Color.argb(0, 255, 255, 255);
        continue;
        i = 0;
        continue;
        i = -1;
      }
    }
  }
  
  public ObjectAnimator getStripeAnimator()
  {
    return stripeAnimator;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    composite = null;
    stripe = null;
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setDebug(boolean paramBoolean)
  {
    if (debug != paramBoolean)
    {
      debug = paramBoolean;
      invalidate();
    }
  }
  
  public void setStripeColor(int paramInt)
  {
    if (stripeColor != paramInt)
    {
      stripeColor = paramInt;
      stripe = null;
      invalidate();
    }
  }
  
  public void setStripeDirection(float paramFloat)
  {
    if (stripeDirection != paramFloat)
    {
      stripeDirection = paramFloat;
      stripe = null;
      invalidate();
    }
  }
  
  public void setStripePosition(float paramFloat)
  {
    if (stripePosition != paramFloat % 1.0F)
    {
      stripePosition = (paramFloat % 1.0F);
      invalidate();
    }
  }
  
  public void setStripeSize(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("stripeSize " + paramFloat);
    }
    if (stripeSize != paramFloat)
    {
      stripeSize = paramFloat;
      stripe = null;
      invalidate();
    }
  }
  
  public void setStripeSpacing(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("stripeSpacing " + paramFloat);
    }
    if (stripeSpacing != paramFloat)
    {
      stripeSpacing = paramFloat;
      stripe = null;
      invalidate();
    }
  }
  
  public void setStripeXferMode(PorterDuff.Mode paramMode)
  {
    if (stripeXferMode != paramMode)
    {
      stripeXferMode = paramMode;
      stripe = null;
      invalidate();
    }
  }
  
  public final void startStripeAnimator()
  {
    if (!KitKatUtils.isRunningAndNotPaused(stripeAnimator)) {
      KitKatUtils.resumeOrStart(stripeAnimator);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.StripedFrameLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */