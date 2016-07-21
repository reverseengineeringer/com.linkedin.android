package com.linkedin.android.entities.viewmodels.cards;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.linkedin.android.entities.viewholders.EntityListCardViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.ArrayList;
import java.util.List;

public final class EntityListCardViewModel
  extends EntityBaseCardViewModel<EntityListCardViewHolder>
{
  public int entityListCardMaxRows;
  public boolean hideDividerAndUpdateHeaderPadding;
  public boolean isBrowseMap;
  public final List<ViewModel> items = new ArrayList();
  public boolean useTextDivider;
  public TrackingClosure<Void, Void> viewAllClosure;
  public String viewAllText;
  
  public final ViewHolderCreator<EntityListCardViewHolder> getCreator()
  {
    if (isBrowseMap) {
      return EntityListCardViewHolder.BROWSE_MAP_CREATOR;
    }
    return EntityListCardViewHolder.CARD_CREATOR;
  }
  
  public final void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, EntityListCardViewHolder paramEntityListCardViewHolder)
  {
    ViewUtils.setTextAndUpdateVisibility(header, header);
    int i = header.getPaddingLeft();
    int j = header.getPaddingTop();
    int k = header.getPaddingRight();
    LinearLayout localLinearLayout;
    Object localObject;
    if (hideDividerAndUpdateHeaderPadding)
    {
      container.setShowDividers(0);
      int m = header.getResources().getDimensionPixelOffset(2131492993);
      header.setPadding(i, j, k, m);
      localLinearLayout = container;
      localObject = paramLayoutInflater.getContext();
      if (!useTextDivider) {
        break label268;
      }
    }
    label268:
    for (i = 2130837786;; i = 2130837784)
    {
      localLinearLayout.setDividerDrawable(ContextCompat.getDrawable((Context)localObject, i));
      if (entityListCardMaxRows == 0)
      {
        paramLayoutInflater.getContext();
        Util.safeThrow$7a8b4789(new RuntimeException("entityListCardMaxRows is mandatory to set"));
      }
      localLinearLayout = container;
      i = 0;
      while ((i < items.size()) && (i < entityListCardMaxRows))
      {
        localObject = (ViewModel)items.get(i);
        View localView = paramLayoutInflater.inflate(((ViewModel)localObject).getCreator().getLayoutId(), localLinearLayout, false);
        ((ViewModel)localObject).onBindViewHolder(paramLayoutInflater, paramMediaCenter, ((ViewModel)localObject).getCreator().createViewHolder(localView));
        localLinearLayout.addView(localView);
        i += 1;
      }
      container.setShowDividers(2);
      header.setPadding(i, j, k, 0);
      break;
    }
    if (viewAllClosure != null)
    {
      paramLayoutInflater = viewAllButton;
      ViewUtils.setTextAndUpdateVisibility(paramLayoutInflater, viewAllText);
      paramLayoutInflater.setOnClickListener(new TrackingOnClickListener(viewAllClosure.tracker, viewAllClosure.controlName, new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          viewAllClosure.apply(null);
        }
      });
      divider.setVisibility(0);
    }
  }
  
  public final void onRecycleViewHolder(EntityListCardViewHolder paramEntityListCardViewHolder)
  {
    container.removeAllViews();
    viewAllButton.setVisibility(8);
    viewAllButton.setOnClickListener(null);
    super.onRecycleViewHolder(paramEntityListCardViewHolder);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.cards.EntityListCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */