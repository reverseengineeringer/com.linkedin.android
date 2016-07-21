package com.linkedin.android.feed.page.feed.highlightedupdates;

import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class HighlightedUpdatesDataProvider$State
  extends DataProvider.State
{
  public CollectionTemplateHelper<Update, Metadata> collectionHelper;
  
  public HighlightedUpdatesDataProvider$State(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
  {
    super(paramFlagshipDataManager, paramBus);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdatesDataProvider.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */