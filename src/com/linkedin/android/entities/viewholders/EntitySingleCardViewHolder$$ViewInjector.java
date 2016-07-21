package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.makeramen.roundedimageview.RoundedImageView;

public class EntitySingleCardViewHolder$$ViewInjector<T extends EntitySingleCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    cardHeader = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755396, "field 'cardHeader'"), 2131755396, "field 'cardHeader'"));
    profileLayout = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755414, "field 'profileLayout'"), 2131755414, "field 'profileLayout'"));
    divider = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755416, "field 'divider'"), 2131755416, "field 'divider'"));
    peopleInCommonImage1 = ((RoundedImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755418, "field 'peopleInCommonImage1'"), 2131755418, "field 'peopleInCommonImage1'"));
    peopleInCommonCaption = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755419, "field 'peopleInCommonCaption'"), 2131755419, "field 'peopleInCommonCaption'"));
    peopleInCommonContainer = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755417, "field 'peopleInCommonContainer'"), 2131755417, "field 'peopleInCommonContainer'"));
    viewAllDivider = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755399, "field 'viewAllDivider'"), 2131755399, "field 'viewAllDivider'"));
    viewAllButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755420, "field 'viewAllButton'"), 2131755420, "field 'viewAllButton'"));
  }
  
  public void reset(T paramT)
  {
    cardHeader = null;
    profileLayout = null;
    divider = null;
    peopleInCommonImage1 = null;
    peopleInCommonCaption = null;
    peopleInCommonContainer = null;
    viewAllDivider = null;
    viewAllButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntitySingleCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */