package com.linkedin.android.axle;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.crosspromo.fe.api.android.SubPromo;

class SplashPromoScreenshotCardWithBoltonsViewHolder
  extends BaseViewHolder
{
  @InjectView(2131755224)
  TextView boltonText;
  @InjectView(2131755223)
  RelativeLayout facePile;
  @InjectView(2131755222)
  LiImageView image;
  final SplashPromo promoTemplate;
  final SubPromo subPromo;
  @InjectView(2131755221)
  TextView title;
  
  SplashPromoScreenshotCardWithBoltonsViewHolder(SplashPromo paramSplashPromo, SubPromo paramSubPromo, View paramView)
  {
    super(paramView);
    promoTemplate = paramSplashPromo;
    subPromo = paramSubPromo;
  }
  
  static int addMarginStart(View paramView, int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    if (Build.VERSION.SDK_INT >= 17) {}
    for (int i = localMarginLayoutParams.getMarginStart();; i = leftMargin)
    {
      paramInt = i + paramInt;
      setMarginStart(localMarginLayoutParams, paramInt);
      paramView.setLayoutParams(localMarginLayoutParams);
      return paramInt;
    }
  }
  
  private static void setMarginStart(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramMarginLayoutParams.setMarginStart(paramInt);
      return;
    }
    paramMarginLayoutParams.setMargins(paramInt, topMargin, rightMargin, bottomMargin);
  }
  
  static void setMarginStart$5359dc9a(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    setMarginStart(localMarginLayoutParams, 0);
    paramView.setLayoutParams(localMarginLayoutParams);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.SplashPromoScreenshotCardWithBoltonsViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */