package com.linkedin.android.feed.shared.liking;

import android.support.v4.util.ArrayMap;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.MeUpdatedEvent;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.pegasus.gen.voyager.common.Me;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.SponsoredMetadata;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.consistency.DefaultConsistencyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.Subscribe;

public final class LikePublisher
{
  public final Set<String> activeRequesters = new HashSet();
  public final FlagshipApplication app;
  public final Bus bus;
  public final Map<String, DefaultConsistencyListener> cmListeners = new ArrayMap();
  public final ConsistencyManager consistencyManager;
  public final FlagshipDataManager dataManager;
  public final Map<String, LikeActionRequester> likeRequesters = new ArrayMap();
  public final LixManager lixManager;
  public MiniProfile memberProfile;
  private final Map<String, PendingLike> pendingLikes = new ArrayMap();
  
  public LikePublisher(FlagshipApplication paramFlagshipApplication, FlagshipDataManager paramFlagshipDataManager, ConsistencyManager paramConsistencyManager, Bus paramBus, MemberUtil paramMemberUtil, LixManager paramLixManager)
  {
    app = paramFlagshipApplication;
    dataManager = paramFlagshipDataManager;
    consistencyManager = paramConsistencyManager;
    lixManager = paramLixManager;
    bus = paramBus;
    memberProfile = paramMemberUtil.getMiniProfile();
    Bus.subscribe(this);
  }
  
  public final void enqueueLikeToggle(String paramString, SocialDetail paramSocialDetail, Map<String, String> paramMap, int paramInt, SponsoredMetadata paramSponsoredMetadata)
  {
    if (!totalSocialActivityCounts.liked) {}
    for (boolean bool = true;; bool = false)
    {
      PendingLike localPendingLike = (PendingLike)pendingLikes.get(paramString);
      if (localPendingLike == null) {
        break;
      }
      if (bool != like) {
        pendingLikes.remove(paramString);
      }
      return;
    }
    pendingLikes.put(paramString, new PendingLike(paramSocialDetail, paramMap, bool, paramInt, paramSponsoredMetadata, (byte)0));
  }
  
  @Subscribe
  public final void onEvent(MeUpdatedEvent paramMeUpdatedEvent)
  {
    memberProfile = me.miniProfile;
    MiniProfile localMiniProfile = memberProfile;
    Iterator localIterator = pendingLikes.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localIterator.remove();
      if (str != null)
      {
        PendingLike localPendingLike = (PendingLike)pendingLikes.get(str);
        if (localPendingLike != null)
        {
          LikeActionRequester localLikeActionRequester = (LikeActionRequester)likeRequesters.get(str);
          paramMeUpdatedEvent = localLikeActionRequester;
          if (localLikeActionRequester == null)
          {
            paramMeUpdatedEvent = new LikeActionRequester(app, dataManager, consistencyManager, lixManager, bus, localMiniProfile, socialDetail, likeSource, sponsoredMetadata);
            likeRequesters.put(str, paramMeUpdatedEvent);
          }
          paramMeUpdatedEvent.setState(like, trackingHeader);
        }
      }
    }
  }
  
  private static final class PendingLike
  {
    final boolean like;
    int likeSource;
    final SocialDetail socialDetail;
    final SponsoredMetadata sponsoredMetadata;
    final Map<String, String> trackingHeader;
    
    private PendingLike(SocialDetail paramSocialDetail, Map<String, String> paramMap, boolean paramBoolean, int paramInt, SponsoredMetadata paramSponsoredMetadata)
    {
      socialDetail = paramSocialDetail;
      trackingHeader = paramMap;
      like = paramBoolean;
      likeSource = paramInt;
      sponsoredMetadata = paramSponsoredMetadata;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.liking.LikePublisher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */