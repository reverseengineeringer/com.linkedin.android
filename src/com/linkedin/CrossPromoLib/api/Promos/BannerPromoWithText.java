package com.linkedin.CrossPromoLib.api.Promos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.linkedin.CrossPromoLib.R.id;
import com.linkedin.CrossPromoLib.R.layout;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo;
import com.linkedin.CrossPromoLib.api.PromoSource;
import com.linkedin.CrossPromoLib.models.PromoModel;

public final class BannerPromoWithText
  extends BasePromo
{
  public BannerPromoWithText(PromoSource paramPromoSource)
  {
    super(paramPromoSource);
  }
  
  protected final View initView(Context paramContext, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(R.layout.promo5, paramViewGroup, false);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(R.id.promo5_picture_container);
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(R.id.promo5_title_text);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(R.id.promo5_detail_text);
    PromoModel localPromoModel = getPromoModel();
    addBackgroundImage(localImageView);
    addTitleText(localTextView1, localPromoModel);
    addDetailText(localTextView2, localPromoModel);
    paramViewGroup.setOnClickListener(createOnClickListener(paramContext, getDefaultRunnable(), null));
    return paramViewGroup;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.Promos.BannerPromoWithText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */