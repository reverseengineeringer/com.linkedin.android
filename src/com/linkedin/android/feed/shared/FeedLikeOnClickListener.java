package com.linkedin.android.feed.shared;

import android.view.View;
import com.linkedin.android.feed.shared.liking.LikeActionRequester;
import com.linkedin.android.feed.shared.liking.LikePublisher;
import com.linkedin.android.feed.shared.liking.LikePublisher.1;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.SponsoredMetadata;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.consistency.DefaultConsistencyListener;
import java.util.Map;
import java.util.Set;

public class FeedLikeOnClickListener
  extends TrackingOnClickListener
{
  private final LikePublisher likePublisher;
  private final int likeSource;
  private final SocialDetail socialDetail;
  private SponsoredMetadata sponsoredMetadata;
  private final Tracker tracker;
  
  private FeedLikeOnClickListener(SocialDetail paramSocialDetail, FragmentComponent paramFragmentComponent, String paramString, int paramInt, SponsoredMetadata paramSponsoredMetadata, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    likePublisher = paramFragmentComponent.likePublisher();
    socialDetail = paramSocialDetail;
    tracker = paramFragmentComponent.tracker();
    likeSource = paramInt;
    sponsoredMetadata = paramSponsoredMetadata;
  }
  
  public FeedLikeOnClickListener(SocialDetail paramSocialDetail, FragmentComponent paramFragmentComponent, String paramString, SponsoredMetadata paramSponsoredMetadata, TrackingEventBuilder... paramVarArgs)
  {
    this(paramSocialDetail, paramFragmentComponent, paramString, 0, paramSponsoredMetadata, paramVarArgs);
  }
  
  public FeedLikeOnClickListener(SocialDetail paramSocialDetail, FragmentComponent paramFragmentComponent, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    this(paramSocialDetail, paramFragmentComponent, paramString, 0, null, paramVarArgs);
  }
  
  public FeedLikeOnClickListener(SocialDetail paramSocialDetail, FragmentComponent paramFragmentComponent, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, byte paramVarArgs)
  {
    this(paramSocialDetail, paramFragmentComponent, paramString, 1, null, paramArrayOfTrackingEventBuilder);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    LikePublisher localLikePublisher = likePublisher;
    SocialDetail localSocialDetail = socialDetail;
    Map localMap = Tracker.createPageInstanceHeader(tracker.getCurrentPageInstance());
    int i = likeSource;
    SponsoredMetadata localSponsoredMetadata = sponsoredMetadata;
    if (entityUrn == null) {
      Util.safeThrow$7a8b4789(new RuntimeException("can't like this update with no entity urn: " + localSocialDetail.toString()));
    }
    for (;;)
    {
      return;
      String str = entityUrn.toString();
      if (memberProfile == null)
      {
        localLikePublisher.enqueueLikeToggle(str, localSocialDetail, localMap, i, localSponsoredMetadata);
        return;
      }
      paramView = (DefaultConsistencyListener)cmListeners.remove(str);
      if (paramView != null) {
        consistencyManager.removeListener(paramView);
      }
      paramView = new LikePublisher.1(localLikePublisher, localSocialDetail, str);
      cmListeners.put(str, paramView);
      consistencyManager.listenForUpdates(paramView);
      LikeActionRequester localLikeActionRequester = (LikeActionRequester)likeRequesters.get(str);
      paramView = localLikeActionRequester;
      if (localLikeActionRequester == null)
      {
        if (memberProfile != null) {
          break label261;
        }
        localLikePublisher.enqueueLikeToggle(str, localSocialDetail, localMap, i, localSponsoredMetadata);
        paramView = null;
      }
      while (paramView != null)
      {
        activeRequesters.add(str);
        paramView.toggle(localMap);
        activeRequesters.remove(str);
        return;
        label261:
        paramView = new LikeActionRequester(app, dataManager, consistencyManager, lixManager, bus, memberProfile, localSocialDetail, i, localSponsoredMetadata);
        likeRequesters.put(str, paramView);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.FeedLikeOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */