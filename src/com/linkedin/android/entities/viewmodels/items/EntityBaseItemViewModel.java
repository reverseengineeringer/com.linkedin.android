package com.linkedin.android.entities.viewmodels.items;

import android.view.LayoutInflater;
import android.view.View;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.TrackingException;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.litrackinglib.viewport.Mapper;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public abstract class EntityBaseItemViewModel<ITEM_VIEW_HOLDER extends BaseViewHolder>
  extends ViewModel<ITEM_VIEW_HOLDER>
{
  public Closure<ImpressionData, TrackingEventBuilder> trackingEventBuilderClosure;
  
  public final Mapper onBindTrackableViews(Mapper paramMapper, ITEM_VIEW_HOLDER paramITEM_VIEW_HOLDER, int paramInt)
  {
    if (trackingEventBuilderClosure != null) {}
    try
    {
      paramMapper.bindTrackableViews(new View[] { itemView });
      return paramMapper;
    }
    catch (TrackingException localTrackingException)
    {
      itemView.getContext();
      Util.safeThrow$7a8b4789(new RuntimeException(localTrackingException));
    }
    return paramMapper;
  }
  
  public void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, ITEM_VIEW_HOLDER paramITEM_VIEW_HOLDER)
  {
    resetLayoutSpecs(paramITEM_VIEW_HOLDER);
  }
  
  public void onRecycleViewHolder(ITEM_VIEW_HOLDER paramITEM_VIEW_HOLDER)
  {
    trackingEventBuilderClosure = null;
  }
  
  public final TrackingEventBuilder onTrackImpression(ImpressionData paramImpressionData)
  {
    if (trackingEventBuilderClosure == null) {
      return null;
    }
    return (TrackingEventBuilder)trackingEventBuilderClosure.apply(paramImpressionData);
  }
  
  public abstract void resetLayoutSpecs(ITEM_VIEW_HOLDER paramITEM_VIEW_HOLDER);
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.items.EntityBaseItemViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */