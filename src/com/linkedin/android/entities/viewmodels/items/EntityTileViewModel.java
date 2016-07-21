package com.linkedin.android.entities.viewmodels.items;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.linkedin.android.entities.viewholders.EntityTileViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.makeramen.roundedimageview.RoundedImageView;

public final class EntityTileViewModel
  extends ViewModel<EntityTileViewHolder>
{
  public String detail;
  public ImageModel detailIcon;
  public boolean hasInsight;
  public ImageModel icon;
  public TrackingClosure<ImageView, Void> onPrimaryClick;
  public String subtitle;
  public int subtitleMaxLines;
  public int tileHeight;
  public String title;
  public int titleMaxLines;
  public boolean wrapInsideCard;
  
  public final ViewHolderCreator<EntityTileViewHolder> getCreator()
  {
    if (wrapInsideCard) {
      return EntityTileViewHolder.CREATOR_TILE_IN_CARD;
    }
    return EntityTileViewHolder.CREATOR_TILE;
  }
  
  public final void onBindViewHolder$305816fb(MediaCenter paramMediaCenter, final EntityTileViewHolder paramEntityTileViewHolder)
  {
    if ((root != null) && (tileHeight > 0)) {
      root.getLayoutParams().height = tileHeight;
    }
    icon.setImageView(paramMediaCenter, icon);
    if (titleMaxLines > 0) {
      title.setMaxLines(titleMaxLines);
    }
    if (subtitleMaxLines > 0) {
      subtitle.setMaxLines(subtitleMaxLines);
    }
    ViewUtils.setTextAndUpdateVisibility(title, title);
    ViewUtils.setTextAndUpdateVisibility(subtitle, subtitle);
    itemView.setOnClickListener(new TrackingOnClickListener(onPrimaryClick.tracker, onPrimaryClick.controlName, new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        onPrimaryClick.apply(paramEntityTileViewHoldericon);
      }
    });
    if ((hasInsight) && (detail != null))
    {
      detailDivider.setVisibility(0);
      ViewUtils.setTextAndUpdateVisibility(detail, detail);
      if (detailIcon != null)
      {
        detailIcon.setImageView(paramMediaCenter, detailIcon);
        return;
      }
      detailIcon.setVisibility(8);
      return;
    }
    detailDivider.setVisibility(8);
    detail.setVisibility(8);
    detailIcon.setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.items.EntityTileViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */