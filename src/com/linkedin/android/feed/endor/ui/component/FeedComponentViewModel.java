package com.linkedin.android.feed.endor.ui.component;

import android.view.LayoutInflater;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.feed.viewmodels.models.FeedItemViewModel;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.viewmodel.ViewModel;

public abstract class FeedComponentViewModel<VIEW_HOLDER extends BaseFeedViewHolder, LAYOUT extends FeedComponentLayout<VIEW_HOLDER>>
  extends FeedItemViewModel<VIEW_HOLDER>
{
  public final LAYOUT layout;
  
  public FeedComponentViewModel(LAYOUT paramLAYOUT)
  {
    layout = paramLAYOUT;
  }
  
  public boolean handlesViewModelChanges()
  {
    return true;
  }
  
  public boolean isChangeableTo(ViewModel paramViewModel)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramViewModel instanceof FeedComponentViewModel))
    {
      FeedComponentViewModel localFeedComponentViewModel = (FeedComponentViewModel)paramViewModel;
      bool1 = bool2;
      if (super.isChangeableTo(paramViewModel))
      {
        bool1 = bool2;
        if (layout.getClass().equals(layout.getClass())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, VIEW_HOLDER paramVIEW_HOLDER)
  {
    layout.apply(paramVIEW_HOLDER);
  }
  
  @Deprecated
  public void onRecycleViewHolder(VIEW_HOLDER paramVIEW_HOLDER)
  {
    super.onRecycleViewHolder(paramVIEW_HOLDER);
  }
  
  public void onRestoreUpdateViewState(ViewState paramViewState) {}
  
  public void onSaveUpdateViewState(ViewState paramViewState) {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */