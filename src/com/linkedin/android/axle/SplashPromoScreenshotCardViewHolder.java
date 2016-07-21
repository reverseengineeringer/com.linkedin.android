package com.linkedin.android.axle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.crosspromo.fe.api.android.SubPromo;

class SplashPromoScreenshotCardViewHolder
  extends BaseViewHolder
{
  @InjectView(2131755220)
  LiImageView image;
  private final LayoutInflater inflater;
  final SplashPromo promoTemplate;
  final SubPromo subPromo;
  @InjectView(2131755219)
  TextView title;
  
  SplashPromoScreenshotCardViewHolder(SplashPromo paramSplashPromo, SubPromo paramSubPromo, View paramView)
  {
    super(paramView);
    promoTemplate = paramSplashPromo;
    subPromo = paramSubPromo;
    inflater = LayoutInflater.from(paramView.getContext());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.SplashPromoScreenshotCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */