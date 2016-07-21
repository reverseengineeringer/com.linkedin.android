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

public final class BannerPromoWithPanelIcon
  extends BasePromo
{
  public BannerPromoWithPanelIcon(PromoSource paramPromoSource)
  {
    super(paramPromoSource);
  }
  
  protected final View initView(Context paramContext, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(R.layout.promo4, paramViewGroup, false);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(R.id.promo4_icon_logo);
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(R.id.promo4_title_text);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(R.id.promo4_detail_text);
    View localView = paramViewGroup.findViewById(R.id.promo4_go_caret);
    PromoModel localPromoModel = getPromoModel();
    addLogoImage(localImageView);
    addTitleText(localTextView1, localPromoModel);
    addDetailText(localTextView2, localPromoModel);
    setViewVisibilityFromDetailView(localTextView2, localPromoModel);
    paramContext = createOnClickListener(paramContext, getDefaultRunnable(), null);
    paramViewGroup.setOnClickListener(paramContext);
    localView.setOnClickListener(paramContext);
    return paramViewGroup;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.Promos.BannerPromoWithPanelIcon
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */