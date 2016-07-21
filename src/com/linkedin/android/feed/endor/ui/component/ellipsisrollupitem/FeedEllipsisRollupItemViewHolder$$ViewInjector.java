package com.linkedin.android.feed.endor.ui.component.ellipsisrollupitem;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.infra.ui.TintableImageButton;

public class FeedEllipsisRollupItemViewHolder$$ViewInjector<T extends FeedEllipsisRollupItemViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    ellipsisView = ((TintableImageButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755659, "field 'ellipsisView'"), 2131755659, "field 'ellipsisView'"));
  }
  
  public void reset(T paramT)
  {
    ellipsisView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.ellipsisrollupitem.FeedEllipsisRollupItemViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */