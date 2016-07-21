package com.linkedin.CrossPromoLib.utils;

import android.content.Context;
import android.view.View.OnClickListener;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.crosspromo.common.android.RichText;

public abstract interface Installation
{
  public abstract View.OnClickListener createPromptListener(Context paramContext, String paramString1, String paramString2, String paramString3, Runnable paramRunnable, NonMarketUrlRunnable paramNonMarketUrlRunnable);
  
  public abstract RichText getPromptText(Context paramContext, PromoModel paramPromoModel);
  
  public abstract boolean isAppInstalled(Context paramContext, String paramString);
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.utils.Installation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */