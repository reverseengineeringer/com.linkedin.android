package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class MultiTileViewHolder$$ViewInjector<T extends MultiTileViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    header = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755396, "field 'header'"), 2131755396, "field 'header'"));
    tileRow = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755424, "field 'tileRow'"), 2131755424, "field 'tileRow'"));
    tileLeft = ((RelativeLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755540, "field 'tileLeft'"), 2131755540, "field 'tileLeft'"));
    tileRight = ((RelativeLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755541, "field 'tileRight'"), 2131755541, "field 'tileRight'"));
    viewAllButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755425, "field 'viewAllButton'"), 2131755425, "field 'viewAllButton'"));
  }
  
  public void reset(T paramT)
  {
    header = null;
    tileRow = null;
    tileLeft = null;
    tileRight = null;
    viewAllButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.MultiTileViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */