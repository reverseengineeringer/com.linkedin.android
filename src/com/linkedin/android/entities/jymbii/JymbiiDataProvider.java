package com.linkedin.android.entities.jymbii;

import android.net.Uri;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Jymbii;
import java.util.Map;
import javax.inject.Inject;

public final class JymbiiDataProvider
  extends DataProvider<JymbiiState, DataProvider.DataProviderListener>
{
  public static final String JYMBII_ROUTE = Routes.JYMBII.buildUponRoot().toString();
  
  @Inject
  public JymbiiDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
    state).jymbiiCollectionHelper = new CollectionTemplateHelper(activityComponent.dataManager(), null, Jymbii.BUILDER, CollectionMetadata.BUILDER);
  }
  
  public final void fetchInitialJymbii(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    paramString1 = collectionCompletionCallback(paramString1, paramString2, JYMBII_ROUTE, 2);
    if (state).jymbiiCollectionHelper == null) {
      state).jymbiiCollectionHelper = new CollectionTemplateHelper(activityComponent.dataManager(), null, Jymbii.BUILDER, CollectionMetadata.BUILDER);
    }
    state).jymbiiCollectionHelper.fetchInitialData(paramMap, 3, JYMBII_ROUTE, paramString1, paramString2);
  }
  
  public static final class JymbiiState
    extends DataProvider.State
  {
    CollectionTemplateHelper<Jymbii, CollectionMetadata> jymbiiCollectionHelper;
    
    public JymbiiState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      super(paramBus);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.jymbii.JymbiiDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */