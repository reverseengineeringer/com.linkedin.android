package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.RelativeLayout;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class RowTilesViewHolder$$ViewInjector<T extends RowTilesViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    tileLeft = ((RelativeLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755540, "field 'tileLeft'"), 2131755540, "field 'tileLeft'"));
    tileRight = ((RelativeLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755541, "field 'tileRight'"), 2131755541, "field 'tileRight'"));
  }
  
  public void reset(T paramT)
  {
    tileLeft = null;
    tileRight = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.RowTilesViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */