package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.makeramen.roundedimageview.RoundedImageView;

public class EntityInsightViewHolder$$ViewInjector<T extends EntityInsightViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    container = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755503, "field 'container'"), 2131755503, "field 'container'"));
    image = ((RoundedImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755504, "field 'image'"), 2131755504, "field 'image'"));
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755505, "field 'title'"), 2131755505, "field 'title'"));
  }
  
  public void reset(T paramT)
  {
    container = null;
    image = null;
    title = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntityInsightViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */