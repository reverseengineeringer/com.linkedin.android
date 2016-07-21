package com.linkedin.android.growth.abi;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import com.linkedin.android.infra.ui.TintableButton;

public class MainAbiResultFragment$$ViewInjector<T extends MainAbiResultFragment>
  extends AbiResultFragment..ViewInjector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    super.inject(paramFinder, paramT, paramObject);
    connectAllButton = ((TintableButton)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755942, null), 2131755942, "field 'connectAllButton'"));
    recyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755940, "field 'recyclerView'"), 2131755940, "field 'recyclerView'"));
    titleNumberOfContacts = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755939, "field 'titleNumberOfContacts'"), 2131755939, "field 'titleNumberOfContacts'"));
    toolbar = ((Toolbar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755468, "field 'toolbar'"), 2131755468, "field 'toolbar'"));
    searchOverlay = ((View)paramFinder.findRequiredView(paramObject, 2131755943, "field 'searchOverlay'"));
    navBack = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755935, "field 'navBack'"), 2131755935, "field 'navBack'"));
    navNext = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755936, "field 'navNext'"), 2131755936, "field 'navNext'"));
    navNextText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755937, "field 'navNextText'"), 2131755937, "field 'navNextText'"));
    navNextArrow = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755938, "field 'navNextArrow'"), 2131755938, "field 'navNextArrow'"));
    valueProp = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755955, "field 'valueProp'"), 2131755955, "field 'valueProp'"));
    topCardContainer = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755948, "field 'topCardContainer'"), 2131755948, "field 'topCardContainer'"));
    topCard = ((RelativeLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131758309, "field 'topCard'"), 2131758309, "field 'topCard'"));
  }
  
  public void reset(T paramT)
  {
    super.reset(paramT);
    connectAllButton = null;
    recyclerView = null;
    titleNumberOfContacts = null;
    toolbar = null;
    searchOverlay = null;
    navBack = null;
    navNext = null;
    navNextText = null;
    navNextArrow = null;
    valueProp = null;
    topCardContainer = null;
    topCard = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.MainAbiResultFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */