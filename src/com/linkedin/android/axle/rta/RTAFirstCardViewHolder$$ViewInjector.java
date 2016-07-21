package com.linkedin.android.axle.rta;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class RTAFirstCardViewHolder$$ViewInjector<T extends RTAFirstCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    cancelButton = ((ImageButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755205, "field 'cancelButton'"), 2131755205, "field 'cancelButton'"));
    cancel = ((RelativeLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755204, "field 'cancel'"), 2131755204, "field 'cancel'"));
    icon = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755200, "field 'icon'"), 2131755200, "field 'icon'"));
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755201, "field 'title'"), 2131755201, "field 'title'"));
    leftButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755202, "field 'leftButton'"), 2131755202, "field 'leftButton'"));
    rightButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755203, "field 'rightButton'"), 2131755203, "field 'rightButton'"));
  }
  
  public void reset(T paramT)
  {
    cancelButton = null;
    cancel = null;
    icon = null;
    title = null;
    leftButton = null;
    rightButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RTAFirstCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */