package com.linkedin.android.growth.newtovoyager.banner;

import android.view.View.OnClickListener;
import com.linkedin.android.identity.me.notifications.cards.MeCardInfo;
import com.linkedin.android.identity.me.notifications.cards.MeCardTrackingViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public final class NewToVoyagerMeCardTrackingViewModel
  extends MeCardTrackingViewModel<NewToVoyagerCardMeViewHolder>
{
  public CustomTrackImpressionListener customTrackImpressionListener;
  public View.OnClickListener deleteButtonClickListener;
  public String heading;
  public String legoTrackingToken;
  public String subheading;
  
  public NewToVoyagerMeCardTrackingViewModel(MeCardInfo paramMeCardInfo)
  {
    super(paramMeCardInfo);
  }
  
  public final ViewHolderCreator<NewToVoyagerCardMeViewHolder> getCreator()
  {
    return NewToVoyagerCardMeViewHolder.CREATOR;
  }
  
  public final TrackingEventBuilder onTrackImpression(ImpressionData paramImpressionData)
  {
    if ((customTrackImpressionListener != null) && (legoTrackingToken != null)) {
      customTrackImpressionListener.emit(legoTrackingToken);
    }
    return super.onTrackImpression(paramImpressionData);
  }
  
  public static abstract interface CustomTrackImpressionListener
  {
    public abstract void emit(String paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerMeCardTrackingViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */