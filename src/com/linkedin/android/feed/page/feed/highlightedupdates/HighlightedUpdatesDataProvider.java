package com.linkedin.android.feed.page.feed.highlightedupdates;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.app.CollectionDataProvider;
import com.linkedin.android.infra.app.CollectionDataProvider.CollectionDataProviderListener;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.collections.CollectionTemplateHelper.CollectionTemplateHelperListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public final class HighlightedUpdatesDataProvider
  extends CollectionDataProvider<State, CollectionDataProvider.CollectionDataProviderListener<CollectionTemplate<Update, Metadata>>>
  implements CollectionTemplateHelper.CollectionTemplateHelperListener<Update>
{
  @Inject
  public HighlightedUpdatesDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
    state).collectionHelper = new CollectionTemplateHelper(paramActivityComponent.dataManager(), this, Update.BUILDER, Metadata.BUILDER);
  }
  
  public final void onFetchingData()
  {
    Iterator localIterator = dataListeners.iterator();
    while (localIterator.hasNext()) {
      ((CollectionDataProvider.CollectionDataProviderListener)localIterator.next()).onFetching();
    }
  }
  
  public final void onFinishedFetchingData()
  {
    Iterator localIterator = dataListeners.iterator();
    while (localIterator.hasNext()) {
      ((CollectionDataProvider.CollectionDataProviderListener)localIterator.next()).onFinishedFetching();
    }
  }
  
  public static final class State
    extends DataProvider.State
  {
    public CollectionTemplateHelper<Update, Metadata> collectionHelper;
    
    public State(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      super(paramBus);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdatesDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */