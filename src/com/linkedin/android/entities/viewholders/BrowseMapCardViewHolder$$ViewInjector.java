package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.entities.cards.BrowseMapTileView;

public class BrowseMapCardViewHolder$$ViewInjector<T extends BrowseMapCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    header = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755402, "field 'header'"), 2131755402, "field 'header'"));
    browseMapTileView = ((BrowseMapTileView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755403, "field 'browseMapTileView'"), 2131755403, "field 'browseMapTileView'"));
  }
  
  public void reset(T paramT)
  {
    header = null;
    browseMapTileView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.BrowseMapCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */