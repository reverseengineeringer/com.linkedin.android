package com.linkedin.android.feed.endor.ui.component.header;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.TopBarComponent;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedHeaderViewModel
  extends FeedComponentViewModel<FeedHeaderViewHolder, FeedHeaderLayout>
  implements TopBarComponent
{
  public TrackingOnClickListener controlMenuListener;
  public TrackingOnClickListener headerClickListener;
  public CharSequence headerText;
  private boolean isTopBar;
  
  public FeedHeaderViewModel(FeedHeaderLayout paramFeedHeaderLayout, CharSequence paramCharSequence, TrackingOnClickListener paramTrackingOnClickListener)
  {
    super(paramFeedHeaderLayout);
    headerText = paramCharSequence;
    headerClickListener = paramTrackingOnClickListener;
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedHeaderViewHolder paramFeedHeaderViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedHeaderViewHolder);
    showDropdownIfNecessary(paramFeedHeaderViewHolder);
    setClickListeners(paramFeedHeaderViewHolder);
    if ((!TextUtils.isEmpty(headerText)) && (Util.getAppComponent(itemView.getContext()).i18NManager().isRtl())) {
      headerText = I18NManager.prependRightToLeftMarkerCharacter(headerText);
    }
    ViewUtils.setTextAndUpdateVisibility(text, headerText);
  }
  
  private void setClickListeners(FeedHeaderViewHolder paramFeedHeaderViewHolder)
  {
    if (headerClickListener != null)
    {
      container.setAddStatesFromChildren(true);
      container.setOnClickListener(headerClickListener);
      text.setOnClickListener(headerClickListener);
    }
  }
  
  private void showDropdownIfNecessary(FeedHeaderViewHolder paramFeedHeaderViewHolder)
  {
    if (isTopBar) {
      ViewUtils.setOnClickListenerAndUpdateVisibility(controlMenu, controlMenuListener);
    }
  }
  
  public final boolean canRenderControlDropdown()
  {
    return controlMenuListener != null;
  }
  
  public final ViewHolderCreator<FeedHeaderViewHolder> getCreator()
  {
    return FeedHeaderViewHolder.CREATOR;
  }
  
  public final void setIsTopBar(boolean paramBoolean)
  {
    isTopBar = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */