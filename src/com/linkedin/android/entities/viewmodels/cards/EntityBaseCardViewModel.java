package com.linkedin.android.entities.viewmodels.cards;

import android.view.View;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.TrackingException;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.litrackinglib.viewport.Mapper;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.List;

public abstract class EntityBaseCardViewModel<ITEM_VIEW_HOLDER extends BaseViewHolder>
  extends ViewModel<ITEM_VIEW_HOLDER>
{
  public String header;
  private int itemViewId;
  public Closure<ImpressionData, TrackingEventBuilder> trackingEventBuilderClosure;
  public List<String> trackingUrns;
  
  public Mapper onBindTrackableViews(Mapper paramMapper, ITEM_VIEW_HOLDER paramITEM_VIEW_HOLDER, int paramInt)
  {
    try
    {
      itemViewId = itemView.getId();
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
  
  public TrackingEventBuilder onTrackImpression(ImpressionData paramImpressionData)
  {
    if (viewId == itemViewId)
    {
      if (trackingEventBuilderClosure == null) {
        return null;
      }
      return (TrackingEventBuilder)trackingEventBuilderClosure.apply(paramImpressionData);
    }
    return super.onTrackImpression(paramImpressionData);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.cards.EntityBaseCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */