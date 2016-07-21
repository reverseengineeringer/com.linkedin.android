package com.linkedin.CrossPromoLib.api.PromoBase;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.linkedin.CrossPromoLib.api.PromoSource;
import com.linkedin.CrossPromoLib.utils.NonMarketUrlRunnable;

public abstract class OverlayPromo
  extends BasePromo
{
  public ViewGroup container;
  
  public OverlayPromo(PromoSource paramPromoSource)
  {
    super(paramPromoSource);
  }
  
  private Runnable createNextThenRemoveChildViews(final Runnable paramRunnable)
  {
    new Runnable()
    {
      public final void run()
      {
        try
        {
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          return;
        }
        finally
        {
          container.setVisibility(8);
          container.removeAllViews();
        }
      }
    };
  }
  
  public View.OnClickListener createOnClickDismissListener(View paramView, Runnable paramRunnable)
  {
    return super.createOnClickDismissListener(paramView, createNextThenRemoveChildViews(paramRunnable));
  }
  
  public View.OnClickListener createOnClickListener(Context paramContext, String paramString1, String paramString2, String paramString3, Runnable paramRunnable, NonMarketUrlRunnable paramNonMarketUrlRunnable)
  {
    return super.createOnClickListener(paramContext, paramString1, paramString2, paramString3, createNextThenRemoveChildViews(paramRunnable), paramNonMarketUrlRunnable);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.PromoBase.OverlayPromo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */