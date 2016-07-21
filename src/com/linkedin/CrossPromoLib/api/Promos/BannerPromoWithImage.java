package com.linkedin.CrossPromoLib.api.Promos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.linkedin.CrossPromoLib.R.id;
import com.linkedin.CrossPromoLib.R.layout;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo;
import com.linkedin.CrossPromoLib.api.PromoSource;

public final class BannerPromoWithImage
  extends BasePromo
{
  public BannerPromoWithImage(PromoSource paramPromoSource)
  {
    super(paramPromoSource);
  }
  
  protected final View initView(Context paramContext, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(R.layout.promo3, paramViewGroup, false);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(R.id.promo3_picture_container);
    addBackgroundImage(localImageView);
    localImageView.setOnClickListener(createOnClickListener(paramContext, getDefaultRunnable(), null));
    return paramViewGroup;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.Promos.BannerPromoWithImage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */