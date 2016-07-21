package com.linkedin.android.feed.actorlist.pymkdetail;

import android.os.Bundle;
import com.linkedin.android.feed.actorlist.BaseFeedActorListFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.voyager.feed.AggregatedPymkUpdate;

public final class FeedPymkUpdatesDetailFragment
  extends BaseFeedActorListFragment
{
  public final int feedType()
  {
    return 12;
  }
  
  protected final void getDataModelsFromBundle(Bundle paramBundle)
  {
    paramBundle = (AggregatedPymkUpdate)RecordParceler.quietUnparcel(AggregatedPymkUpdate.BUILDER, "pymkUpdates", paramBundle);
    if (paramBundle != null) {
      pegasusModels = pymkUpdates;
    }
  }
  
  protected final int getDividerStartMargin()
  {
    return 2131493124;
  }
  
  public final String getTitle()
  {
    return fragmentComponent.i18NManager().getString(2131231274);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final String pageKey()
  {
    return "pymk_list";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actorlist.pymkdetail.FeedPymkUpdatesDetailFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */