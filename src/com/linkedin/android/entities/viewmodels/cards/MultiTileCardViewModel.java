package com.linkedin.android.entities.viewmodels.cards;

import android.view.View;
import android.widget.RelativeLayout;
import com.linkedin.android.entities.viewholders.EntityTileViewHolder;
import com.linkedin.android.entities.viewholders.MultiTileViewHolder;
import com.linkedin.android.entities.viewmodels.items.EntityTileViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.ArrayList;
import java.util.List;

public final class MultiTileCardViewModel
  extends EntityBaseCardViewModel<MultiTileViewHolder>
{
  public boolean hasInsight = true;
  public String header;
  public int maxTilesWhenCollapsed;
  public final List<EntityTileViewModel> tiles = new ArrayList();
  public TrackingClosure<Void, Void> viewAllClosure;
  public String viewAllText;
  
  private void bindTile$774a2da6(MediaCenter paramMediaCenter, RelativeLayout paramRelativeLayout, EntityTileViewModel paramEntityTileViewModel)
  {
    hasInsight = hasInsight;
    paramEntityTileViewModel.onBindViewHolder$305816fb(paramMediaCenter, (EntityTileViewHolder)paramEntityTileViewModel.getCreator().createViewHolder(paramRelativeLayout));
  }
  
  public final ViewHolderCreator<MultiTileViewHolder> getCreator()
  {
    return MultiTileViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.cards.MultiTileCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */