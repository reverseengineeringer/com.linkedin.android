package com.linkedin.CrossPromoLib.api.Promos;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.linkedin.CrossPromoLib.R.color;
import com.linkedin.CrossPromoLib.R.id;
import com.linkedin.CrossPromoLib.R.layout;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo;
import com.linkedin.CrossPromoLib.api.PromoSource;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.crosspromo.fe.api.android.Image;
import java.util.List;

public final class ImageRollupPromo
  extends BasePromo
{
  public ImageRollupPromo(PromoSource paramPromoSource)
  {
    super(paramPromoSource);
  }
  
  protected final View initView(Context paramContext, ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(paramContext).inflate(R.layout.promo6, paramViewGroup, false);
    paramViewGroup = (TextView)localView.findViewById(R.id.promo6_title_text);
    Object localObject1 = (TextView)localView.findViewById(R.id.promo6_detail_text);
    Object localObject2 = getPromoModel();
    addTitleText(paramViewGroup, (PromoModel)localObject2);
    addDetailText((TextView)localObject1, (PromoModel)localObject2);
    setViewVisibilityFromDetailView((View)localObject1, (PromoModel)localObject2);
    List localList = ((PromoModel)localObject2).getRollupImages();
    if ((localView == null) || (localList.size() == 0)) {}
    ImageView localImageView1;
    ImageView localImageView2;
    ImageView localImageView3;
    ImageView localImageView4;
    int i;
    Object localObject3;
    do
    {
      localView.setOnClickListener(createOnClickListener(paramContext, getDefaultRunnable(), null));
      return localView;
      localObject1 = (ImageView)localView.findViewById(R.id.image_rollup_big0);
      localImageView1 = (ImageView)localView.findViewById(R.id.image_rollup_big1);
      localImageView2 = (ImageView)localView.findViewById(R.id.image_rollup_med);
      localImageView3 = (ImageView)localView.findViewById(R.id.image_rollup_small0);
      localImageView4 = (ImageView)localView.findViewById(R.id.image_rollup_small1);
      paramViewGroup = localView.getResources();
      i = getDisplayMetricswidthPixels - 20 >> 3;
      int j = i * 3;
      int k = i * 2;
      localObject2 = new LinearLayout.LayoutParams(j, j);
      localObject3 = new LinearLayout.LayoutParams(k, k);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localImageView3.setLayoutParams(localLayoutParams);
      localImageView4.setLayoutParams(localLayoutParams);
      ((ImageView)localObject1).setBackgroundColor(paramViewGroup.getColor(R.color.rollup_big0_bg));
      localImageView1.setBackgroundColor(paramViewGroup.getColor(R.color.rollup_big1_bg));
      localImageView2.setBackgroundColor(paramViewGroup.getColor(R.color.rollup_med_bg));
      localImageView3.setBackgroundColor(paramViewGroup.getColor(R.color.rollup_small0_bg));
      localImageView4.setBackgroundColor(paramViewGroup.getColor(R.color.rollup_small1_bg));
      i = 0;
    } while (i >= localList.size());
    switch (i)
    {
    default: 
      paramViewGroup = (ViewGroup)localObject1;
      label383:
      localObject3 = (Image)localList.get(i);
      if (localObject3 != null) {
        break;
      }
    }
    for (localObject2 = null;; localObject2 = url)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        attachImageToImageViewWithFixedWidth(paramViewGroup, (Image)localObject3, 0);
      }
      i += 1;
      break;
      paramViewGroup = (ViewGroup)localObject1;
      break label383;
      paramViewGroup = localImageView1;
      break label383;
      paramViewGroup = localImageView2;
      break label383;
      paramViewGroup = localImageView3;
      break label383;
      paramViewGroup = localImageView4;
      break label383;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.Promos.ImageRollupPromo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */