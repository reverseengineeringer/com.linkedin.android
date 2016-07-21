package com.linkedin.android.feed.actorlist.connectionsdetail;

import android.os.Bundle;
import com.linkedin.android.feed.actorlist.BaseFeedActorListFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.voyager.feed.AggregatedConnectionUpdate;

public final class FeedConnectionUpdatesDetailFragment
  extends BaseFeedActorListFragment
{
  public final int feedType()
  {
    return 11;
  }
  
  protected final void getDataModelsFromBundle(Bundle paramBundle)
  {
    paramBundle = (AggregatedConnectionUpdate)RecordParceler.quietUnparcel(AggregatedConnectionUpdate.BUILDER, "connectionUpdates", paramBundle);
    if (paramBundle != null) {
      pegasusModels = connectionUpdates;
    }
  }
  
  protected final int getDividerStartMargin()
  {
    return 2131493122;
  }
  
  public final String getTitle()
  {
    return fragmentComponent.i18NManager().getString(2131231168);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final String pageKey()
  {
    return "connection_updates_list";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actorlist.connectionsdetail.FeedConnectionUpdatesDetailFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */