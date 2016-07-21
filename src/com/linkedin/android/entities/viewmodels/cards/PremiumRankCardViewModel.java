package com.linkedin.android.entities.viewmodels.cards;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.entities.viewholders.PremiumRankCardViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.TrackingException;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.litrackinglib.viewport.Mapper;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellImpressionEvent;

public final class PremiumRankCardViewModel
  extends EntityBaseCardViewModel<PremiumRankCardViewHolder>
{
  public View.OnClickListener cardOnClickListener;
  public String companyGrowthText;
  public String description;
  public String linkText;
  public String noOfApplicantText;
  public Closure<ImpressionData, TrackingEventBuilder<PremiumUpsellImpressionEvent>> premiumUpsellTrackingClosure;
  public String topRankText;
  public String value;
  
  private Mapper onBindTrackableViews(Mapper paramMapper, PremiumRankCardViewHolder paramPremiumRankCardViewHolder, int paramInt)
  {
    super.onBindTrackableViews(paramMapper, paramPremiumRankCardViewHolder, paramInt);
    try
    {
      paramMapper.bindTrackableViews(new View[] { cardLayout });
      return paramMapper;
    }
    catch (TrackingException localTrackingException)
    {
      cardLayout.getContext();
      Util.safeThrow$7a8b4789(new RuntimeException(localTrackingException));
    }
    return paramMapper;
  }
  
  public final ViewHolderCreator<PremiumRankCardViewHolder> getCreator()
  {
    return PremiumRankCardViewHolder.CREATOR;
  }
  
  public final TrackingEventBuilder onTrackImpression(ImpressionData paramImpressionData)
  {
    if (viewId == 2131755438)
    {
      if (premiumUpsellTrackingClosure == null) {
        return null;
      }
      return (TrackingEventBuilder)premiumUpsellTrackingClosure.apply(paramImpressionData);
    }
    return super.onTrackImpression(paramImpressionData);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.cards.PremiumRankCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */