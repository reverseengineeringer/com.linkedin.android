package com.linkedin.android.axle;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.crosspromo.fe.api.android.Promo;

final class SplashPromoViewHolder$2
  implements View.OnClickListener
{
  SplashPromoViewHolder$2(SplashPromoViewHolder paramSplashPromoViewHolder, Context paramContext, PromoModel paramPromoModel) {}
  
  public final void onClick(View paramView)
  {
    val$context.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(val$promoModel.promo.storeUrl)));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.SplashPromoViewHolder.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */