package com.linkedin.android.entities.viewmodels.items;

import android.widget.RelativeLayout;
import com.linkedin.android.entities.viewholders.EntityTileViewHolder;
import com.linkedin.android.entities.viewholders.RowTilesViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;

public final class RowTilesViewModel
  extends EntityBaseItemViewModel<RowTilesViewHolder>
{
  public boolean hasInsight = true;
  public EntityTileViewModel tileLeft;
  public EntityTileViewModel tileRight;
  
  private void bindTile$774a2da6(MediaCenter paramMediaCenter, RelativeLayout paramRelativeLayout, EntityTileViewModel paramEntityTileViewModel)
  {
    hasInsight = hasInsight;
    paramEntityTileViewModel.onBindViewHolder$305816fb(paramMediaCenter, (EntityTileViewHolder)paramEntityTileViewModel.getCreator().createViewHolder(paramRelativeLayout));
  }
  
  public final ViewHolderCreator<RowTilesViewHolder> getCreator()
  {
    return RowTilesViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.items.RowTilesViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */