package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.entities.shared.AutofitTextButton;

public class EntityTopCardViewHolder$$ViewInjector<T extends EntityTopCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    coverView = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755554, "field 'coverView'"), 2131755554, "field 'coverView'"));
    iconView = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755562, "field 'iconView'"), 2131755562, "field 'iconView'"));
    titleView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755564, "field 'titleView'"), 2131755564, "field 'titleView'"));
    subtitle1View = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755565, "field 'subtitle1View'"), 2131755565, "field 'subtitle1View'"));
    subtitle2View = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755566, "field 'subtitle2View'"), 2131755566, "field 'subtitle2View'"));
    ctaButton = ((AutofitTextButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755572, "field 'ctaButton'"), 2131755572, "field 'ctaButton'"));
    ctaClickedButton = ((AutofitTextButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755573, "field 'ctaClickedButton'"), 2131755573, "field 'ctaClickedButton'"));
  }
  
  public void reset(T paramT)
  {
    coverView = null;
    iconView = null;
    titleView = null;
    subtitle1View = null;
    subtitle2View = null;
    ctaButton = null;
    ctaClickedButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntityTopCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */