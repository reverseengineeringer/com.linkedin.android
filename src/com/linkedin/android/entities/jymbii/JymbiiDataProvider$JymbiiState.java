package com.linkedin.android.entities.jymbii;

import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Jymbii;

public final class JymbiiDataProvider$JymbiiState
  extends DataProvider.State
{
  CollectionTemplateHelper<Jymbii, CollectionMetadata> jymbiiCollectionHelper;
  
  public JymbiiDataProvider$JymbiiState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
  {
    super(paramFlagshipDataManager, paramBus);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.jymbii.JymbiiDataProvider.JymbiiState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */