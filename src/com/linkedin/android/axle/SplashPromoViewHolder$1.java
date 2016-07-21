package com.linkedin.android.axle;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;

final class SplashPromoViewHolder$1
  implements View.OnClickListener
{
  SplashPromoViewHolder$1(SplashPromoViewHolder paramSplashPromoViewHolder, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent("android.settings.ADD_ACCOUNT_SETTINGS").setFlags(268435456);
    if (Build.VERSION.SDK_INT >= 18) {
      paramView.putExtra("account_types", new String[] { "com.google" });
    }
    val$context.startActivity(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.SplashPromoViewHolder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */