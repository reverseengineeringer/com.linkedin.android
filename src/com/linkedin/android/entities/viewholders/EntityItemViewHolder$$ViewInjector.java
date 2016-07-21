package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.makeramen.roundedimageview.RoundedImageView;

public class EntityItemViewHolder$$ViewInjector<T extends EntityItemViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    image = ((RoundedImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755489, "field 'image'"), 2131755489, "field 'image'"));
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755492, "field 'title'"), 2131755492, "field 'title'"));
    superTitle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755491, "field 'superTitle'"), 2131755491, "field 'superTitle'"));
    subtitle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755493, "field 'subtitle'"), 2131755493, "field 'subtitle'"));
    subtitle2 = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755494, "field 'subtitle2'"), 2131755494, "field 'subtitle2'"));
    badge = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755497, "field 'badge'"), 2131755497, "field 'badge'"));
    newBadge = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755498, "field 'newBadge'"), 2131755498, "field 'newBadge'"));
    footerTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755496, "field 'footerTextView'"), 2131755496, "field 'footerTextView'"));
    ctaButton = ((ImageButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755499, "field 'ctaButton'"), 2131755499, "field 'ctaButton'"));
    ctaClickedButton = ((ImageButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755500, "field 'ctaClickedButton'"), 2131755500, "field 'ctaClickedButton'"));
    footer = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755495, "field 'footer'"), 2131755495, "field 'footer'"));
  }
  
  public void reset(T paramT)
  {
    image = null;
    title = null;
    superTitle = null;
    subtitle = null;
    subtitle2 = null;
    badge = null;
    newBadge = null;
    footerTextView = null;
    ctaButton = null;
    ctaClickedButton = null;
    footer = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntityItemViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */