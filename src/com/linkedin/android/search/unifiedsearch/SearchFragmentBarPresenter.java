package com.linkedin.android.search.unifiedsearch;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.ImageButton;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.shared.JellyBeanUtils;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.search.shared.SearchUtils;
import javax.inject.Inject;

public final class SearchFragmentBarPresenter
{
  @Inject
  ActivityComponent activityComponent;
  @Inject
  KeyboardUtil keyboardUtil;
  @Inject
  SearchUtils searchUtils;
  
  public final void updateFacetButton(ImageButton paramImageButton, boolean paramBoolean)
  {
    Context localContext = activityComponent.appContext();
    if (paramBoolean)
    {
      paramImageButton.setContentDescription(localContext.getString(2131233539));
      paramImageButton.setColorFilter(ContextCompat.getColor(localContext, 2131624058));
      JellyBeanUtils.setBackground(paramImageButton, ContextCompat.getDrawable(localContext, 2130838750));
      return;
    }
    paramImageButton.setContentDescription(localContext.getString(2131233538));
    paramImageButton.setColorFilter(ContextCompat.getColor(localContext, 2131623966));
    paramImageButton.setBackgroundColor(ContextCompat.getColor(localContext, 2131624051));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.unifiedsearch.SearchFragmentBarPresenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */