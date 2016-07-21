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
import com.linkedin.CrossPromoLib.models.types.TextType;
import com.linkedin.CrossPromoLib.utils.PromoUtils;

public final class BannerPromoWithIcon
  extends BasePromo
{
  public BannerPromoWithIcon(PromoSource paramPromoSource)
  {
    super(paramPromoSource);
  }
  
  protected final View initView(Context paramContext, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(R.layout.promo2, paramViewGroup, false);
    ImageView localImageView1 = (ImageView)paramViewGroup.findViewById(R.id.promo2_picture_container);
    ImageView localImageView2 = (ImageView)paramViewGroup.findViewById(R.id.promo2_icon_logo);
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(R.id.promo2_title_text);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(R.id.promo2_text_prompt);
    View localView = paramViewGroup.findViewById(R.id.promo2_text_divider_line);
    PromoModel localPromoModel = getPromoModel();
    addBackgroundImage(localImageView1);
    localImageView1.setOnClickListener(createOnClickListener(paramContext, getDefaultRunnable(), null));
    addLogoImage(localImageView2);
    addTitleText(localTextView1, localPromoModel);
    PromoUtils.addRichTextToTextView(localTextView2, localPromoModel, TextType.Prompt, paramContext);
    setViewVisibilityFromRichText(localView, localPromoModel, paramContext, TextType.Prompt);
    return paramViewGroup;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.Promos.BannerPromoWithIcon
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */