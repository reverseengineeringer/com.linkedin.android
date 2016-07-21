package com.linkedin.android.axle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo;
import com.linkedin.CrossPromoLib.api.PromoSource;
import com.linkedin.CrossPromoLib.models.types.ImageType;
import com.linkedin.CrossPromoLib.utils.PromoUtils;
import com.linkedin.android.infra.app.ViewPagerFragment;
import com.linkedin.crosspromo.fe.api.android.Bolton;
import com.linkedin.crosspromo.fe.api.android.Bolton.BoltOnUnion;
import com.linkedin.crosspromo.fe.api.android.Image;
import com.linkedin.crosspromo.fe.api.android.SubPromo;
import com.linkedin.crosspromo.fe.api.bolton.android.SocialProofBoltOn;
import java.util.Iterator;
import java.util.List;

public final class SplashPromoPagerFragment
  extends ViewPagerFragment
{
  boolean isFirstCard;
  SplashPromo promoTemplate;
  SubPromo subPromo;
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramViewGroup == null) {
      return null;
    }
    paramBundle = (RelativeLayout)paramLayoutInflater.inflate(2130968616, paramViewGroup, false);
    if ((subPromo.hasBoltons) && (!subPromo.boltons.isEmpty()) && (isFirstCard))
    {
      paramViewGroup = paramLayoutInflater.inflate(2130968615, paramBundle, false);
      SplashPromoScreenshotCardWithBoltonsViewHolder localSplashPromoScreenshotCardWithBoltonsViewHolder = new SplashPromoScreenshotCardWithBoltonsViewHolder(promoTemplate, subPromo, paramViewGroup);
      PromoUtils.addRichTextToSubPromoTextView(title, subPromo, "title");
      promoTemplate.addImageToSubPromoView(image, subPromo, ImageType.MAIN);
      Iterator localIterator = subPromo.boltons.iterator();
      Object localObject;
      do
      {
        do
        {
          paramLayoutInflater = paramViewGroup;
          if (!localIterator.hasNext()) {
            break;
          }
          paramLayoutInflater = nextboltOnUnion;
        } while ((paramLayoutInflater == null) || (socialProofBoltOnValue == null));
        localObject = socialProofBoltOnValue;
        PromoUtils.addText(boltonText, PromoUtils.getBoltonText((SocialProofBoltOn)localObject));
        paramLayoutInflater = facePile;
        localObject = profileImages;
      } while (localObject == null);
      int k = Math.min(5, ((List)localObject).size());
      LayoutInflater localLayoutInflater = LayoutInflater.from(paramLayoutInflater.getContext());
      int i = 0;
      int j = 0;
      label230:
      View localView;
      if (i < k)
      {
        localView = localLayoutInflater.inflate(2130968618, paramLayoutInflater, false);
        paramLayoutInflater.addView(localView, 0);
        promoTemplate.attachImageToImageViewWithFixedWidth((ImageView)localView, (Image)((List)localObject).get(i), 0);
        if (i != 0) {
          break label320;
        }
        SplashPromoScreenshotCardWithBoltonsViewHolder.setMarginStart$5359dc9a(localView);
      }
      label320:
      for (j = 0;; j = SplashPromoScreenshotCardWithBoltonsViewHolder.addMarginStart(localView, j))
      {
        int m = getLayoutParamswidth;
        i += 1;
        j = m + j;
        break label230;
        break;
      }
    }
    paramLayoutInflater = paramLayoutInflater.inflate(2130968614, paramBundle, false);
    paramViewGroup = new SplashPromoScreenshotCardViewHolder(promoTemplate, subPromo, paramLayoutInflater);
    PromoUtils.addRichTextToSubPromoTextView(title, subPromo, "title");
    promoTemplate.addImageToSubPromoView(image, subPromo, ImageType.MAIN);
    promoTemplate.doneLoadingImages();
    paramBundle.addView(paramLayoutInflater);
    return paramBundle;
  }
  
  public final String pageKey()
  {
    if (promoTemplate == null) {
      return "";
    }
    return promoTemplate.source.getPageKey();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.SplashPromoPagerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */