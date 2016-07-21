package com.linkedin.android.feed.page.feed.highlightedupdates;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.app.CollectionDataProvider.CollectionDataProviderListener;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.Iterator;
import java.util.List;

public final class HighlightedUpdatesDataProvider$1
  extends DefaultModelListener<CollectionTemplate<Update, Metadata>>
{
  public HighlightedUpdatesDataProvider$1(HighlightedUpdatesDataProvider paramHighlightedUpdatesDataProvider, String paramString) {}
  
  public final void onNetworkError(DataManagerException paramDataManagerException)
  {
    Iterator localIterator = HighlightedUpdatesDataProvider.access$300(this$0).iterator();
    while (localIterator.hasNext()) {
      ((CollectionDataProvider.CollectionDataProviderListener)localIterator.next()).onInitialFetchFinished(null, DataStore.Type.NETWORK, paramDataManagerException, val$rumSessionId);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdatesDataProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */