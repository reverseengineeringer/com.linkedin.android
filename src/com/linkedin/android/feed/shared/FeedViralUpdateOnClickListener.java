package com.linkedin.android.feed.shared;

import android.os.Bundle;
import com.linkedin.android.feed.detail.FeedUpdateDetailBundleBuilder;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public class FeedViralUpdateOnClickListener
  extends FeedUpdateOnClickListener
{
  private FragmentComponent fragmentComponent;
  private String viralUpdateId;
  
  public FeedViralUpdateOnClickListener(String paramString1, Update paramUpdate, FragmentComponent paramFragmentComponent, int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString2, TrackingEventBuilder... paramVarArgs)
  {
    super(paramUpdate, paramFragmentComponent, paramInt, paramBoolean, paramArrayOfString1, paramArrayOfString2, paramString2, paramVarArgs);
    viralUpdateId = paramString1;
    fragmentComponent = paramFragmentComponent;
  }
  
  protected final FeedUpdateDetailBundleBuilder getUpdateDetailBundleBuilder()
  {
    FeedUpdateDetailBundleBuilder localFeedUpdateDetailBundleBuilder = super.getUpdateDetailBundleBuilder();
    if (!FeedLixHelper.isEnabled(fragmentComponent.lixManager(), Lix.FEED_USE_VIRAL_UPDATE_IN_DETAIL))
    {
      String str = viralUpdateId;
      bundle.putString("viralUpdateUrn", str);
    }
    return localFeedUpdateDetailBundleBuilder;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.FeedViralUpdateOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */