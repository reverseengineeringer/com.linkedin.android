package com.linkedin.CrossPromoLib.api.Promos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.linkedin.CrossPromoLib.R.id;
import com.linkedin.CrossPromoLib.R.layout;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo;
import com.linkedin.CrossPromoLib.api.PromoSource;
import com.linkedin.CrossPromoLib.models.PromoModel;

public final class BoxPromo
  extends BasePromo
{
  public BoxPromo(PromoSource paramPromoSource)
  {
    super(paramPromoSource);
  }
  
  protected final View initView(Context paramContext, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(R.layout.promo1, paramViewGroup, false);
    ImageView localImageView1 = (ImageView)paramViewGroup.findViewById(R.id.promo1_picture_container);
    ImageView localImageView2 = (ImageView)paramViewGroup.findViewById(R.id.promo1_icon_logo);
    TextView localTextView = (TextView)paramViewGroup.findViewById(R.id.promo1_title_text);
    Button localButton = (Button)paramViewGroup.findViewById(R.id.promo1_prompt_btn);
    PromoModel localPromoModel = getPromoModel();
    addBackgroundImage(localImageView1);
    addLogoImage(localImageView2);
    addTitleText(localTextView, localPromoModel);
    addPromptButton(localButton, localPromoModel, paramContext, createOnClickListener(paramContext, getDefaultRunnable(), null));
    return paramViewGroup;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.Promos.BoxPromo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */